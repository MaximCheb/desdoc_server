package com.doc.concept.server.user.service;

import com.doc.concept.server.user.mapper.PromoUsageMapper;
import com.doc.concept.server.user.model.Promo;
import com.doc.concept.server.user.model.PromoUsage;
import com.doc.concept.server.user.model.dto.PromoUsageDTO;
import com.doc.concept.server.user.repository.PromoRepository;
import com.doc.concept.server.user.repository.PromoUsageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PromoUsageService {
    private final PromoUsageRepository promoUsageRepository;
    private final PromoRepository promoRepository;
    final private PromoUsageMapper promoUsageMapper;
    //TODO rewrite to get
    public PromoUsageDTO getByUserId(long userId) {
        var allPromos = promoUsageRepository.findAllByUserId(userId);
        var now = java.sql.Date.valueOf(String.valueOf(LocalDateTime.now()));
        allPromos.removeIf(promoUsage -> promoUsage.getPromo().getEndPromo().before(now));
        return promoUsageMapper.PromoUsageToPromoUsageDTO(allPromos.stream().findFirst().get());
    }
    public List<PromoUsageDTO> getByPromoCode(String code) {
        var promo = promoRepository.findByCode(code).get();
        return promoUsageRepository.findAllByPromo(promo).stream().map(promoUsageMapper::PromoUsageToPromoUsageDTO).toList();
    }
    public PromoUsageDTO getById(long id) {
        return promoUsageMapper.PromoUsageToPromoUsageDTO(promoUsageRepository.findById(id).get());
    }
    public List<PromoUsageDTO> getByAll() {
        return promoUsageRepository.findAll().stream().map(promoUsageMapper::PromoUsageToPromoUsageDTO).toList();
    }
}
