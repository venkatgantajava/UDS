package com.ecrops.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecrops.entity.UserRegEntity;
import com.ecrops.repo.UserRegRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	
    @Autowired
    private UserRegRepo userRepository;
    
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	System.out.println("username------------------------------------------------->"+username);
    	UserRegEntity user = userRepository.findByUserid(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
     

      
        return new UserPrincipal(user);
       
    }
    

    
    
    
}