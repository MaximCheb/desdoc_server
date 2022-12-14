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
    /*
     * extra functionality for the MVP
     * create for command work
     */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	@Column(length=64, nullable=false, unique=false)
    private String name;
     
    
	public PrivilegeEntity() {
		super();
	}
	public PrivilegeEntity(String name) {
		super();
		this.name = name;
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
    
    
}
