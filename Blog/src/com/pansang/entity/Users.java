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
public class Users {

	  private int usId;
	  private String zhangHao;
	  private String miMa;
	  private String usName;
	  private int jiFen;
	  private Date cJTime;
	  private String quDao;
	  private String email;
	  private String head;
	  private String qt1;
	  private String qt2;
	  private int qt3;
	  public Users()
	  {
		  super();
	  }
	  
	  public Users(int usId, String zhangHao, String miMa, String usName,
			int jiFen, Date cJTime, String quDao, String email, String head,
			String qt1, String qt2, int qt3) {
		super();
		this.usId = usId;
		this.zhangHao = zhangHao;
		this.miMa = miMa;
		this.usName = usName;
		this.jiFen = jiFen;
		this.cJTime = cJTime;
		this.quDao = quDao;
		this.email = email;
		this.head = head;
		this.qt1 = qt1;
		this.qt2 = qt2;
		this.qt3 = qt3;
	}

	public int getUsId()
	  {
	    return usId;
	  }
	  /**
	   * 设置用户编号
	   */
	  public void setUsId(int value)
	  {
	    this.usId = value;
	  }
	  /**
	   * 获取账号
	   */
	  public String getZhangHao()
	  {
	    return zhangHao;
	  }
	  /**
	   * 设置账号
	   */
	  public void setZhangHao(String value)
	  {
	    this.zhangHao = value;
	  }
	  /**
	   * 获取密码
	   */
	  public String getMiMa()
	  {
	    return miMa;
	  }
	  /**
	   * 设置密码
	   */
	  public void setMiMa(String value)
	  {
	    this.miMa = value;
	  }
	  /**
	   * 获取昵称
	   */
	  public String getUsName()
	  {
	    return usName;
	  }
	  /**
	   * 设置昵称
	   */
	  public void setName(String value)
	  {
	    this.usName = value;
	  }
	  /**
	   * 获取积分
	   */
	  public int getJiFen()
	  {
	    return jiFen;
	  }
	  /**
	   * 设置积分
	   */
	  public void setJiFen(int value)
	  {
	    this.jiFen = value;
	  }
	  /**
	   * 获取创建时间
	   */
	  public Date getCJTime()
	  {
	    return cJTime;
	  }
	  /**
	   * 设置创建时间
	   */
	  public void setCJTime(Date value)
	  {
	    this.cJTime = value;
	  }
	  /**
	   * 获取渠道
	   */
	  public String getQuDao()
	  {
	    return quDao;
	  }
	  /**
	   * 设置渠道
	   */
	  public void setQuDao(String value)
	  {
	    this.quDao = value;
	  }
	  /**
	   * 获取邮箱地址
	   */
	  public String getEmail()
	  {
	    return email;
	  }
	  /**
	   * 设置邮箱地址
	   */
	  public void setEmail(String value)
	  {
	    this.email = value;
	  }
	  /**
	   * 获取头像 头像图片存放地址
	   */
	  public String getHead()
	  {
	    return head;
	  }
	  /**
	   * 设置头像 头像图片存放地址
	   */
	  public void setHead(String value)
	  {
	    this.head = value;
	  }
	  /**
	   * 获取预留字段1
	   */
	  public String getQt1()
	  {
	    return qt1;
	  }
	  /**
	   * 设置预留字段1
	   */
	  public void setQt1(String value)
	  {
	    this.qt1 = value;
	  }
	  /**
	   * 获取预留字段2
	   */
	  public String getQt2()
	  {
	    return qt2;
	  }
	  /**
	   * 设置预留字段2
	   */
	  public void setQt2(String value)
	  {
	    this.qt2 = value;
	  }
	  /**
	   * 获取预留字段3
	   */
	  public int getQt3()
	  {
	    return qt3;
	  }
	  /**
	   * 设置预留字段3
	   */
	  public void setQt3(int value)
	  {
	    this.qt3 = value;
	  }	 	  



}
