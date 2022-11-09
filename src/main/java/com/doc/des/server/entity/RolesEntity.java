package com.doc.des.server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "roles")
public class RolesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int projectId;	
	@ManyToOne
	@JoinColumn(name="privilege_id", nullable=true)
    private PrivilegeEntity privilege;
	@ManyToOne
	@JoinColumn(name="involved_id", nullable=true)
    private ProjectInvolveEntity projectRole;	
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PrivilegeEntity getPrivilege() {
		return privilege;
	}
	public void setPrivilege(PrivilegeEntity privileges) {
		this.privilege = privileges;
	}
	public ProjectInvolveEntity getProjectRole() {
		return projectRole;
	}
	public void setProjectRole(ProjectInvolveEntity projectRole) {
		this.projectRole = projectRole;
	}	
	
}
