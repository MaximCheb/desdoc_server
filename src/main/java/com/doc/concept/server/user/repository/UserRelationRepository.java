package com.doc.concept.server.user.repository;

import com.doc.concept.server.user.model.User;
import com.doc.concept.server.user.model.UserRelation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRelationRepository extends JpaRepository<UserRelation,Long> {
    List<UserRelation> findAllByUserId(User user);
    Page<UserRelation> findAll(Pageable page);
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM user_relation WHERE user_id LIKE ?1 AND  partner_id = ?2 UNION ALL SELECT * FROM user_relation WHERE user_id LIKE ?2 AND  partner_id = ?1"
    )
    UserRelation getFriend(long userId, long partnerId);
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM user_relation WHERE user_id LIKE ?1 UNION ALL SELECT id, partner_id, userId, level FROM user_relation WHERE  partner_id = ?1"
    )
    List<UserRelation> getAllRelations(long userId);
}
