package com.doc.des.server.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doc.des.server.entity.UserEntity;
import com.doc.des.server.exception.AlreadyExistException;
import com.doc.des.server.model.UserModel;
import com.doc.des.server.repository.UserRepository;
@Service
public class AuthService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
		
    public UserEntity getByLogin(String login) {
        return this.userRepository.findByLogin(login);
    }
    
        
    public UserModel createUser(UserEntity login) throws AlreadyExistException {
    	if(userRepository.findByLogin(login.getLogin())!=null) {
			throw new AlreadyExistException("User exist");
		}
    	return UserModel.toModel(userRepository.save(login));
    }
    
    @Override
	@Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity user = getByLogin(login);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
              
        return UserDetailsImpl.build(user);
    }
    
    public UserModel registerNewUserAccount(UserEntity user) throws AlreadyExistException  {
    	if(userRepository.findByLogin(user.getLogin())!=null) {
			throw new AlreadyExistException("User exist");
		}
       
        return UserModel.toModel(userRepository.save( user));
    }
}
