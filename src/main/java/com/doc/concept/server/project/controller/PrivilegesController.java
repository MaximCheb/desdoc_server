package com.doc.concept.server.project.controller;

import com.doc.concept.server.project.model.Privilege;
import com.doc.concept.server.project.service.PrivilegeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;

@Getter
@RequiredArgsConstructor
@RestController
@RequestMapping("/privileges")
@Tag(name = "project")
@SecurityRequirement(name = "Bearer Authentication")
public class PrivilegesController {
    final private PrivilegeService privilegesService;

    @GetMapping("/get/{id}")
    public ResponseEntity getPrivilege(@PathVariable long id) {
        try {
            return ResponseEntity.ok(privilegesService.getOne(id));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Privilege don't found");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllPrivileges() {
        try {
            return ResponseEntity.ok(privilegesService.getAll());
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Empty");
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(privilegesService.getByName(name));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("No privilege by name");
        }
    }

    @PostMapping("/create")
    public ResponseEntity create(Privilege privilege){
        try {
           return ResponseEntity.ok(privilegesService.create(privilege));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}