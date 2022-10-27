package com.doc.des.server.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project_involve")
public class ProjectInvolveEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private UserEntity user;
	@Column(length=32, nullable=false, unique=false)
	private String refRole;
	@ManyToOne
    @JoinColumn(name="project_id", nullable=false)
	private ProjectEntity project;
	@OneToMany(mappedBy="projectRole",fetch=FetchType.EAGER)
    private List<RolesEntity > roles;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public ProjectEntity getProject() {
		return project;
	}
	public void setProject(ProjectEntity project) {
		this.project = project;
	}
	public List<RolesEntity > getRoles() {
		return roles;
	}
	public void setRole(List<RolesEntity> roles) {
		this.roles = roles;
	}
	public String getRefRole() {
		return refRole;
	}
	public void setRefRole(String refRole) {
		this.refRole = refRole;
	}
	public void setRoles(List<RolesEntity> roles) {
		this.roles = roles;
	}
	public String getRoleName() {
		return refRole;
	}
	
}
