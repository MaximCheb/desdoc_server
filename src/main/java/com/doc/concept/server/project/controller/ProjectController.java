package com.doc.concept.server.project.controller;

import com.doc.concept.server.project.model.Project;
import com.doc.concept.server.project.model.dto.ProjectDTO;
import com.doc.concept.server.project.service.ProjectService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.management.InstanceAlreadyExistsException;
import java.util.List;

@Getter
@RequiredArgsConstructor
@RestController
@RequestMapping("/project")
@Tag(name = "project")
@SecurityRequirement(name = "Bearer Authentication")
@Slf4j
public class ProjectController {
	final private ProjectService projectService;

	@PreAuthorize("hasAuthority('read_project')")
	@GetMapping("/get/{id}")
	public ResponseEntity getProject(@PathVariable long id) {
		try {
			return ResponseEntity.ok(projectService.getOne(id));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Project don't found");
		}
	}
	@PreAuthorize("hasAuthority('read_project')")
	@GetMapping("/name/{name}")
	public ResponseEntity getProjectByName(@PathVariable String name) {
		try {
			return ResponseEntity.ok(projectService.getByName(name));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Project don't found");
		}
	}
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping("/all")
	public ResponseEntity getAll() {
		try {
			log.info("get all project");
			return ResponseEntity.ok(projectService.getAll());
		}catch(Exception e) {
			log.error(e.getMessage());
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
	@PreAuthorize("hasAuthority('pmanager')")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newProject(@RequestBody Project newProject) {
    	try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();
			newProject.setAuthor(username);
			log.info("create project = {}, author = {}", newProject.getName(), username);
    		return ResponseEntity.ok(projectService.create(newProject, username));
		}catch (InstanceAlreadyExistsException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    }

	@GetMapping ("/user/{userId}")
	public List<Project> allUserProject(@PathVariable long userId) {
		return projectService.getAllByUserId(userId);
	}

	@GetMapping ("/my-project")
	public List<ProjectDTO> allAuthorProject() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return projectService.getByAuthor(username);
	}
}
