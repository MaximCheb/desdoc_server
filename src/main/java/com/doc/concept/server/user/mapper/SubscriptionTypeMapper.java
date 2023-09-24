package com.doc.concept.server.user.mapper;

import com.doc.concept.server.user.model.SubscriptionType;
import com.doc.concept.server.user.model.User;
import com.doc.concept.server.user.model.dto.SubscriptionTypeDTO;
import com.doc.concept.server.user.model.dto.UserDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SubscriptionTypeMapper {
    SubscriptionTypeDTO SubscriptionTypeToSubscriptionTypeDTO(SubscriptionType subscriptionType);
}
