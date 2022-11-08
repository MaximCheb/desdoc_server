package com.doc.des.server.controller;

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

import com.doc.des.server.entity.ProjectInvolveEntity;
import com.doc.des.server.service.ProjectInvolvedService;

@RestController
@RequestMapping("/involve_project")
public class ProjectInvolveController {
@Autowired	
private ProjectInvolvedService projectInvolveService;
	
	@GetMapping("/all")
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.ok("Server work");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Empty");
		}
	}
	
	@GetMapping("/id={id}")
	public ResponseEntity getOne(@PathVariable long id) {
		try {
			return ResponseEntity.ok(projectInvolveService.getOne(id));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("No item");
		}
	}
	
	@GetMapping("/allByProject={}")
	public ResponseEntity getByProject(@PathVariable long id) {
		try {
			return ResponseEntity.ok(projectInvolveService.getByProject(id));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Fire? fire, Its fiasco");
		}
	}
	@GetMapping("/allByUser={}")
    public ResponseEntity getByUser(@PathVariable long id) {
        try {
            return ResponseEntity.ok(projectInvolveService.getByUserId(id));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Fire? fire, Its fiasco");
        }
    }
	@PostMapping(path = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newProject(@RequestBody ProjectInvolveEntity newProject) {
    	try {
    		projectInvolveService.create(newProject); 
    		return ResponseEntity.ok("User saved"); 		
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    }
}
