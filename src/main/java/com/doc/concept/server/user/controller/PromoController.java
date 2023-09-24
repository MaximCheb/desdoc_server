package com.doc.concept.server.user.controller;

import com.doc.concept.server.user.model.Promo;
import com.doc.concept.server.user.model.dto.PromoCodeResponseDto;
import com.doc.concept.server.user.service.PromoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promo")
@RequiredArgsConstructor
@Slf4j
public class PromoController {
    final private PromoService promoService;
    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity getById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(promoService.getById(id));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity getById() {
        try {
            return ResponseEntity.ok(promoService.getAll());
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }
    @GetMapping("/code/{code}")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity getByCode(@PathVariable String code) {
        try {
            return ResponseEntity.ok(promoService.getByCode(code));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Bad request");
        }
    }

    @PostMapping("/try-promo")
    public ResponseEntity usePromo(@RequestBody PromoCodeResponseDto codeResponseDto){
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            log.info("Use promo {}, user = {}",codeResponseDto.getCode(), username);
            return ResponseEntity.ok(promoService.tryUsePromoCode(codeResponseDto, username));
        }catch(Exception e) {
            log.error("Error is = {}", e.getMessage());
            return ResponseEntity.status(404).body("Not found");
        }
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    public long create(@RequestBody Promo promo){
        return promoService.create(promo);
    }
}
