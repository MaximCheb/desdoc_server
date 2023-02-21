package com.doc.concept.server.project.mapper;

import com.doc.concept.server.project.model.Role;
import com.doc.concept.server.project.model.dto.RoleDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RolesMapper {
    RoleDTO RolesToRolesDTO (Role role);
}
