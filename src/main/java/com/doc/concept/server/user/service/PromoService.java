package com.doc.concept.server.user.service;

import com.doc.concept.server.user.repository.PromoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@RequiredArgsConstructor
@Service
public class PromoService {
    final private PromoRepository promoRepository;
    private String encodePromo(String code) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");        
            md.update(code.getBytes());
            byte[] digest = md.digest();
            return DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return code;
    }
}
