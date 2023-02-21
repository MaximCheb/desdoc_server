package com.doc.concept.server.project.controller;

import com.doc.concept.server.project.model.Project;
import com.doc.concept.server.project.service.ProjectService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.management.InstanceAlreadyExistsException;
@Getter
@RequiredArgsConstructor
@RestController
@RequestMapping("/project")
@SecurityRequirement(name = "gcc-user-api")
public class ProjectController {
	final private ProjectService projectService;
	
	@GetMapping("/{id}")
	public ResponseEntity getProject(@PathVariable long id) {
		try {
			return ResponseEntity.ok(projectService.getOne(id));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Project don't found");
		}
	}
	@GetMapping("/name/{name}")
	public ResponseEntity getProjectByName(@PathVariable String name) {
		try {
			return ResponseEntity.ok(projectService.getByName(name));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Project don't found");
		}
	}
	@GetMapping("/all")
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.ok(projectService.getAll());
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Projects don't found");
		}
	}
//	projectService.getByAuthor()
	@GetMapping("/author/{author}")
	public ResponseEntity getByAuthor(@PathVariable String author) {
		try {
			return ResponseEntity.ok(projectService.getByAuthor(author));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Project don't found");
		}
	}
	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newProject(@RequestBody Project newProject) {
    	try {
    		return ResponseEntity.ok(projectService.create(newProject));
		}catch (InstanceAlreadyExistsException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    }
}
