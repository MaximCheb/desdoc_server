package com.doc.concept.server.user.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "promo")
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length=32, nullable=false, unique=true)
    private String code;
    private int numberUses;
    @ManyToOne
    @JoinColumn(name="subcription_id", nullable=true)
    private SubscriptionType promoSubscription;
    private Date startPromo;
    private Date endPromo;
    private boolean solePromo;
    private boolean end; 
    @OneToMany(targetEntity= PromoUsage.class,mappedBy="promo",fetch=FetchType.LAZY)    // внешний ключ
    private List<PromoUsage> promos;
}
