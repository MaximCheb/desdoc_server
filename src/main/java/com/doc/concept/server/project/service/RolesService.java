package com.doc.concept.server.project.service;

import com.doc.concept.server.project.mapper.RolesMapper;
import com.doc.concept.server.project.model.Role;
import com.doc.concept.server.project.model.dto.RoleDTO;
import com.doc.concept.server.project.repository.ProjectRepository;
import com.doc.concept.server.project.repository.RolesRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
@Service
public class RolesService {
	final private RolesRepository rolesRepository;
    final private ProjectRepository projectRepository;
	final private RolesMapper rolesMapper;
	public List<RoleDTO> getAll() {
		ArrayList<RoleDTO> models = new ArrayList<RoleDTO>();
		for(Role entity : rolesRepository.findAll()) {
			models.add(rolesMapper.RolesToRolesDTO(entity));
		}
		return models;
    }

    public RoleDTO getByPrivilege(int privilegeId) {
        return rolesMapper.RolesToRolesDTO(rolesRepository.findByPrivilegeId(privilegeId));
    }
    
    public RoleDTO getOne(long id) {
        return rolesMapper.RolesToRolesDTO(rolesRepository.findById(id).get());
    }
    
    public RoleDTO getByProjectId(long id) {
        return rolesMapper.RolesToRolesDTO(rolesRepository.findByProjectId(id));
    }
        
    public long create(Role entity) throws InstanceAlreadyExistsException {
    	return rolesRepository.save(entity).getId();
    }
    public void update(Role entity) throws InstanceAlreadyExistsException {
    	rolesRepository.save(entity);
    }
    public void delete(Long id){
    	rolesRepository.deleteById(id);
    }
}
