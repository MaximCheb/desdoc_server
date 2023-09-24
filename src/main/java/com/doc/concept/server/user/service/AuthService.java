package com.doc.concept.server.user.service;

import java.util.Objects;

import com.doc.concept.server.user.mapper.UserMapper;
import com.doc.concept.server.user.model.User;
import com.doc.concept.server.user.model.UserDetailsImpl;
import com.doc.concept.server.user.model.dto.UserDTO;
import com.doc.concept.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.InstanceAlreadyExistsException;
// #TODO move logic from controller
@RequiredArgsConstructor
@Service
@Slf4j
public class AuthService implements UserDetailsService{

    final private UserRepository userRepository;
	final private UserMapper mapper;
    public User getByLogin(String login) {
        return this.userRepository.findByLogin(login).get();
    }
        
    public UserDTO createUser(User newUser) throws InstanceAlreadyExistsException {
    	if(userRepository.findByLogin(newUser.getLogin())!=null) {
			throw new InstanceAlreadyExistsException("User exist");
		}
        log.info("User {}, email {},pass {}", newUser.getLogin(),newUser.getEmail(),newUser.getPassword());
    	return mapper.UserToUserDTO(userRepository.save(newUser));
    }
    
    @Override
	@Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = getByLogin(login);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
              
        return UserDetailsImpl.build(user);
    }
    
    public UserDTO registerNewUserAccount(User user) throws InstanceAlreadyExistsException  {
    	if(userRepository.findByLogin(user.getLogin())!=null) {
			throw new InstanceAlreadyExistsException("User exist");
		}
        return mapper.UserToUserDTO(userRepository.save( user));
    }
}
