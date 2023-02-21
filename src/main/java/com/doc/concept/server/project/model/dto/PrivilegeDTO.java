package com.doc.concept.server.project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrivilegeDTO {
    private int id;
    private String name;
}
