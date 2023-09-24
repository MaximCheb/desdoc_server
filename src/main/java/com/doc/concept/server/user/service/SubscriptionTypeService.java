package com.doc.concept.server.user.service;

import com.doc.concept.server.user.mapper.SubscriptionTypeMapper;
import com.doc.concept.server.user.model.SubscriptionType;
import com.doc.concept.server.user.model.dto.SubscriptionTypeDTO;
import com.doc.concept.server.user.repository.SubscriptionTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SubscriptionTypeService {
    final private SubscriptionTypeMapper subscriptionTypeMapper;
    final private SubscriptionTypeRepository subscriptionTypeRepository;

    public List<SubscriptionType> getAll() {
        List<SubscriptionType> subscriptionTypes = subscriptionTypeRepository.findAll();
        return subscriptionTypeRepository.findAll();
    }

    public SubscriptionTypeDTO getByName(String name) {
        return subscriptionTypeMapper.SubscriptionTypeToSubscriptionTypeDTO(subscriptionTypeRepository.findByName(name));
    }

    public SubscriptionTypeDTO getOne(long id) {
        var subscriptionType = subscriptionTypeRepository.findById(id);
        return subscriptionTypeMapper.SubscriptionTypeToSubscriptionTypeDTO(subscriptionTypeRepository.findById(id).get());
    }
    public long create(SubscriptionType subscriptionType){
        return subscriptionTypeRepository.save(subscriptionType).getId();
    }
    public void delete(Long id){
        subscriptionTypeRepository.deleteById(id);
    }

}
