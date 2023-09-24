package com.doc.concept.server.user.model.dto;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String login;
    private String name;
    private String surname;
    private List<UserSubscriptionDTO> subscriptions;
    private String email;
    private String phone;
    private String imageUrl;
}
