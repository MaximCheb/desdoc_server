package com.doc.concept.server.user.model.dto;

import com.doc.concept.server.user.model.PromoUsage;
import com.doc.concept.server.user.model.SubcriptionType;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

public class PromoDTO {
    private String code;
    private int numberUses;
    private Date startPromo;
    private Date endPromo;
    private boolean solePromo; // if true?? dont use promo
    private boolean end;
    private List<PromoUsageDTO> promos;
}
