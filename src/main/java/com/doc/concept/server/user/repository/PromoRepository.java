package com.doc.concept.server.user.repository;

import java.util.List;

import com.doc.concept.server.user.model.Promo;
import com.doc.concept.server.user.model.SubcriptionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepository extends JpaRepository<Promo,Integer> {
    Promo findById(int id);
    Promo findByCode(String code);
    List<Promo> findAll();
    List<Promo> findAllBySubcription(SubcriptionType subcription);
}
