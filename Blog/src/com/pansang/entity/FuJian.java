package com.pansang.entity;

import java.util.Date;

import javax.persistence.Entity;

/**
 * @author 潘云浩
 * @date 2018-10-25下午4:02:27
 * @function [!--方法说明--]
 * @version v1.0
 */
@Entity
public class FuJian {

	  protected int fJId;
	  protected String fJName;
	  protected int wZId;
	  protected int usId;
	  protected String fJurl;
	  protected int FJLX;
	  protected Date SCSJ;
	  protected int dLnum;
	  protected String qt1;
	  protected String qt2;
	  protected int qt3;

	  public FuJian()
	  {
	  }

	public FuJian(int fJId, String fJName, int wZId, int usId, String fJurl,
			int fJLX, Date sCSJ, int dLnum, String qt1, String qt2, int qt3) {
		super();
		this.fJId = fJId;
		this.fJName = fJName;
		this.wZId = wZId;
		this.usId = usId;
		this.fJurl = fJurl;
		FJLX = fJLX;
		SCSJ = sCSJ;
		this.dLnum = dLnum;
		this.qt1 = qt1;
		this.qt2 = qt2;
		this.qt3 = qt3;
	}

	public int getfJId() {
		return fJId;
	}

	public void setfJId(int fJId) {
		this.fJId = fJId;
	}

	public String getfJName() {
		return fJName;
	}

	public void setfJName(String fJName) {
		this.fJName = fJName;
	}

	public int getwZId() {
		return wZId;
	}

	public void setwZId(int wZId) {
		this.wZId = wZId;
	}

	public int getUsId() {
		return usId;
	}

	public void setUsId(int usId) {
		this.usId = usId;
	}

	public String getfJurl() {
		return fJurl;
	}

	public void setfJurl(String fJurl) {
		this.fJurl = fJurl;
	}

	public int getFJLX() {
		return FJLX;
	}

	public void setFJLX(int fJLX) {
		FJLX = fJLX;
	}

	public Date getSCSJ() {
		return SCSJ;
	}

	public void setSCSJ(Date sCSJ) {
		SCSJ = sCSJ;
	}

	public int getdLnum() {
		return dLnum;
	}

	public void setdLnum(int dLnum) {
		this.dLnum = dLnum;
	}

	public String getQt1() {
		return qt1;
	}

	public void setQt1(String qt1) {
		this.qt1 = qt1;
	}

	public String getQt2() {
		return qt2;
	}

	public void setQt2(String qt2) {
		this.qt2 = qt2;
	}

	public int getQt3() {
		return qt3;
	}

	public void setQt3(int qt3) {
		this.qt3 = qt3;
	}

	
	  



}
