package com.pansang.entity;

import javax.persistence.Entity;

@Entity
public class LiuLan {

	  protected int wZId;
	  protected String FKIP;

	public LiuLan(){
		super();
	}

	public LiuLan(int wZId, String fKIP) {
		super();
		this.wZId = wZId;
		FKIP = fKIP;
	}

	public int getwZId() {
		return wZId;
	}

	public void setwZId(int wZId) {
		this.wZId = wZId;
	}

	public String getFKIP() {
		return FKIP;
	}

	public void setFKIP(String fKIP) {
		FKIP = fKIP;
	}

	
	
	
}
