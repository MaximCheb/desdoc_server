package com.doc.concept.server.project.service;

import java.util.ArrayList;
import java.util.List;

import com.doc.concept.server.project.mapper.ProjectMapper;
import com.doc.concept.server.project.model.Privilege;
import com.doc.concept.server.project.model.Project;
import com.doc.concept.server.project.model.ProjectInvolve;
import com.doc.concept.server.project.model.dto.ProjectDTO;
import com.doc.concept.server.project.repository.ProjectInvolveRepository;
import com.doc.concept.server.project.repository.ProjectRepository;
import com.doc.concept.server.project.repository.RolesRepository;
import com.doc.concept.server.user.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;

@Getter
@RequiredArgsConstructor
@Service
public class ProjectService {
	final private ProjectRepository projectRepository;
    final private ProjectInvolveRepository projectInvolveRepository;
    final private UserRepository userRepository;
    final private ProjectInvolveService projectInvolveService;
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
    
    public long create(Project project, String username) throws InstanceAlreadyExistsException {
        if(projectRepository.findByName(project.getName())!=null) throw new InstanceAlreadyExistsException("Project exist");
        var projectResult = projectRepository.save(project);
        var userId =userRepository.findByLogin(username).get().getId();
        ArrayList<Privilege> privileges = getManagerPrivileges();
        projectInvolveService.compose(projectResult,userId,privileges);
        return projectResult.getId();
    }
    private ArrayList<Privilege> getManagerPrivileges() {
        ArrayList<Privilege> privileges = new ArrayList<>();
        privileges.add(new Privilege(17,"create_project"));
        privileges.add(new Privilege(9,"create_user"));
        privileges.add(new Privilege(18,"create_management"));
        privileges.add(new Privilege(15,"create_story"));
        privileges.add(new Privilege(19,"create_catalog"));
        privileges.add(new Privilege(21,"create_concept"));
        return privileges;
    }

    public void delete(Project entity) {
    	projectRepository.delete(entity);
    }

    public List<Project> getAllByUserId(long id) {
        return projectInvolveRepository.findAllByUserId(id).stream().map(ProjectInvolve::getProject).toList();
    }
}
