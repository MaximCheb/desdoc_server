package com.doc.des.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc.des.server.entity.RolesEntity;
import com.doc.des.server.exception.AlreadyExistException;
import com.doc.des.server.model.RolesModel;
import com.doc.des.server.repository.RolesRepository;

@Service
public class RolesService {
	@Autowired
	RolesRepository rolesRepository;
	
	public List<RolesModel> getAll() {
		ArrayList<RolesModel> models = new ArrayList<RolesModel>();
		for(RolesEntity entity : rolesRepository.findAll()) {
			models.add(RolesModel.toModel(entity));
		}
		return models;
    }

    public RolesModel getByPrivilage(int privilage) {
        return RolesModel.toModel(rolesRepository.findByPrivilegeId(privilage));        		
    }
    
    public RolesEntity getOne(int id) {
        return rolesRepository.findById(id).get();
    }
    
    public RolesEntity getByProjectId(int id) {
        return rolesRepository.findByProjectId(id);
    }
        
    public void create(RolesEntity entity) throws AlreadyExistException {
    	rolesRepository.save(entity);
    }
    
    public void update(RolesEntity entity) throws AlreadyExistException {
    	rolesRepository.save(entity);
    }
    
    public void delete(int id){
    	rolesRepository.deleteById(id);
    }
}
