package com.doc.concept.server.user.service;

import com.doc.concept.server.user.mapper.UserSubscriptionMapper;
import com.doc.concept.server.user.model.UserSubscription;
import com.doc.concept.server.user.model.dto.UserSubscriptionDTO;
import com.doc.concept.server.user.repository.UserSubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSubscriptionService {
    final private UserSubscriptionMapper subscriptionMapper;
    final private UserSubscriptionRepository subscriptionRepository;

    public List<UserSubscription> getAll() {
        List<UserSubscription> subscriptions = subscriptionRepository.findAll();
        return subscriptionRepository.findAll();
    }


    public UserSubscriptionDTO getOne(long id) {
        var subscription = subscriptionRepository.findById(id);
        return subscriptionMapper.userSubscriptionTouserSubscriptionDTO(subscriptionRepository.findById(id).get());
    }
    public long create(UserSubscription subscription){
        return subscriptionRepository.save(subscription).getId();
    }
    public void delete(Long id){
        subscriptionRepository.deleteById(id);
    }
}
