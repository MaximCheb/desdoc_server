package com.doc.des.server.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//@Entity
//@Table(name = "project_stages")
//public class ProjectStageEntity {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
//	@Column(length=32, nullable=false, unique=false)
//	private ProjectEntity project;
//	@Column(length=64, nullable=false, unique=false)
//	private String name;
////	private UserEntity executor;
//	private boolean isContinue;
//	private Date date;
//	private int prev_stage;
//	private int next_stage;
//	private Date plan_start;
//	private Date plan_length;
//	@Column(length=32, nullable=false, unique=false)
//	private String element_name;
//	private boolean notification;
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public ProjectEntity getProject() {
//		return project;
//	}
//	public void setProject(ProjectEntity project) {
//		this.project = project;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public UserEntity getExecutor() {
//		return executor;
//	}
//	public void setExecutor(UserEntity executor) {
//		this.executor = executor;
//	}
//	public boolean isContinue() {
//		return isContinue;
//	}
//	public void setContinue(boolean isContinue) {
//		this.isContinue = isContinue;
//	}
//	public Date getDate() {
//		return date;
//	}
//	public void setDate(Date date) {
//		this.date = date;
//	}
//	public int getPrev_stage() {
//		return prev_stage;
//	}
//	public void setPrev_stage(int prev_stage) {
//		this.prev_stage = prev_stage;
//	}
//	public int getNext_stage() {
//		return next_stage;
//	}
//	public void setNext_stage(int next_stage) {
//		this.next_stage = next_stage;
//	}
//	public Date getPlan_start() {
//		return plan_start;
//	}
//	public void setPlan_start(Date plan_start) {
//		this.plan_start = plan_start;
//	}
//	public Date getPlan_length() {
//		return plan_length;
//	}
//	public void setPlan_length(Date plan_length) {
//		this.plan_length = plan_length;
//	}
//	public String getElement_name() {
//		return element_name;
//	}
//	public void setElement_name(String element_name) {
//		this.element_name = element_name;
//	}
//	public boolean isNotification() {
//		return notification;
//	}
//	public void setNotification(boolean notification) {
//		this.notification = notification;
//	}
//	
//}
