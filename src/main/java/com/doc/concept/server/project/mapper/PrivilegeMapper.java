package com.doc.concept.server.project.mapper;
import com.doc.concept.server.project.model.Privilege;
import com.doc.concept.server.project.model.dto.PrivilegeDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PrivilegeMapper {
    PrivilegeDTO PrivilegeToPrivilegeDTO (Privilege privilege);
}
