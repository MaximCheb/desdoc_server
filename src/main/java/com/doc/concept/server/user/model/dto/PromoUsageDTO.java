package com.doc.concept.server.user.model.dto;

import com.doc.concept.server.user.model.Promo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromoUsageDTO {
    private Long id;
    private Promo promo;
    private Long user_id;
    private Date date; // date of start
}
