package com.doc.concept.server.project.mapper;
import com.doc.concept.server.project.model.Project;
import com.doc.concept.server.project.model.dto.ProjectDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProjectMapper {
    ProjectDTO ProjectToProjectDTO (Project project);
}
