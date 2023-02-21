package com.doc.concept.server.user.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.doc.concept.server.project.model.Role;
import com.doc.concept.server.project.repository.ProjectInvolveRepository;
import com.doc.concept.server.security.JwtUtils;
import com.doc.concept.server.user.mapper.UserMapper;
import com.doc.concept.server.user.model.User;
import com.doc.concept.server.user.repository.UserRepository;
import com.doc.concept.server.user.request.JwtResponse;
import com.doc.concept.server.user.request.LoginRequest;
import com.doc.concept.server.user.request.ProjectRequest;
import com.doc.concept.server.user.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
	final AuthenticationManager authenticationManager;
	final UserRepository userRepository;
	final ProjectInvolveRepository involveRepository;
	final PasswordEncoder encoder;
	final JwtUtils jwtUtils;
	final UserMapper userMapper;
		
    @PostMapping(path = "/signin")
    public ResponseEntity<JwtResponse> getAuthUser(@Valid @RequestBody LoginRequest loginRequest) {
		log.info("sign in {}",loginRequest);
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
    
    @PostMapping(path = "/signup")
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
		Set<String> strRoles =  signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		return ResponseEntity.ok(userMapper.UserToUserDTO(user));
			
    }
    /*
     * intern foreach
     */
    private List<String> getProjectRoles(ProjectRequest request){
        List<String> roles = new ArrayList<String>();
        for(var involve : involveRepository.findAllByUserId(request.getIdUser())) {
            if(involve.getProject().getId()==request.getProjectId()) {
                involve.getRoles().forEach(role->roles.add(role.getPrivilege().getName()));
            }
        }
        return roles;
    }
}
