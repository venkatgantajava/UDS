package com.ecrops.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.entity.UserRegEntity;
import com.ecrops.repo.UserRegRepo;
import com.ecrops.service.UserRegService;

@Service
public class UserServiceImpl implements UserRegService {

	@Autowired
	private UserRegRepo userRegRepo;

	public UserServiceImpl(UserRegRepo userRegRepo) {
		super();
		this.userRegRepo = userRegRepo;
	}

	@Override
	public UserRegEntity getSessionValues(String userId) {
		String userType = userRegRepo.getUserType(userId);
		
		if (userType != null && "5".equalsIgnoreCase(userType)) {
			return userRegRepo.getSessionValuesWithoutVcode(userId);
		} else {
			return userRegRepo.getSessionValuesWithVcode(userId);
		}
	}

}
