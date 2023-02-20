package com.doc.concept.server.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
