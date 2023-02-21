package com.doc.concept.server.user.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "user")
@RequiredArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=32, nullable=false, unique=false)
	private String login;
	@Column(length=128, nullable=false, unique=false)
	private String password;
	@Column(length=64, nullable=false, unique=false)
	private String name;
	@Column(length=64, nullable=false, unique=false)
	private String surname;
	@OneToMany(targetEntity= UserSubscription.class,mappedBy="subUser",fetch=FetchType.EAGER)	 // внешний ключ
	private List<UserSubscription> subscriptions;
	@Column(length=64, nullable=false, unique=false)
	private String email;
	@Column(length=64, nullable=false, unique=false)
	private String phone;
	private String imageUrl;
}
