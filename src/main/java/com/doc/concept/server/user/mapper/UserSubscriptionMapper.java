package com.doc.concept.server.user.mapper;

import com.doc.concept.server.user.model.SubscriptionType;
import com.doc.concept.server.user.model.UserSubscription;
import com.doc.concept.server.user.model.dto.SubscriptionTypeDTO;
import com.doc.concept.server.user.model.dto.UserSubscriptionDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserSubscriptionMapper {
    UserSubscriptionDTO userSubscriptionTouserSubscriptionDTO(UserSubscription userSubscription);
}
