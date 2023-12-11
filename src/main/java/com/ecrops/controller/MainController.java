package com.ecrops.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecrops.config.Encrypt;
import com.ecrops.dto.AuthenticationRequest;
import com.ecrops.entity.AppUser;
import com.ecrops.entity.UserRegEntity;
import com.ecrops.service.AuthenticationService;
import com.ecrops.service.UserRegService;

@Controller
public class MainController {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private Encrypt encrypt;

	@Autowired
	UserRegService userRegService;

	AppUser user;

	@GetMapping("/home")
	public String homePage(@ModelAttribute AuthenticationRequest authenticationRequest, Model model,
			HttpServletRequest request) {

		return "home";
	}
	
	@GetMapping("/login")
	public String loginPage(@ModelAttribute AuthenticationRequest authenticationRequest, Model model,
			HttpServletRequest request) {

		return "login";
	}

	@PostMapping("/login-auth")
	public String loginUser(@ModelAttribute AuthenticationRequest authenticationRequest, Model model,
			HttpServletRequest request, HttpSession httpSession) {
		try {
			final UserDetails userDetails = authenticationService
					.loadUserByUsername(authenticationRequest.getUsername());
			String password = userDetails.getPassword();
			String encpassword = authenticationRequest.getPassword();
			String passwrd = encrypt.setSha256Password(password);
			if (encpassword.equals(passwrd)) {
				UserRegEntity entity = userRegService.getSessionValues(authenticationRequest.getUsername());

				httpSession.setAttribute("dcode", entity.getDistCode());
				httpSession.setAttribute("mcode", entity.getMandCode());
				httpSession.setAttribute("village", entity.getVillCode());
				httpSession.setAttribute("role", entity.getType_user());
				httpSession.setAttribute("name", entity.getName());
				httpSession.setAttribute("userid", entity.getUserid());
				httpSession.setAttribute("typename", entity.getUserTypesEntity().getTypeName());
				httpSession.setAttribute("wbedname", entity.getWebMaster().getWbedname());
				httpSession.setAttribute("wbemname", entity.getWebMaster().getWbemname());
				httpSession.setAttribute("wbevname", entity.getWebMaster().getWbevname());
				
				httpSession.setAttribute("wbvcode", entity.getWbvcode());
				httpSession.setAttribute("wbdcode", entity.getWbDcode());
				httpSession.setAttribute("wbmcode", entity.getWbMcode());
				return "home";
			} else {
				model.addAttribute("msg", "Invalid Credentials");
				return "login";
			}

		} catch (BadCredentialsException e) {
			e.printStackTrace();
		}

		return "home";
	}

}
