package com.doc.des.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.doc.des.server.entity.ProjectEntity;
import com.doc.des.server.entity.PromoEntity;
import com.doc.des.server.entity.SubcriptionType;

public interface PromoRepository extends CrudRepository<PromoEntity,Integer>{
    PromoEntity findById(int id);
    PromoEntity findByCode(String code);
    List<PromoEntity> findAll();
    List<PromoEntity> findAllBySubcription(SubcriptionType subcription);
}
