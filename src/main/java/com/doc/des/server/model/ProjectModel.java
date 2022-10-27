package com.doc.des.server.model;

import java.util.ArrayList;
import java.util.List;

import com.doc.des.server.entity.ProjectEntity;
import com.doc.des.server.entity.ProjectInvolveEntity;

import lombok.Data;

@Data
public class ProjectModel {
	private int id;
	private String name;
	private String author;
	private String description;
	private String gendre;
	private String type;
	private String icon;
	private ProjectInvolveModel[] users;
	
	public static ProjectModel toModel(ProjectEntity entity) {
		ProjectModel model = new ProjectModel();
		model.setId(entity.getId());;
		model.setName(entity.getName());
		model.setDescription(entity.getDescription());
		model.setGendre(entity.getGendre());
		model.setType(entity.getType());
		model.setAuthor(entity.getAuthor());
		model.setIcon(entity.getIcon());
		model.setUsers(toModelList(entity.getUsers()));
		return model;
	}
	
	private static ProjectInvolveModel[] toModelList(List<ProjectInvolveEntity> involved) {
		ArrayList<ProjectInvolveModel> models = new ArrayList<ProjectInvolveModel>();
		for(ProjectInvolveEntity involve : involved) {
			models.add(ProjectInvolveModel.toModel(involve));
		}
		return (ProjectInvolveModel[]) models.toArray();
	}
}
