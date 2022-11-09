package com.doc.des.server.model;

import com.doc.des.server.entity.RolesEntity;

import lombok.Data;

@Data
public class RolesModel {
	private int id;
	private String name;
	private int projectId;
	private String privilege;
    private long projectRoleId;	
    
    public static RolesModel toModel(RolesEntity entity) {
    	RolesModel model = new RolesModel();
    	model.setId(entity.getId());
    	model.setProjectId(entity.getProjectId());
    	model.setName(entity.getPrivilege().getName());
    	model.setPrivilege(entity.getPrivilege().getName());
    	model.setProjectRoleId(entity.getProjectRole().getId());
    	return model;
    }
}
