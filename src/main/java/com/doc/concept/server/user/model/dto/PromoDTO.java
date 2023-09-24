package com.doc.concept.server.user.model.dto;

import lombok.*;

import java.sql.Date;
import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromoDTO {
    private String code;
    private int numberUses;
    private Date startPromo;
    private Date endPromo;
    private boolean solePromo; // if true?? dont use promo
    private boolean end;
    private List<PromoUsageDTO> promos;
}
