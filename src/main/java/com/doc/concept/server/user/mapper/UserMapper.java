package com.doc.concept.server.user.mapper;

import com.doc.concept.server.user.model.User;
import com.doc.concept.server.user.model.dto.UserDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    UserDTO UserToUserDTO(User user);
}
