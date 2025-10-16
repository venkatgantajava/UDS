package com.ecrops.dto;


public class AuthenticationRequest {

	private String username,password;
	
	 private String captcha;

	public AuthenticationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationRequest(String username, String password, String captcha) {
		super();
		this.username = username;
		this.password = password;
		this.captcha = captcha;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	@Override
	public String toString() {
		return "AuthenticationRequest [username=" + username + ", password=" + password + ", captcha=" + captcha + "]";
	}
	 

	 
}
