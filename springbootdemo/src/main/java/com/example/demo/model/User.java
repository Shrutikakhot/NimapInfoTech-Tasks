package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String usernm;
	private String password;
	
	@OneToOne(mappedBy = "user", cascade= CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonManagedReference
	private Registration reg;
	
	public User() {
		super();
	}

	public User( String usernm, String password) {
		super();
		this.usernm = usernm;
		this.password = password;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsernm() {
		return usernm;
	}

	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Registration getReg() {
		return reg;
	}

	public void setReg(Registration reg) {
		this.reg = reg;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", usernm=" + usernm + ", password=" + password + "]";
	}
}
