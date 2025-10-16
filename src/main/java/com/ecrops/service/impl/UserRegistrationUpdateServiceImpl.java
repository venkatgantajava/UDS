package com.ecrops.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecrops.repo.UserRegistrationUpdate;
import com.ecrops.service.UserRegistrationUpdateService;

@Service
public class UserRegistrationUpdateServiceImpl implements UserRegistrationUpdateService {
	
	@Autowired
	UserRegistrationUpdate userRegistrationUpdate;

	public int findAll(String newpassword, String username, String dcode) {
		 return userRegistrationUpdate.updateUserReg(newpassword,username,dcode);
	}
	public int findAll(String newpassword, String username) {
		return userRegistrationUpdate.updateUserReg(newpassword,username);
	}
	
	public int findAllMao(String newpassword, String username, String dcode,String mcode) {
		 return userRegistrationUpdate.updateUserRegMao(newpassword,username,dcode,mcode);
	}
	
	public int findAllMro(String newpassword, String username, String dcode,String mcode) {
		 return userRegistrationUpdate.updateUserRegMro(newpassword,username,dcode,mcode);
	}
	
	public int insertTracer(String userid, String username) {
		return userRegistrationUpdate.insertTracer(userid,username);
	}

	public int insertTracer(String userid, String username, String dcode) {
		return userRegistrationUpdate.insertTracer(userid,username,dcode);
	}

	public int insertTracer(String userid, String username, String dcode,String mcode) {
		return userRegistrationUpdate.insertTracerMao(userid,username,dcode,mcode);
	}
	
	public int insertTracerMro(String userid, String username, String dcode,String mcode) {
		return userRegistrationUpdate.insertTracerMro(userid,username,dcode,mcode);
	}



}
