package com.doc.des.server.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.doc.des.server.entity.PrivilegeEntity;

public interface PrivilegeRepository extends CrudRepository<PrivilegeEntity, Integer>{
    PrivilegeEntity findById(int id);
    PrivilegeEntity findByName(String name);
    List<PrivilegeEntity> findAll();
}
