package com.doc.des.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc.des.server.entity.PrivilegeEntity;
import com.doc.des.server.entity.ProjectEntity;
import com.doc.des.server.model.ProjectModel;
import com.doc.des.server.repository.PrivilegeRepository;


@Service
public class PrivilegeService {

    @Autowired
    private PrivilegeRepository privilegeRepository;
    
    public List<PrivilegeEntity> getAll() {
        List<PrivilegeEntity> privileges = privilegeRepository.findAll();
        privileges.remove(26);
        privileges.remove(26);
        return privilegeRepository.findAll();    
    }    

    public PrivilegeEntity  getByName(String name) {
        return privilegeRepository.findByName(name);              
    }
    
    public PrivilegeEntity getOne(int id) {
        var privilege = privilegeRepository.findById(id);
        return privilegeRepository.findById(id);
    }
}
