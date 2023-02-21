package com.doc.concept.server.project.model.dto;

import com.doc.concept.server.data.model.dto.ProjectAdditionalDTO;
import com.doc.concept.server.project.model.ProjectInvolve;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDTO {
    private long id;
    private String name;
    private String author;
    private String description;
    private String gendre;
    private String type;
    private String icon;
    private String parent;
    private List<ProjectInvolve> involves;
    private boolean active;
    private ProjectAdditionalDTO projectAdditionalDto;
}
