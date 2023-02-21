package com.doc.concept.server.project.repository;

import com.doc.concept.server.project.model.Privilege;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {
    List<Privilege> findAll();
    Privilege findByName(String name);
}
