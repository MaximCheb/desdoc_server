package com.doc.des.server.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.doc.des.server.entity.RolesEntity;
import com.doc.des.server.entity.UserEntity;
import com.doc.des.server.exception.AlreadyExistException;
import com.doc.des.server.model.UserModel;
import com.doc.des.server.repository.ProjectInvolveRepository;
import com.doc.des.server.repository.RolesRepository;
import com.doc.des.server.repository.UserRepository;
import com.doc.des.server.request.*;
import com.doc.des.server.security.JwtUtils;
import com.doc.des.server.service.AuthService;
import com.doc.des.server.service.UserDetailsImpl;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepository userRepository;

	@Autowired
	ProjectInvolveRepository involveRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
		
    @PostMapping(path = "/signin")
    public ResponseEntity<JwtResponse> getAuthUser(@Valid @RequestBody LoginRequest loginRequest) {
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
		UserEntity user = new UserEntity(signUpRequest.getLogin(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		user.setName(signUpRequest.getName());
		user.setSurname(signUpRequest.getSurname());
		user.setPhone(signUpRequest.getPhone());
		userRepository.save(user);
		Set<String> strRoles =  signUpRequest.getRole();
		Set<RolesEntity> roles = new HashSet<>();

		return ResponseEntity.ok(UserModel.toModel(user));
			
    }
    /*
     * intern foreach
     */
    private List<String> getProjectRoles(ProjectRequest request){
        List<String> roles = new ArrayList<String>();
        for(var involve : involveRepository.findAllByUserId(request.getIdUser())) {
            if(involve.getProject().getId()==request.getProjectId()) {
                roles.add( involve.getRoleName());
                involve.getRoles().forEach(role->roles.add(role.getPrivilege().getName()));
            }
        }
        return roles;
    }
}
