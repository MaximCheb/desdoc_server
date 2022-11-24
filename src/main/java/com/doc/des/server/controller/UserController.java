package com.doc.des.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doc.des.server.entity.UserEntity;
import com.doc.des.server.request.ChangeLoginRequest;
import com.doc.des.server.request.ChangePass;
import com.doc.des.server.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
    PasswordEncoder encoder;
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity getUser(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(service.getOne(id));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Bad request");
		}
	}
	@GetMapping("/getUserByLogin/{name}")
    public ResponseEntity getUserByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(service.getByLogin(name));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }
	@PutMapping("/changeLogin") // bad idea need refresh token
	public ResponseEntity changeLogin(@RequestBody ChangeLoginRequest logins) {
	    try {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String currentPrincipalName = authentication.getName(); 
	        if(!logins.getOldLogin().equals(currentPrincipalName)) {
	            return ResponseEntity.badRequest().body("Wrong login");
	        }
	        service.updateLogin(logins); // must obscure refresh token in user app
            return ResponseEntity.ok("login change");
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad update");
        }
	    
	}
	@PutMapping("/changePassword") 
	public ResponseEntity changeLogin(@RequestBody ChangePass changePass) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            if(!changePass.getLogin().equals(currentPrincipalName)) {
                return ResponseEntity.badRequest().body("Wrong login");
            }
            changePass.setPass(encoder.encode(changePass.getPass()));
            service.updatePass(changePass); // must obscure refresh token in user app
            return ResponseEntity.ok("pass  change");
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad update");
        }
        
    }
	@PutMapping("/change")
    public ResponseEntity changeLogin(@RequestBody UserEntity user) { // user dont change pass, login and id in this request
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            if(!user.getLogin().equals(currentPrincipalName)) {
                return ResponseEntity.badRequest().body("Wrong login");
            }
            service.updateUser(user);
            return ResponseEntity.ok("user change");
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad update");
        }
        
    }
}
