package com.doc.des.server.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "privilege_entity")
public class PrivilegeEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Column(length=64, nullable=false, unique=false)
    private String name;
    @OneToMany(mappedBy = "privilege")
    private List<RolesEntity> roles;    
    
	public PrivilegeEntity() {
		super();
	}
	public PrivilegeEntity(String name) {
		super();
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<RolesEntity> getRoles() {
		return roles;
	}
	public void setRoles(List<RolesEntity> roles) {
		this.roles = roles;
	}
    
    
}
