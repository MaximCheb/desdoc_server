package com.doc.concept.server.project.model;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "project", name = "project_involve")
public class ProjectInvolve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    @Column(length=32, nullable=true, unique=false)
    private String refRole;
    @ManyToOne
    @JoinColumn(name="project_id", nullable=true)
    private Project project;
    @OneToMany(mappedBy="projectInvolve",fetch=FetchType.LAZY)
    private List<Role> roles;
}
