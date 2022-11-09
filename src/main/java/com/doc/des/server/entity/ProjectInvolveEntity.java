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
    /*
     * extra functionality for the MVP
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	private long userId;
	@Column(length=32, nullable=true, unique=false)
	private String refRole;
	@ManyToOne
    @JoinColumn(name="project_id", nullable=true)
	private ProjectEntity project;
	@OneToMany(mappedBy="projectRole",fetch=FetchType.LAZY)
    private List<RolesEntity > roles;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}	
	public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
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
