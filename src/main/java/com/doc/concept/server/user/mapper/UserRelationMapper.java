package com.doc.concept.server.user.mapper;

import com.doc.concept.server.user.model.UserRelation;
import com.doc.concept.server.user.model.dto.UserRelationDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserRelationMapper {
    UserRelationDTO UserRelationToUserRelationDTO (UserRelation relation);
}
