package com.doc.des.server.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "promo")
public class PromoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length=32, nullable=false, unique=false)
    private String code;
    private int numberUses;
    @ManyToOne
    @JoinColumn(name="subcription_id", nullable=false)
    private SubcriptionType subcription;
    private Date startPromo;
    private Date endPromo;
    private boolean soleProme;
    private boolean end;
    @OneToMany(targetEntity=PromoUsageEntity.class,mappedBy="promo",fetch=FetchType.EAGER)    // внешний ключ
    private List<PromoUsageEntity> promos;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public int getNumberUses() {
        return numberUses;
    }
    public void setNumberUses(int numberUses) {
        this.numberUses = numberUses;
    }
    public Date getStartPromo() {
        return startPromo;
    }
    public void setStartPromo(Date startPromo) {
        this.startPromo = startPromo;
    }
    public Date getEndPromo() {
        return endPromo;
    }
    public void setEndPromo(Date endPromo) {
        this.endPromo = endPromo;
    }
    public SubcriptionType getSubcription() {
        return subcription;
    }
    public void setSubcription(SubcriptionType subType) {
        this.subcription = subType;
    }
    public boolean isSoleProme() {
        return soleProme;
    }
    public void setSoleProme(boolean soleProme) {
        this.soleProme = soleProme;
    }
    public boolean isEnd() {
        return end;
    }
    public void setEnd(boolean end) {
        this.end = end;
    }  
}
