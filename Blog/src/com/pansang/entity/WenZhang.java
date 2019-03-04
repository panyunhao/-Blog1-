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
public class WenZhang {

	  protected int wZId;
	  protected String wZTitle;
	  protected Users users;
	  protected String headImg;
	  protected String wZText;
	  protected String WZJJ;
	  protected int wZState;
	  protected int YC;
	  protected String wZurl;
	  protected Date fBTime;
	  protected int see;
	  protected int zan;	  
	  protected String biaoQian;
	  protected String qt1;
	  protected String qt2;
	  protected int qt3;

	
	public WenZhang() {
		super();
	}




	public WenZhang(int wZId, String wZTitle, Users users, String headImg,
			String wZText, String wZJJ, int wZState, int yC, String wZurl,
			Date fBTime, int see, int zan, String biaoQian, String qt1,
			String qt2, int qt3) {
		super();
		this.wZId = wZId;
		this.wZTitle = wZTitle;
		this.users = users;
		this.headImg = headImg;
		this.wZText = wZText;
		WZJJ = wZJJ;
		this.wZState = wZState;
		YC = yC;
		this.wZurl = wZurl;
		this.fBTime = fBTime;
		this.see = see;
		this.zan = zan;
		this.biaoQian = biaoQian;
		this.qt1 = qt1;
		this.qt2 = qt2;
		this.qt3 = qt3;
	}


	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public int getwZId() {
		return wZId;
	}


	public void setwZId(int wZId) {
		this.wZId = wZId;
	}


	public String getwZTitle() {
		return wZTitle;
	}


	public void setwZTitle(String wZTitle) {
		this.wZTitle = wZTitle;
	}


	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}


	public String getwZText() {
		return wZText;
	}


	public void setwZText(String wZText) {
		this.wZText = wZText;
	}


	public String getWZJJ() {
		return WZJJ;
	}


	public void setWZJJ(String wZJJ) {
		WZJJ = wZJJ;
	}


	public int getwZState() {
		return wZState;
	}


	public void setwZState(int wZState) {
		this.wZState = wZState;
	}


	public int getYC() {
		return YC;
	}


	public void setYC(int yC) {
		YC = yC;
	}


	public String getwZurl() {
		return wZurl;
	}


	public void setwZurl(String wZurl) {
		this.wZurl = wZurl;
	}


	public Date getfBTime() {
		return fBTime;
	}


	public void setfBTime(Date fBTime) {
		this.fBTime = fBTime;
	}


	public int getSee() {
		return see;
	}


	public void setSee(int see) {
		this.see = see;
	}


	public int getZan() {
		return zan;
	}


	public void setZan(int zan) {
		this.zan = zan;
	}


	public String getBiaoQian() {
		return biaoQian;
	}


	public void setBiaoQian(String biaoQian) {
		this.biaoQian = biaoQian;
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
