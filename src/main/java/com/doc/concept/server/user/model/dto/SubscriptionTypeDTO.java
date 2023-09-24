package com.doc.concept.server.user.model.dto;

import com.doc.concept.server.user.model.UserSubscription;
import lombok.*;

import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubscriptionTypeDTO {
    private Long id;
    private String name;
    private String market;
    private int teamSize;
    private int workHour;
    private int serverEntityCount; // eхport, game balance resource, plus of user change
    private String role;
    private List<PromoDTO> promo;
    private List<UserSubscription> subscriptionUsage;
}
