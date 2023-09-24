package com.doc.concept.server.user.model;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_relation")
public class UserRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    @ManyToOne
    @JoinColumn(name="partner_id", nullable=true)
    private User partner;
    private byte level;
}
