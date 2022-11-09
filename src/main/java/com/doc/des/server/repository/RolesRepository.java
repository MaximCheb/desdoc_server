package com.doc.des.server.repository;

import org.springframework.data.repository.CrudRepository;

import com.doc.des.server.entity.RolesEntity;

public interface RolesRepository extends CrudRepository<RolesEntity, Integer> {
	RolesEntity findByPrivilegeId(int privilegeId);
	RolesEntity findByProjectId(int projectId);
}
