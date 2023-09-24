package com.doc.concept.server.user.model.dto;

import com.doc.concept.server.user.model.SubscriptionType;
import com.doc.concept.server.user.model.User;
import lombok.*;

import java.sql.Date;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserSubscriptionDTO {
    private long id;
    private String type;
    private Date isContinue;
    private User subuser;
    private Date dateEnd;
    private SubscriptionType subscriptionType;
}
