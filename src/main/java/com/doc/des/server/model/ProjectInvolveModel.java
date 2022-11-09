package com.doc.des.server.model;

import java.util.ArrayList;
import java.util.List;

import com.doc.des.server.entity.ProjectInvolveEntity;
import com.doc.des.server.entity.RolesEntity;

import lombok.Data;

@Data
public class ProjectInvolveModel {
	private long id;
	private long userId;
	private String ProjectName;
	private String[] roleString;
	
	public static ProjectInvolveModel toModel(ProjectInvolveEntity entity) {
	    List<String>roleNames = new ArrayList<String>();
		ProjectInvolveModel model = new ProjectInvolveModel();
		model.setId(entity.getId());
		model.setProjectName(entity.getProject().getName());
		entity.getRoles().forEach(role->roleNames.add(role.getPrivilege().getName()));
		model.setRoleString((String[]) roleNames.toArray());
		model.setUserId(entity.getUserId());
		return model;
	}
}
