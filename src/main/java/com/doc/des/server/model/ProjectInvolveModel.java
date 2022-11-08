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
		ProjectInvolveModel model = new ProjectInvolveModel();
		model.setId(entity.getId());
		model.setProjectName(entity.getProject().getName());
		model.setRoleString((String[]) entity.getRoles().stream().map(RolesEntity::getName).toArray());
		model.setUser(UserModel.toModel(entity.getUser()));
		return model;
	}
}
