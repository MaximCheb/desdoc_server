package com.doc.des.server.service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.doc.des.server.entity.ProjectInvolveEntity;
import com.doc.des.server.entity.RolesEntity;
import com.doc.des.server.entity.UserEntity;
import com.doc.des.server.exception.AlreadyExistException;
import com.doc.des.server.model.UserModel;
import com.doc.des.server.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
    
    public List<UserEntity> getAll() {
        return (List<UserEntity>) this.repository.findAll();
    }

    public UserEntity getByLogin(String login) {
        return this.repository.findByLogin(login);
    }
    
    public UserModel getOne(Long id) {
        return UserModel.toModel(repository.findById(id).get());
    }
        
    public UserModel createUser(UserEntity login) throws AlreadyExistException {
    	if(repository.findByLogin(login.getLogin())!=null) {
			throw new AlreadyExistException("User exist");
		}
    	return UserModel.toModel(repository.save(login));
    }   
    

}
