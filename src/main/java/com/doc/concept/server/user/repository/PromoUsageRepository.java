package com.doc.concept.server.user.repository;

import com.doc.concept.server.user.model.Promo;
import com.doc.concept.server.user.model.PromoUsage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromoUsageRepository extends CrudRepository<PromoUsage, Long>{
    List<PromoUsage> findAllByPromo(Promo promo);
    List<PromoUsage> findAll();
    List<PromoUsage> findAllByUserId(long userId);
}
