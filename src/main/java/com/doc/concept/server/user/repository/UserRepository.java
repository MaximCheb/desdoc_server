package com.doc.concept.server.user.repository;

import java.util.List;
import java.util.Optional;

import com.doc.concept.server.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByLogin(String login);
	Optional<User> findById(Long id);
	List<User> findAll();
	User findByEmail(String email);
	Boolean existsByLogin(String username);
	Boolean existsByEmail(String email);
	Boolean existsByPassword(String password);
}
