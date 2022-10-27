package com.doc.des.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doc.des.server.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	
	
	private UserService service;
	
	@GetMapping("/{id}")
	public ResponseEntity getUser(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(service.getOne(id));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Bad request");
		}
	}
}
