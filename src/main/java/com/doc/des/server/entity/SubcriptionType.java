package com.doc.des.server.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private int serverEntityCount; // eхport, game balance resource, plus of user change
	@OneToMany(targetEntity=PromoEntity.class,mappedBy="subcription",fetch=FetchType.EAGER)   // внешний ключ
    private List<PromoEntity> promo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public int getWorkHour() {
		return workHour;
	}
	public void setWorkHour(int workHour) {
		this.workHour = workHour;
	}
    public int getTeamSize() {
        return teamSize;
    }
    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
    public int getServerEntityCount() {
        return serverEntityCount;
    }
    public void setServerEntityCount(int serverEntityCount) {
        this.serverEntityCount = serverEntityCount;
    }
	
}
