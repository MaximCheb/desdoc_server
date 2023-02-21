package com.doc.concept.server.user.controller;

import com.doc.concept.server.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    final private UserService userService;
    @GetMapping("/getUserById/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }
    @GetMapping("/getUserByLogin/{name}")
    public ResponseEntity getUserByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(userService.getByLogin(name));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }
}
