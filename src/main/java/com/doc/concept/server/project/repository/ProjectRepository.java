package com.doc.concept.server.project.repository;

import java.util.List;

import com.doc.concept.server.project.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	Project findById(long id);
	Project findByName(String name);
	List<Project> findAllByAuthor(String author);
}
