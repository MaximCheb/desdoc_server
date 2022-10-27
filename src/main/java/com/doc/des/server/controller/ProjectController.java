package com.doc.des.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doc.des.server.entity.ProjectEntity;
import com.doc.des.server.entity.UserEntity;
import com.doc.des.server.exception.AlreadyExistException;
import com.doc.des.server.service.ProjectService;
@RestController
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/info")
	public ResponseEntity getProject(@RequestParam int id) {
		try {
			return ResponseEntity.ok(projectService.getOne(id));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Fire? fire, Its fiasco");
		}
	}
	@GetMapping("/all")
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.ok(projectService.getAll());
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Fire? fire, Its fiasco");
		}
	}
//	projectService.getByAuthor()
	@GetMapping("/author")
	public ResponseEntity getByAuthor(@RequestParam String author) {
		try {
			return ResponseEntity.ok(projectService.getByAuthor(author));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("No smartphone");
		}
	}
	@PostMapping(path = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newProject(@RequestBody ProjectEntity newProject) {
    	try {
    		if(projectService.create(newProject)) {
    			return ResponseEntity.ok("project_saved");
    		}else {
    			return ResponseEntity.badRequest().body("Project not create");
    		}    		
		}catch (AlreadyExistException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    }
}
