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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subcription_type")
public class SubcriptionType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=32, nullable=false, unique=false)
	private String name;
	@Column(length=64, nullable=false, unique=false)
	private String market;
	private int teamSize;
	private int workHour;
	private int serverEntityCount;	// eхport, game balance resource, plus of user change
	private String role;
	@OneToMany(targetEntity=Promo.class,mappedBy="promoSubscription",fetch=FetchType.LAZY)   // внешний ключ
	private List<Promo> promos;
	@OneToMany(targetEntity=UserSubscription.class,mappedBy="subscriptionType",fetch=FetchType.LAZY)   // внешний ключ
	private List<UserSubscription> subscriptionUsage;
	
}
