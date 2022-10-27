package com.doc.des.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc.des.server.entity.ProjectEntity;
import com.doc.des.server.entity.ProjectInvolveEntity;
import com.doc.des.server.exception.AlreadyExistException;
import com.doc.des.server.model.ProjectInvolveModel;
import com.doc.des.server.model.ProjectModel;
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

	public ProjectInvolveModel getByUserId(long id) {
		return ProjectInvolveModel.toModel(involveRepository.findByUserId(id));        		
	}
 
	public ProjectInvolveModel getOne(int id) {
		return ProjectInvolveModel.toModel(involveRepository.findById(id));
	}
     
 
	public ProjectInvolveEntity updateProject(ProjectInvolveEntity entity) throws AlreadyExistException {
		return involveRepository.save(entity);
	}
	
}
