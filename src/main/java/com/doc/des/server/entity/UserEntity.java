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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.doc.des.server.model.ProjectModel;


@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=32, nullable=false, unique=false)
	private String login;
	@Column(length=128, nullable=false, unique=false)
	private String password;
	@Column(length=64, nullable=false, unique=false)
	private String name;
	@Column(length=64, nullable=false, unique=false)
	private String surname;
	@OneToMany(targetEntity=ProjectInvolveEntity.class,mappedBy="user",fetch=FetchType.EAGER)	 // внешний ключ
	private List<ProjectInvolveEntity> project;
	@OneToMany(targetEntity=ProjectInvolveEntity.class,mappedBy="user",fetch=FetchType.EAGER)	 // внешний ключ
	private List<UserSubscriptionEntity> subscription;
	@Column(length=64, nullable=false, unique=false)
	private String email;
	@Column(length=64, nullable=false, unique=false)
	private String phone;
	private String imageUrl;
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserEntity(String login, String email, String password) {
		this.login = login;
		this.email = email;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<ProjectInvolveEntity> getProjectInvolved() {
		return project;
	}
	public void setProjectInvolved(List<ProjectInvolveEntity> project) {
		this.project = project;
	}	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
