package com.doc.des.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doc.des.server.service.PrivilegeService;

@RestController
@RequestMapping("/privileges")
public class PrivilegesController {
    @Autowired
    private PrivilegeService privilegesService;
    
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
    
    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable int id) {
        privilegesService.getAll();
        try {          
            return ResponseEntity.ok(privilegesService.getOne(id));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("No privilege by id");
        }
    }
}
