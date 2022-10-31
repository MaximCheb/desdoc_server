package com.doc.des.server.repository;

import org.springframework.data.repository.CrudRepository;

import com.doc.des.server.entity.PromoEntity;
import com.doc.des.server.entity.PromoUsageEntity;

public interface PromoUsageRepository extends CrudRepository<PromoUsageEntity, Long>{

}
