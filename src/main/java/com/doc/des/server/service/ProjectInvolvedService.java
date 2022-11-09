package com.doc.des.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc.des.server.entity.ProjectInvolveEntity;
import com.doc.des.server.exception.AlreadyExistException;
import com.doc.des.server.model.ProjectInvolveModel;
import com.doc.des.server.repository.ProjectInvolveRepository;

@Service
public class ProjectInvolvedService {
	@Autowired
	ProjectInvolveRepository involveRepository;
 
	public void create(ProjectInvolveEntity projectInvolve) {
		involveRepository.save(projectInvolve);		
	}
 
	public List<ProjectInvolveModel> getAll() {
		ArrayList<ProjectInvolveModel> models = new ArrayList<ProjectInvolveModel>();
		for(ProjectInvolveEntity entity : involveRepository.findAll()) {
			models.add(ProjectInvolveModel.toModel(entity));
		}
		return models;
	}

	public List<ProjectInvolveEntity> getByUserId(long id) {
		return involveRepository.findAllByUserId(id);        		
	}
	
	public List<ProjectInvolveEntity> getByProject(long projectId) {
        return involveRepository.findAllByProjectId(projectId);
    }
 
	public ProjectInvolveEntity getOne(long id) {
	    ProjectInvolveEntity involveEntity = involveRepository.findById(id);
	    involveEntity.getProject().setUsers(null);
	    involveEntity.setRoles(null);
		return involveRepository.findById(id);
	}
     
	public ProjectInvolveEntity updateProject(ProjectInvolveEntity entity) throws AlreadyExistException {
		return involveRepository.save(entity);
	}
	
}
