package com.doc.concept.server.user.model.dto;

import com.doc.concept.server.user.model.Promo;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromoUsageDTO {
    private Long id;
    private Promo promo;
    private Long userId;
    private Date date; // date of start
}
