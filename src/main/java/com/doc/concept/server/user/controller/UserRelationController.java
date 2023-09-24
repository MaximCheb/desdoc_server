package com.doc.concept.server.user.controller;

import com.doc.concept.server.user.model.PromoUsage;
import com.doc.concept.server.user.model.UserRelation;
import com.doc.concept.server.user.service.PromoUsageService;
import com.doc.concept.server.user.service.UserRelationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relation")
@RequiredArgsConstructor
public class UserRelationController {
    final private UserRelationService userRelationService;

    @GetMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(userRelationService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getByUserId(@PathVariable long id) {
        try {
            return ResponseEntity.ok(userRelationService.getAllByUserId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getById(int page, int size) {
        try {
            return ResponseEntity.ok(userRelationService.getAll(PageRequest.of(page, size)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody UserRelation userRelation) {
        return ResponseEntity.ok(userRelationService.create(userRelation));
    }

    @PutMapping()
    public ResponseEntity update(@RequestBody UserRelation userRelation) {
        return ResponseEntity.ok(userRelationService.update(userRelation));
    }

    @DeleteMapping("/{id}")
    public void delete(long id) {
        userRelationService.delete(id);
    }
}
