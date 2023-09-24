package com.doc.concept.server.user.service;

import com.doc.concept.server.user.mapper.UserRelationMapper;
import com.doc.concept.server.user.model.User;
import com.doc.concept.server.user.model.UserRelation;
import com.doc.concept.server.user.model.dto.UserRelationDTO;
import com.doc.concept.server.user.repository.UserRelationRepository;
import com.doc.concept.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserRelationService {

    private final UserRelationRepository relationRepository;
    private final UserRepository userRepository;
    final private UserRelationMapper relationMapper;
    public long create(UserRelation relation) {
        UserRelation resultRelation = relationRepository.getFriend(relation.getUserId(), relation.getPartner().getId());
        long resultId = resultRelation == null ? resultRelation.getId() : 0;
        relation.setId(resultId);
        return relationRepository.save(relation).getId();
    }
    public long update(UserRelation relation) {
        relationRepository.getFriend(relation.getUserId(), relation.getPartner().getId());
        return relationRepository.save(relation).getId();
    }
    public UserRelationDTO getById(long id) {
        return relationMapper.UserRelationToUserRelationDTO(relationRepository.findById(id).get());
    }
    public List<UserRelationDTO> getAll(Pageable page) {
        var relations = relationRepository.findAll(page).stream().map(relationMapper::UserRelationToUserRelationDTO).toList();
        return relations;
    }

    public List<UserRelationDTO> getAllByUserId(long id) {
        User user = userRepository.getById(id);
        var relations = relationRepository.findAllByUserId(user).stream().map(relationMapper::UserRelationToUserRelationDTO).toList();
        return relations;
    }
    public void delete(long id){
        relationRepository.delete(relationRepository.getById(id));
    }
}
