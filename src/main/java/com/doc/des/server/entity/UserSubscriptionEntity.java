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
@Table(name = "subscription")
public class UserSubscriptionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length=32, nullable=false, unique=false)
	private String type;
	private Date is_continue;
	@ManyToOne
    @JoinColumn(name="user_id", nullable=true)
	private UserEntity user;
	private Date date_end; // now date + sub time
	private String role; // a role other than the user role
	private int idRef; // subsctipton
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getIs_continue() {
		return is_continue;
	}
	public void setIs_continue(Date is_continue) {
		this.is_continue = is_continue;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public Date getDate_end() {
		return date_end;
	}
	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}
    public int getIdRef() {
        return idRef;
    }
    public void setIdRef(int idRef) {
        this.idRef = idRef;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }	    
    
}
