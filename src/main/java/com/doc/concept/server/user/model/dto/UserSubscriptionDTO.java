package com.doc.concept.server.user.model.dto;

import com.doc.concept.server.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSubscriptionDTO {
    private long id;
    private String type;
    private Date isContinue;
    private User subuser;
    private Date dateEnd;
    private int idRef;
}
