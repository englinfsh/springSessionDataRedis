package com.lin.feng.sheng.bean;

import java.io.Serializable;

public class UserVo  implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 7788131520906584224L;


	public UserVo() {
		super();
	}
	public UserVo(String userName, String password, int age, Integer counts) {
		super();
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.counts = counts;
	}
	private String userName;
	private String password;
	private int age;
	private Integer counts;


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String toString() {
		return "UserVo [userName=" + userName + ", password=" + password
				+ ", age=" + age + ", counts=" + counts + "]";
	}

}
