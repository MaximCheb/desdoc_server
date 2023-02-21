package com.doc.concept.server.user.mapper;

import com.doc.concept.server.user.model.Promo;
import com.doc.concept.server.user.model.dto.PromoDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PromoMapper {
    PromoDTO PromoToPromoDTO(Promo promo);
}
