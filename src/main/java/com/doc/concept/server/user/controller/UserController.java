package com.doc.concept.server.user.controller;

import com.doc.concept.server.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    final private UserService userService;
    @GetMapping("/get/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }
    @GetMapping("/login/{name}")
    public ResponseEntity getUserByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(userService.getByLogin(name));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }
    @PreAuthorize("hasAuthority('export_doc')")
    @GetMapping("/login/export")
    public ResponseEntity getAccessToExport(){
        return ResponseEntity.ok("User can export");
    }
}
