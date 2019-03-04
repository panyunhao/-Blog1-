package com.pansang.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class FangKe {

	protected int fKId;
	protected String fKName;		
	protected String head;
	protected String email;
	protected Date cJTime;
	protected String quDao;
	protected String FKIP;
	protected String qt2;
	protected int qt3;

	public FangKe(){
		super();
	}

	public FangKe(int fKId, String fKName, String head, String email,
			Date cJTime, String quDao, String FKIP, String qt2, int qt3) {
		super();
		this.fKId = fKId;
		this.fKName = fKName;
		this.head = head;
		this.email = email;
		this.cJTime = cJTime;
		this.quDao = quDao;
		this.FKIP = FKIP;
		this.qt2 = qt2;
		this.qt3 = qt3;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getcJTime() {
		return cJTime;
	}

	public void setcJTime(Date cJTime) {
		this.cJTime = cJTime;
	}

	public String getQuDao() {
		return quDao;
	}

	public void setQuDao(String quDao) {
		this.quDao = quDao;
	}

	public String getFKIP() {
		return FKIP;
	}

	public void setFKIP(String FKIP) {
		this.FKIP = FKIP;
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
