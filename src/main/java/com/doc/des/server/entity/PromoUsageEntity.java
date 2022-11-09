package com.doc.des.server.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "promo_usage")
public class PromoUsageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="promo_id", nullable=false)
    private PromoEntity promo;
    private Long user_id;
    private Date date; // date of start
     
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public PromoEntity getPromo() {
        return promo;
    }
    public void setPromo(PromoEntity promo) {
        this.promo = promo;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }    
    
}
