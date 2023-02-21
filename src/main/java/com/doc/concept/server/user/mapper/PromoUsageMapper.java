package com.doc.concept.server.user.mapper;

import com.doc.concept.server.user.model.PromoUsage;
import com.doc.concept.server.user.model.dto.PromoUsageDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PromoUsageMapper {
    PromoUsageDTO PromoUsageToPromoUsageDTO(PromoUsage promoUsage);
}
