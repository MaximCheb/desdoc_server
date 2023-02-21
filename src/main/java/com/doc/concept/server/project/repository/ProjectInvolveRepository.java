package com.doc.concept.server.project.repository;

import java.util.List;

import com.doc.concept.server.project.model.ProjectInvolve;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectInvolveRepository extends CrudRepository<ProjectInvolve, Long>{
	ProjectInvolve findById(long id);
	List<ProjectInvolve> findAllByProjectId(long id);
	List<ProjectInvolve> findAll();
	List<ProjectInvolve> findAllByUserId(long id);
}
