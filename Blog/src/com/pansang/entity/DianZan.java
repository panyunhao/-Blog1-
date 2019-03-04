package com.pansang.entity;

import javax.persistence.Entity;

@Entity
public class DianZan {

	  protected int dZId;
	  protected int wZId;
	  protected int lYId;
	  protected int jYId;
	  protected String DZIP;
	  protected int state;

	  public DianZan(){
		  super();
	  }

	public DianZan(int dZId, int wZId, int lYId, int jYId, String dZIP,
			int state) {
		super();
		this.dZId = dZId;
		this.wZId = wZId;
		this.lYId = lYId;
		this.jYId = jYId;
		DZIP = dZIP;
		this.state = state;
	}

	public int getdZId() {
		return dZId;
	}

	public void setdZId(int dZId) {
		this.dZId = dZId;
	}

	public int getwZId() {
		return wZId;
	}

	public void setwZId(int wZId) {
		this.wZId = wZId;
	}

	public int getlYId() {
		return lYId;
	}

	public void setlYId(int lYId) {
		this.lYId = lYId;
	}

	public int getjYId() {
		return jYId;
	}

	public void setjYId(int jYId) {
		this.jYId = jYId;
	}

	public String getDZIP() {
		return DZIP;
	}

	public void setDZIP(String dZIP) {
		DZIP = dZIP;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	  
	
}
