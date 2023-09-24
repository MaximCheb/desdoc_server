package com.doc.concept.server.user.controller;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.doc.concept.server.project.model.Role;
import com.doc.concept.server.project.repository.ProjectInvolveRepository;
import com.doc.concept.server.security.JwtUtils;
import com.doc.concept.server.user.mapper.UserMapper;
import com.doc.concept.server.user.model.User;
import com.doc.concept.server.user.model.UserSubscription;
import com.doc.concept.server.user.repository.UserRepository;
import com.doc.concept.server.user.repository.UserSubscriptionRepository;
import com.doc.concept.server.user.request.JwtResponse;
import com.doc.concept.server.user.request.LoginRequest;
import com.doc.concept.server.user.request.ProjectRequest;
import com.doc.concept.server.user.request.SignupRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doc.concept.server.user.model.UserDetailsImpl;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
	// TODO move to business logic to AuthService
	final AuthenticationManager authenticationManager;
	final UserRepository userRepository;
	final ProjectInvolveRepository involveRepository;
	final UserSubscriptionRepository userSubscriptionRepository;
	final PasswordEncoder encoder;
	final JwtUtils jwtUtils;
	final UserMapper userMapper;
		
    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponse> getAuthUser(@Valid @RequestBody LoginRequest loginRequest) {
		log.info(encoder.encode(loginRequest.getPassword()));
		List<GrantedAuthority> updatedAuthorities = new ArrayList<GrantedAuthority>();
		var userOrNull = userRepository.findByLogin(loginRequest.getLogin());
		if(userOrNull.isEmpty()){
			log.error("User {} not found", loginRequest.getLogin());
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		log.error("User {} not found", userOrNull.get().getSubscriptions());
		getUserSubscriptionRoles(userOrNull.get()).forEach(role->updatedAuthorities.add(new SimpleGrantedAuthority(role)));
    	Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));
    	    
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
        
        return ResponseEntity.ok(new JwtResponse(jwt, 
				 userDetails.getId(), 
				 userDetails.getUsername(), 
				 userDetails.getEmail(), 
				 roles));
    }
    /*
     * refresh token then change project
     */
    @PostMapping(path = "/refresh") 
    public ResponseEntity<JwtResponse> refreshProject(@Valid @RequestBody ProjectRequest refreshRequest) {
        List<GrantedAuthority> updatedAuthorities = new ArrayList<GrantedAuthority>();
		getUserSubscriptionRoles(userRepository.findById(refreshRequest.getIdUser()).get()).forEach(role->updatedAuthorities.add(new SimpleGrantedAuthority(role)));
        getProjectRoles(refreshRequest).forEach(role->updatedAuthorities.add(new SimpleGrantedAuthority(role)));
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(refreshRequest.getLogin(), refreshRequest.getPassword(),updatedAuthorities));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt, 
                 userDetails.getId(), 
                 userDetails.getUsername(), 
                 userDetails.getEmail(), 
                 roles));
    }
    
    @PostMapping(path = "/sign-up")
    public ResponseEntity registration(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByLogin(signUpRequest.getLogin())) {
			return ResponseEntity
					.badRequest()
					.body("Error: Username is already taken!");
		}
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body("Error: Email is already in use!");
		}
		// Create new user's account
		User user = new User();
		user.setLogin(signUpRequest.getLogin());
		user.setPassword(encoder.encode(signUpRequest.getPassword()));
		user.setEmail(signUpRequest.getEmail());
		user.setName(signUpRequest.getName());
		user.setSurname(signUpRequest.getSurname());
		user.setPhone(signUpRequest.getPhone());
		log.info("New user {}",user);
		userRepository.save(user);
		return ResponseEntity.ok(userMapper.UserToUserDTO(user));
    }
    /*
     * intern foreach
     */
    private List<String> getProjectRoles(ProjectRequest request){
        List<String> roles = new ArrayList<>();
        for(var involve : involveRepository.findAllByUserId(request.getIdUser())) {
            if(involve.getProject().getId()==request.getProjectId()) {
                involve.getRoles().forEach(role->roles.add(role.getPrivilege().getName()));
            }
        }
        return roles;
    }
	private List<String> getUserSubscriptionRoles(User user){
		try {
			log.info( "size = {}",userSubscriptionRepository.findAllByUser(user).size());
			return user.getSubscriptions().stream().map(UserSubscription::getRole).toList();
		} catch (Exception e){
			return Collections.emptyList();
		}
	}
}
