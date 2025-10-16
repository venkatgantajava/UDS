package com.ecrops.entity;

import java.time.LocalDateTime; 

@javax.persistence.Entity
public class User_registration {
	
	@javax.persistence.Id
    private String userid;
    private String uds_encpassword;
    private LocalDateTime last_pwdpd_dt;
    private String retype_password;

	public User_registration() {
		
	}

	public User_registration(String userid, String uds_encpassword, LocalDateTime last_pwdpd_dt, String retype_password) {
		this.userid = userid;
		this.uds_encpassword = uds_encpassword;
		this.last_pwdpd_dt = last_pwdpd_dt;
		this.retype_password = retype_password;
	}
	  
    public String getRetype_password() {
		return retype_password;
	}
	public void setRetype_password(String retype_password) {
		this.retype_password = retype_password;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	

	public String getUds_encpassword() {
		return uds_encpassword;
	}

	public void setUds_encpassword(String uds_encpassword) {
		this.uds_encpassword = uds_encpassword;
	}

	public LocalDateTime getLast_pwdpd_dt() {
		return last_pwdpd_dt;
	}
	public void setLast_pwdpd_dt(LocalDateTime last_pwdpd_dt) {
		this.last_pwdpd_dt = last_pwdpd_dt;
	}

	@Override
	public String toString() {
		return "User_registration [userid=" + userid + ", uds_encpassword=" + uds_encpassword + ", last_pwdpd_dt="
				+ last_pwdpd_dt + ", retype_password=" + retype_password + "]";
	}

	
	
}
