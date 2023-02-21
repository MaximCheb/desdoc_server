package com.doc.concept.server.project.mapper;

import com.doc.concept.server.project.model.ProjectInvolve;
import com.doc.concept.server.project.model.dto.ProjectInvolveDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProjectInvolveMapper {
    ProjectInvolveDTO ProjectInvolveToProjectInvolveDTO (ProjectInvolve projectInvolve);
}
