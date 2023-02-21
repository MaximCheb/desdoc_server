package com.doc.concept.server.project.repository;

import com.doc.concept.server.project.model.ProjectInvolve;
import com.doc.concept.server.project.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<Role, Long> {
	Role findByPrivilegeId(int privilegeId);
	Role findByProjectId(long projectId);
	Role findByProjectInvolve(ProjectInvolve projectInvolve);
}
