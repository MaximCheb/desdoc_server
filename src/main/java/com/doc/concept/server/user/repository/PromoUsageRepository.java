package com.doc.concept.server.user.repository;

import com.doc.concept.server.user.model.PromoUsage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoUsageRepository extends CrudRepository<PromoUsage, Long>{

}
