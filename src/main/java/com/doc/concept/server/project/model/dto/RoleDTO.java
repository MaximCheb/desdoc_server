package com.doc.concept.server.project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDTO {
    private long id;
    private int projectId;
    private PrivilegeDTO privilege;
    private ProjectInvolveDTO projectInvolve;
}
