package com.doc.concept.server.user.model.dto;

import com.doc.concept.server.user.model.Promo;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class SubcriptionTypeDTO{
    private Long id;
    private String name;
    private String market;
    private int teamSize;
    private int workHour;
    private int serverEntityCount; // eхport, game balance resource, plus of user change
    private List<PromoDTO> promo;
}
