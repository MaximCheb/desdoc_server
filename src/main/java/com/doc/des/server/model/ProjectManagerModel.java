package com.doc.des.server.model;

import java.util.Date;

import lombok.Data;

@Data
public class ProjectManagerModel {
	private ProjectModel project;
	private UserModel magager;
	private Date date_start;
	private Date date_realize;
	private String version;
}
