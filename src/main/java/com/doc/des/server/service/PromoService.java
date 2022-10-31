package com.doc.des.server.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc.des.server.repository.PromoRepository;
@Service
public class PromoService {
    @Autowired
    PromoRepository promoRepository;
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
