package com.doc.des.server.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "project")
public class ProjectEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
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
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "project",
			fetch=FetchType.EAGER) // entity in Orders
	private List<ProjectInvolveEntity> users;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGendre() {
		return gendre;
	}
	public void setGendre(String gendre) {
		this.gendre = gendre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<ProjectInvolveEntity> getUsers() {
		return users;
	}
	public void setUsers(List<ProjectInvolveEntity> users) {
		this.users = users;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	
}
