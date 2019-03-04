package com.pansang.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class LiuYan {

	protected int lYId;
	protected int wZId;
	protected int fId;
	protected int fKId;
	protected String fKName;
	protected String head;
	protected String lYText;
	protected int zan;
	protected int state;
	protected Date lYTime;
	protected String qt1;
	protected int qt2;
	protected List<LiuYan> lylist;

	public LiuYan(){
		super();
	}

	public LiuYan(int lYId, int wZId, int fId, int fKId, String fKName,
			String head, String lYText, int zan, int state, Date lYTime,
			String qt1, int qt2, List<LiuYan> lylist) {
		super();
		this.lYId = lYId;
		this.wZId = wZId;
		this.fId = fId;
		this.fKId = fKId;
		this.fKName = fKName;
		this.head = head;
		this.lYText = lYText;
		this.zan = zan;
		this.state = state;
		this.lYTime = lYTime;
		this.qt1 = qt1;
		this.qt2 = qt2;
		this.lylist = lylist;
	}



	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public int getlYId() {
		return lYId;
	}

	public void setlYId(int lYId) {
		this.lYId = lYId;
	}

	public int getwZId() {
		return wZId;
	}

	public void setwZId(int wZId) {
		this.wZId = wZId;
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public int getfKId() {
		return fKId;
	}

	public void setfKId(int fKId) {
		this.fKId = fKId;
	}

	public String getfKName() {
		return fKName;
	}

	public void setfKName(String fKName) {
		this.fKName = fKName;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getlYText() {
		return lYText;
	}

	public void setlYText(String lYText) {
		this.lYText = lYText;
	}

	public int getZan() {
		return zan;
	}

	public void setZan(int zan) {
		this.zan = zan;
	}

	public Date getlYTime() {
		return lYTime;
	}

	public void setlYTime(Date lYTime) {
		this.lYTime = lYTime;
	}

	public String getQt1() {
		return qt1;
	}

	public void setQt1(String qt1) {
		this.qt1 = qt1;
	}

	public int getQt2() {
		return qt2;
	}

	public void setQt2(int qt2) {
		this.qt2 = qt2;
	}

	public List<LiuYan> getLylist() {
		return lylist;
	}

	public void setLylist(List<LiuYan> lylist) {
		this.lylist = lylist;
	}

	
	
	
	
}
