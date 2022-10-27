package com.doc.des.server.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.doc.des.server.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{
	UserEntity findByLogin(String login);
	Optional<UserEntity> findById(Long id);
	UserEntity findByEmail(String email);
	Boolean existsByLogin(String username);
	Boolean existsByEmail(String email);
}
