package com.doc.des.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.doc.des.server.entity.ProjectEntity;

public interface ProjectRepository extends CrudRepository<ProjectEntity, Integer>{
	ProjectEntity findById(int id);
	ProjectEntity findByName(String name);
	List<ProjectEntity> findAllByAuthor(String author);
}
