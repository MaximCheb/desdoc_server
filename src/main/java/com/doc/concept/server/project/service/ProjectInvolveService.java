package com.doc.concept.server.project.service;

import com.doc.concept.server.project.mapper.ProjectInvolveMapper;
import com.doc.concept.server.project.model.Privilege;
import com.doc.concept.server.project.model.Project;
import com.doc.concept.server.project.model.ProjectInvolve;
import com.doc.concept.server.project.model.Role;
import com.doc.concept.server.project.model.dto.ProjectInvolveDTO;
import com.doc.concept.server.project.repository.ProjectInvolveRepository;
import com.doc.concept.server.project.repository.RolesRepository;
import com.doc.concept.server.user.model.User;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
@Service
public class ProjectInvolveService {
    final private ProjectInvolveRepository involveRepository;
    final private RolesRepository rolesRepository;
    final private ProjectInvolveMapper involveMapper;
	
	public List<ProjectInvolveDTO> getAll() {
		ArrayList<ProjectInvolveDTO> models = new ArrayList<ProjectInvolveDTO>();
		for(ProjectInvolve entity : involveRepository.findAll()) {
			models.add(involveMapper.ProjectInvolveToProjectInvolveDTO(entity));
		}
		return models;
    }
    public List<ProjectInvolveDTO> getByUser(long userId) {
        ArrayList<ProjectInvolveDTO> models = new ArrayList<ProjectInvolveDTO>();
        for(ProjectInvolve entity : involveRepository.findAllByUserId(userId)) {
            models.add(involveMapper.ProjectInvolveToProjectInvolveDTO(entity));
        }
        return models;
    }
    public List<ProjectInvolveDTO> getByProject(long projectId) {
        return involveRepository.findAllByProjectId(projectId).stream().map(involveMapper::ProjectInvolveToProjectInvolveDTO).toList();
    }
    public ProjectInvolveDTO getById(long id) {
        return involveMapper.ProjectInvolveToProjectInvolveDTO(involveRepository.findById(id));
    }
    public long create(ProjectInvolve entity) throws InstanceAlreadyExistsException {
        if (involveRepository.findAllByProjectId(entity.getProject().getId()).stream().anyMatch(involve -> involve.getUserId()==entity.getUserId())) {
            throw new InstanceAlreadyExistsException("User already involve in project");
        }
    	return involveRepository.save(entity).getId();
    }

    public long compose(Project project, long userId, List<Privilege> privileges){
        var entity = ProjectInvolve.builder()
                .project(project)
                .userId(userId)
                .build();
        var projectInvolve = involveRepository.save(entity);
        privileges.forEach(privilege -> rolesRepository.save(Role.builder().privilege(privilege).projectId(project.getId()).projectInvolve(projectInvolve).build()));
        return projectInvolve.getId();
    }
    public void update(ProjectInvolve entity) throws InstanceAlreadyExistsException {
    	involveRepository.save(entity);
    }
}
