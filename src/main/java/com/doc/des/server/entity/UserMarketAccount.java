package com.doc.des.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Data // use or don't use Lombok
@Entity
@Table(name = "market_account")
public class UserMarketAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private UserEntity user;
	@Column(length=64, nullable=false, unique=false)
    private String market;
	@Column(length=64, nullable=false, unique=false)
    private String marketId;
	
}
