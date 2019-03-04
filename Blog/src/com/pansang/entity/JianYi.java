package com.pansang.entity;

import javax.persistence.Entity;

@Entity
public class JianYi {

	protected int jYId;
	protected String usName;
	protected String head;
	protected String email;
	protected String lYText;
	protected String jYTime;	
	protected int zan;
	protected int state;
	protected int qt1;
	protected String qt2;

	public JianYi(){
		super();
	}

	
	public JianYi(int jYId, String usName, String head, String email,
			String lYText, String jYTime, int zan, int state, int qt1,
			String qt2) {
		super();
		this.jYId = jYId;
		this.usName = usName;
		this.head = head;
		this.email = email;
		this.lYText = lYText;
		this.jYTime = jYTime;
		this.zan = zan;
		this.state = state;
		this.qt1 = qt1;
		this.qt2 = qt2;
	}






	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public int getjYId() {
		return jYId;
	}

	public void setjYId(int jYId) {
		this.jYId = jYId;
	}

	public String getUsName() {
		return usName;
	}

	public void setUsName(String usName) {
		this.usName = usName;
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

	public String getlYText() {
		return lYText;
	}

	public void setlYText(String lYText) {
		this.lYText = lYText;
	}

	public String getjYTime() {
		return jYTime;
	}


	public void setjYTime(String jYTime) {
		this.jYTime = jYTime;
	}

	public int getZan() {
		return zan;
	}

	public void setZan(int zan) {
		this.zan = zan;
	}

	public int getQt1() {
		return qt1;
	}

	public void setQt1(int qt1) {
		this.qt1 = qt1;
	}

	public String getQt2() {
		return qt2;
	}

	public void setQt2(String qt2) {
		this.qt2 = qt2;
	}

	
	
	
}
