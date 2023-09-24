package com.doc.concept.server.user.service;

import com.doc.concept.server.user.mapper.UserMapper;
import com.doc.concept.server.user.model.User;
import com.doc.concept.server.user.model.dto.UserDTO;
import com.doc.concept.server.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    final private UserMapper userMapper;
    final private UserRepository repository;
    
    public List<UserDTO> getAll() {
        return this.repository.findAll().stream().map(users->userMapper.UserToUserDTO(users)).toList();
    }

    public UserDTO getByLogin(String login) {
        return userMapper.UserToUserDTO(this.repository.findByLogin(login).get());
    }
    
    public UserDTO getOne(Long id) {
        return userMapper.UserToUserDTO((repository.findById(id).get()));
    }
        
    public UserDTO createUser(User login) throws InstanceAlreadyExistsException {
        if(repository.findByLogin(login.getLogin())!=null) {
            throw new InstanceAlreadyExistsException("User exist");
        }
        return userMapper.UserToUserDTO((repository.save(login)));
    }    

}
