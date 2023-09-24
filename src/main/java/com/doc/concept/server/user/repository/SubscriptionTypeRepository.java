package com.doc.concept.server.user.repository;

import com.doc.concept.server.user.model.SubscriptionType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriptionTypeRepository extends CrudRepository<SubscriptionType, Long> {

    SubscriptionType findByName(String name);
    List<SubscriptionType> findAll();
    List<SubscriptionType> findAllByRole(String role);
}
