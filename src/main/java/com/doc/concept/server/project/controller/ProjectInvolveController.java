package com.doc.concept.server.project.controller;

import com.doc.concept.server.project.model.ProjectInvolve;
import com.doc.concept.server.project.service.ProjectInvolveService;
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

@RequiredArgsConstructor
@RestController
@RequestMapping("/involve_project")
public class ProjectInvolveController {
	final private ProjectInvolveService projectInvolveService;
	
	@GetMapping("/all")
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.ok("Server work");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Empty");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getOne(@PathVariable long id) {
		try {
			return ResponseEntity.ok(projectInvolveService.getById(id));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("No item");
		}
	}
	
	@GetMapping("/allByProject/{id}")
	public ResponseEntity getByProject(@PathVariable long id) {
		try {
			return ResponseEntity.ok(projectInvolveService.getByProject(id));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Fire? fire, Its fiasco");
		}
	}
	@GetMapping("/allByUser/{id}")
    public ResponseEntity getByUser(@PathVariable long id) {
        try {
            return ResponseEntity.ok(projectInvolveService.getByUser(id));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Fire? fire, Its fiasco");
        }
    }
	@PostMapping(path = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newProject(@RequestBody ProjectInvolve newProject) {
    	try {
    		return ResponseEntity.ok(projectInvolveService.create(newProject));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    }
}
