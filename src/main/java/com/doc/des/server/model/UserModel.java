package com.doc.des.server.model;

import java.util.List;

import com.doc.des.server.entity.ProjectInvolveEntity;
import com.doc.des.server.entity.UserEntity;

public class UserModel extends ShortUserModel{
	private List<ProjectInvolveEntity> projectInvolved;
	private String email;
	private String phone;
	private String imageUrl;
	
	public static UserModel toModel(UserEntity entity) {
		UserModel model= new UserModel();
		model.setLogin(entity.getLogin());
		model.setName(entity.getName());
		model.setSurname(entity.getSurname());
		model.setEmail(entity.getEmail());
		model.setPhone(entity.getPhone());
		return model;
	}

	public List<ProjectInvolveEntity> getProjectInvolved() {
		return projectInvolved;
	}

	public void setProjectInvolved(List<ProjectInvolveEntity> projectInvolved) {
		this.projectInvolved = projectInvolved;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}	

}
