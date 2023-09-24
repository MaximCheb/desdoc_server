package com.doc.concept.server.user.controller;

import com.doc.concept.server.data.model.Auditory;
import com.doc.concept.server.user.model.PromoUsage;
import com.doc.concept.server.user.service.PromoService;
import com.doc.concept.server.user.service.PromoUsageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promo-usage")
@RequiredArgsConstructor
public class PromoUsageController {

    final private PromoUsageService promoUsageService;
    @GetMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(promoUsageService.getById(id));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }
    @GetMapping("/user/{id}")
    public ResponseEntity getByUserId(@PathVariable long id) {
        try {
            return ResponseEntity.ok(promoUsageService.getByUserId(id));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }
    @GetMapping("/all")
    public ResponseEntity getById() {
        try {
            return ResponseEntity.ok(promoUsageService.getByAll());
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }
    @GetMapping("/code/{code}")
    public ResponseEntity getByCode(@PathVariable String code) {
        try {
            return ResponseEntity.ok(promoUsageService.getByPromoCode(code));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }
}
