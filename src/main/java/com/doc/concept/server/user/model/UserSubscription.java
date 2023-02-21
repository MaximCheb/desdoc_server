package com.doc.concept.server.user.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "subscription")
public class UserSubscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length=32, nullable=false, unique=false)
	private String type;
	private Date isContinue;
	@ManyToOne
    @JoinColumn(name="user_id", nullable=true)
	private User subUser;
	private Date dateEnd;
	private String role;
	private int idRef;
		
}
