package com.doc.des.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.doc.des.server.entity.ProjectInvolveEntity;

public interface ProjectInvolveRepository extends CrudRepository<ProjectInvolveEntity, Long>{
	ProjectInvolveEntity findById(long id);
	ProjectInvolveEntity findByUserId(long id);
	ProjectInvolveEntity findByProjectId(long id);
	List<ProjectInvolveEntity> findAll();
}
