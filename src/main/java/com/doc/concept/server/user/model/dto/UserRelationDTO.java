package com.doc.concept.server.user.model.dto;

import com.doc.concept.server.user.model.User;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRelationDTO {
    private long id;
    private long userId;
    private User partner;
    private byte level;
}
