package com.doc.des.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc.des.server.entity.ProjectEntity;
import com.doc.des.server.entity.RolesEntity;
import com.doc.des.server.exception.AlreadyExistException;
import com.doc.des.server.model.ProjectModel;
import com.doc.des.server.repository.ProjectRepository;
import com.doc.des.server.repository.RolesRepository;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	
	public List<ProjectModel> getAll() {
		ArrayList<ProjectModel> models = new ArrayList<ProjectModel>();
		for(ProjectEntity entity : projectRepository.findAll()) {
			models.add(ProjectModel.toModel(entity));
		}
		return models;
    }
	

    public List<ProjectModel>  getByAuthor(String author) {
    	ArrayList<ProjectModel> models = new ArrayList<ProjectModel>();
		for(ProjectEntity entity : projectRepository.findAllByAuthor(author)) {
			models.add(ProjectModel.toModel(entity));
		}
		return models;       		
    }
    
    public ProjectModel getOne(int id) {
        return ProjectModel.toModel(projectRepository.findById(id));
    }
        
    public ProjectEntity createProject(ProjectEntity entity) throws AlreadyExistException {
    	return projectRepository.save(entity);
    }
    
    public ProjectEntity updateProject(ProjectEntity entity) throws AlreadyExistException {
    	return projectRepository.save(entity);
    }
    
    public boolean create(ProjectEntity project) throws AlreadyExistException {        
        if(projectRepository.findByName(project.getName())!=null) throw new AlreadyExistException("Project exist");;
        projectRepository.save(project);
        return true;
    }
    public void delete(ProjectEntity entity) {
    	projectRepository.delete(entity);
    }
}
