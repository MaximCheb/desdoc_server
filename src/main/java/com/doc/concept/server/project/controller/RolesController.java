package com.doc.concept.server.project.controller;

import com.doc.concept.server.project.model.Role;
import com.doc.concept.server.project.service.RolesService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/roles")
@Tag(name = "project")
@SecurityRequirement(name = "Bearer Authentication")
public class RolesController {

	final private RolesService rolesService;
	
	@GetMapping("/all")
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.ok("Server work");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Fire? fire, Its fiasco");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getOne(@PathVariable long id) {
		try {
			return ResponseEntity.ok(rolesService.getOne(id));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("No smartphone");
		}
	}
	
	@GetMapping("/project/{id}")
	
	public ResponseEntity getByProject(@PathVariable long id) {
		try {
			return ResponseEntity.ok(rolesService.getByProjectId(id));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Fire? fire, Its fiasco");
		}
	}
	
	@PostMapping(path = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newProject(@RequestBody Role newRole) {
    	try {
    		rolesService.create(newRole);
    		ResponseEntity.ok(newRole.getProjectId()+" create");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("bad role");
    }

	@DeleteMapping("/get/{id}")
	public ResponseEntity delete(@PathVariable long id) {
		try {
			rolesService.delete(id);
			return ResponseEntity.ok("role delete");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Fire? fire, Its fiasco");
		}
	}

	@PutMapping("/update")
//	@PreAuthorize("hasAuthority('user')")
	public ResponseEntity update(@RequestBody Role role) {
		try {
			rolesService.update(role);
			return ResponseEntity.ok("role update");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Role update failed");
		}
	}
	
}
