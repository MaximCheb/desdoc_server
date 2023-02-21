package com.doc.concept.server.project.service;

import java.util.ArrayList;
import java.util.List;

import com.doc.concept.server.project.mapper.ProjectMapper;
import com.doc.concept.server.project.model.Project;
import com.doc.concept.server.project.model.dto.ProjectDTO;
import com.doc.concept.server.project.repository.ProjectRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;

@Getter
@RequiredArgsConstructor
@Service
public class ProjectService {
	final private ProjectRepository projectRepository;
	final private ProjectMapper projectMapper;
	public List<ProjectDTO> getAll() {
		ArrayList<ProjectDTO> models = new ArrayList<ProjectDTO>();
		for(Project entity : projectRepository.findAll()) {
			models.add(projectMapper.ProjectToProjectDTO(entity));
		}
		return models;
    }
	

    public List<ProjectDTO>  getByAuthor(String author) {
    	ArrayList<ProjectDTO> models = new ArrayList<ProjectDTO>();
		for(Project entity : projectRepository.findAllByAuthor(author)) {
			models.add(projectMapper.ProjectToProjectDTO(entity));
		}
		return models;       		
    }
    
    public ProjectDTO getOne(long id) {
        return projectMapper.ProjectToProjectDTO(projectRepository.findById(id));
    }

    public ProjectDTO getByName(String name) {
        return projectMapper.ProjectToProjectDTO(projectRepository.findByName(name));
    }
    public long updateProject(Project entity) throws InstanceAlreadyExistsException{
    	return projectRepository.save(entity).getId();
    }
    
    public long create(Project project) throws InstanceAlreadyExistsException {
        if(projectRepository.findByName(project.getName())!=null) throw new InstanceAlreadyExistsException("Project exist");;
        return projectRepository.save(project).getId();
    }
    public void delete(Project entity) {
    	projectRepository.delete(entity);
    }
}
