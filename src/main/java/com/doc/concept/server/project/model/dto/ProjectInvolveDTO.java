package com.doc.concept.server.project.model.dto;

import com.doc.concept.server.project.model.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectInvolveDTO {
    private long id;
    private long userId;
    private String refRole;
    private Project project;
    private List<RoleDTO> roles;
}
