package com.doc.concept.server.user.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "promo")
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length=32, nullable=false, unique=false)
    private String code;
    private int numberUses;
    @ManyToOne
    @JoinColumn(name="subcription_id", nullable=false)
    private SubcriptionType subcription; // use subscription for ref
    private Date startPromo;
    private Date endPromo;
    private boolean solePromo; // if true?? dont use promo
    private boolean end; 
    @OneToMany(targetEntity= PromoUsage.class,mappedBy="promo",fetch=FetchType.EAGER)    // внешний ключ
    private List<PromoUsage> promos;
}
