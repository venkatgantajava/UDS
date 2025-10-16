package com.ecrops.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ecrops.entity.UserRegEntity;
import com.ecrops.entity.UserTypesEntity;


public class UserPrincipal implements UserDetails {
	
	private UserRegEntity  user;
	
	@Autowired
	private UserTypesEntity tpeentity;
   

	

	

	public UserPrincipal(UserRegEntity user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("calling user principal");
		//return Collections.singleton(new SimpleGrantedAuthority("USER"));
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(UserTypesEntity role: user.getRoles()){
			
		System.out.println("role based ------------------------------------------->"+user.getRoles());	
		//authorities.add(new SimpleGrantedAuthority(role.getTypeName()));
		authorities.add(new SimpleGrantedAuthority(role.getTypeuserforroles()));
			System.out.println("ROLLE---->"+role.getTypeuserforroles());
		}
		//return Collections.singleton(new SimpleGrantedAuthority("USER"));
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getUds_encpassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserid();
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return user.getName();
	}
	
	public String getTypeUser() {
		// TODO Auto-generated method stub
		return user.getType_user();
	}
	public String getDcode() {
		// TODO Auto-generated method stub
		return user.getDistrict();
	}
	
	
	public String getvillCode(){
		return user.getVillage();
		
	}
	
	
	public String getMandalCode(){
		return user.getBlockortehsil();
		
	}
	
	public Integer getwbMcode(){
		return user.getWbmcode();
		
	}
	
	
	public Integer getwbDcode(){
		return user.getWbdcode();
		
	}
	
	

	public Integer getwbvcode(){
		return user.getWbvcode();
		
	}
	  
	public String getVillCode(){
		return user.getVillage();
		
	}
	
	public String getUserid() {
		return user.getUserid();
	}
	
//	public String getRoles(){
//		return tpeentity.getTypeName();
//		
//	}
	
	
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

}