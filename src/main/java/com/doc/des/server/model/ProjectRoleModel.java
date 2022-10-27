package com.doc.des.server.model;

import lombok.Data;

@Data
public class ProjectRoleModel {
	private String name;
	private boolean canAddEntities;
	private boolean canWrite;
	private boolean canReadResources;
	private boolean canReadStory;
	private boolean canReadUnit;
	private boolean canReadPlace;
	private boolean canExport;
	private boolean canAddUser;
	private boolean canDeleteUser;
}
