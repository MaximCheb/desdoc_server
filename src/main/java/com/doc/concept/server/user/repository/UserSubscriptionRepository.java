package com.doc.concept.server.user.repository;

import com.doc.concept.server.user.model.SubscriptionType;
import com.doc.concept.server.user.model.User;
import com.doc.concept.server.user.model.UserSubscription;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserSubscriptionRepository extends CrudRepository<UserSubscription, Long> {
    List<UserSubscription> findAll();
    List<UserSubscription> findAllByUser(User user);
    List<UserSubscription> findAllBySubscriptionType(SubscriptionType subscriptionType);
}
