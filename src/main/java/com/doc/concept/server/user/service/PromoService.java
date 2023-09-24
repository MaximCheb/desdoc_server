package com.doc.concept.server.user.service;

import com.doc.concept.server.exception.PromoAlreadyUsedUserException;
import com.doc.concept.server.user.mapper.PromoMapper;
import com.doc.concept.server.user.model.Promo;
import com.doc.concept.server.user.model.PromoUsage;
import com.doc.concept.server.user.model.User;
import com.doc.concept.server.user.model.UserSubscription;
import com.doc.concept.server.user.model.dto.PromoCodeResponseDto;
import com.doc.concept.server.user.model.dto.PromoDTO;
import com.doc.concept.server.user.repository.PromoRepository;
import com.doc.concept.server.user.repository.PromoUsageRepository;
import com.doc.concept.server.user.repository.UserRepository;
import com.doc.concept.server.user.repository.UserSubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.rmi.NotBoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class PromoService {

    private final PromoRepository promoRepository;
    private final PromoUsageRepository promoUsageRepository;
    private final PromoMapper promoMapper;
    private final UserRepository userRepository;
    private final UserSubscriptionRepository subscriptionRepository;

    public PromoDTO getByCode(String code) {
        return promoMapper.PromoToPromoDTO(promoRepository.findByCode(encodePromo(code)).get());
    }
    public int create(Promo promo) {
        promo.setCode(encodePromo(promo.getCode()));
        return promoRepository.save(promo).getId();
    }
    public PromoDTO getById(int id) {
        return promoMapper.PromoToPromoDTO(promoRepository.findById(id));
    }
    public List<PromoDTO> getAll() {
        var promos = promoRepository.findAll().stream().map(promoMapper::PromoToPromoDTO).toList();
        return promos;
    }

    private String encodePromo(String code) {
        try {
            var md = MessageDigest.getInstance("MD5");
            md.update(code.getBytes());
            byte[] digest = md.digest();
            return DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return code;
    }

    public String tryUsePromoCode(PromoCodeResponseDto codeResponseDto, String username) throws NotBoundException, PromoAlreadyUsedUserException {
        log.info(encodePromo(codeResponseDto.getCode()));
        var promoOrNull = promoRepository.findByCode(encodePromo(codeResponseDto.getCode()));
        var userId = userRepository.findByLogin(username).get().getId();
        if (promoOrNull.isEmpty() || promoOrNull.get().isEnd()) {
            log.error("promo = {}", promoOrNull.isPresent());
            throw new NotBoundException();
        }
        if(promoOrNull.get().getPromos().stream().anyMatch(promoUsage -> promoUsage.getUserId()==userId)){
            log.error("PromoAlreadyUsedUserException");
            throw new PromoAlreadyUsedUserException();
        }
        var promoUsage = PromoUsage.builder()
                .date(Date.valueOf(LocalDate.now()))
                .promo(promoOrNull.get())
                .userId(userId)
                .build();
        log.info("create promo usage = {}", promoUsage.getPromo().getCode());
        if(promoUsageRepository.findAllByPromo(promoOrNull.get()).size()+1>=promoOrNull.get().getNumberUses()) {
            promoOrNull.get().setEnd(true);
        }
        promoUsageRepository.save(promoUsage);
        var role = promoOrNull.get().getPromoSubscription().getRole();
        UserSubscription userSubscription = UserSubscription.builder()
                .role(role)
                .type("promo")
                .subscriptionType(promoOrNull.get().getPromoSubscription())
                .isContinue(Date.valueOf(LocalDate.now()))
                .dateEnd(promoOrNull.get().getEndPromo())
                .user(User.builder().id(userId).build())
                .build();
        subscriptionRepository.save(userSubscription);
        return role;
    }
}
