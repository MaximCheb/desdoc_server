package com.doc.concept.server.project.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.doc.concept.server.data.model.ProjectAdditional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "project", name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length=32, nullable=false, unique=false)
	private String name;
	@Column(length=32, nullable=false, unique=false)
	private String author;
	@Column(length=255, nullable=false, unique=false)
	private String description;
	@Column(length=32, nullable=false, unique=false)
	private String gendre;
	@Column(length=32, nullable=false, unique=false)
	private String type;
	@Column(length=128, nullable=false, unique=false)
	private String icon;
	@Column(length=128, nullable=true, unique=false)
	private String parent;
	@Column( nullable=true, unique=false)
	private boolean active;
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "project",
			fetch=FetchType.EAGER) // entity in Orders
	private List<ProjectInvolve> involves;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_additional_id", referencedColumnName = "id")
	private ProjectAdditional projectAdditional;
	
}
