package com.doc.des.server.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.doc.des.server.model.RoleEnum;
@Entity
@Table(name = "roles")
public class RolesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length=32, nullable=false, unique=false)
	private String name;
	private int projectId;	
	@ManyToOne
	@JoinColumn(name="privilege_id", nullable=false)
    private PrivilegeEntity privilege;
	@ManyToOne
	@JoinColumn(name="involved_id", nullable=false)
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNameEnum(RoleEnum name) {
		this.name = name.name();
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
