package com.user.entity;

import java.util.Calendar;

public class User {
	
	/**表单id*/
	private int id;
	/**电话*/
	private String phone_mobile;
	/**密码*/
	private String login_password;
	/**用户编码*/
	private String user_code;
	/**注册时间*/
	private Calendar register_time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone_mobile() {
		return phone_mobile;
	}
	public void setPhone_mobile(String phone_mobile) {
		this.phone_mobile = phone_mobile;
	}
	public String getLogin_password() {
		return login_password;
	}
	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public Calendar getRegister_time() {
		return register_time;
	}
	public void setRegister_time(Calendar register_time) {
		this.register_time = register_time;
	}
}
