package com.doc.concept.server.user.controller;

import com.doc.concept.server.user.model.SubscriptionType;
import com.doc.concept.server.user.service.SubscriptionTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscription-type")
@RequiredArgsConstructor
@Slf4j
public class SubscriptionTypeController {
    private final SubscriptionTypeService subscriptionTypeService;
    @GetMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(subscriptionTypeService.getOne(id));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }
    @GetMapping("/all")
    public ResponseEntity getById() {
        try {
            return ResponseEntity.ok(subscriptionTypeService.getAll());
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }
    @PostMapping
    public long create(@RequestBody SubscriptionType subscriptionType){
        return subscriptionTypeService.create(subscriptionType);
    }
}
