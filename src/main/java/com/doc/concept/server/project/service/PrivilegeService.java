package com.doc.concept.server.project.service;

import com.doc.concept.server.project.mapper.PrivilegeMapper;
import com.doc.concept.server.project.model.Privilege;
import com.doc.concept.server.project.model.dto.PrivilegeDTO;
import com.doc.concept.server.project.repository.PrivilegeRepository;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Service
public class PrivilegeService {
    final private PrivilegeMapper privilegeMapper;
    final private PrivilegeRepository privilegeRepository;
    
    public List<Privilege> getAll() {
        List<Privilege> privileges = privilegeRepository.findAll();
        return privilegeRepository.findAll();    
    }    

    public PrivilegeDTO getByName(String name) {
        return privilegeMapper.PrivilegeToPrivilegeDTO(privilegeRepository.findByName(name));
    }
    
    public PrivilegeDTO getOne(long id) {
        var privilege = privilegeRepository.findById(id);
        return privilegeMapper.PrivilegeToPrivilegeDTO(privilegeRepository.findById(id).get());
    }
    public long create(Privilege privilege){
        return privilegeRepository.save(privilege).getId();
    }
    public void delete(Long id){
        privilegeRepository.deleteById(id);
    }
}
