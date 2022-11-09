package com.doc.des.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doc.des.server.entity.ProjectEntity;
import com.doc.des.server.entity.RolesEntity;
import com.doc.des.server.exception.AlreadyExistException;
import com.doc.des.server.service.ProjectInvolvedService;
import com.doc.des.server.service.RolesService;

@RestController
@RequestMapping("/roles")
public class RolesController {
@Autowired	
private RolesService rolesService;
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('user')")
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.ok("Server work");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Fire? fire, Its fiasco");
		}
	}
	
	@GetMapping()
	
	public ResponseEntity getOne(@RequestParam int id) {
		try {
			return ResponseEntity.ok(rolesService.getOne(id));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("No smartphone");
		}
	}
	
	@GetMapping("/project")
	
	public ResponseEntity getByProject(@RequestParam int id) {
		try {
			return ResponseEntity.ok(rolesService.getByProjectId(id));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Fire? fire, Its fiasco");
		}
	}
	
	@PostMapping(path = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newProject(@RequestBody RolesEntity newProject) {
    	try {
    		rolesService.create(newProject);
    		ResponseEntity.ok(newProject.getProjectId()+" create");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("bad role");
    }
	@DeleteMapping()
	@PreAuthorize("hasAuthority('user')")
	public ResponseEntity delete(@RequestParam int id) {
		try {
			rolesService.delete(id);
			return ResponseEntity.ok("role delete");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Fire? fire, Its fiasco");
		}
	}
	@PatchMapping()
	@PreAuthorize("hasAuthority('user')")
	public ResponseEntity update(@RequestBody RolesEntity project) {
		try {
			rolesService.update(project);
			return ResponseEntity.ok("role update");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Fire? fire, Its fiasco");
		}
	}
	
}
