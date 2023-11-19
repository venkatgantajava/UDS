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
import com.ecrops.repo.UserRegRepo;
import com.ecrops.service.AutenticationService;
import com.ecrops.service.UserRegService;

@Controller
public class MainController {

	@Autowired
	private AutenticationService autenticationService;

	@Autowired
	private Encrypt encrypt;

	@Autowired
	private UserRegRepo regRepo;
	
	@Autowired
	UserRegService userRegService;
	

	AppUser user;

	@GetMapping("/login")
	public String loginPage(@ModelAttribute AuthenticationRequest authenticationRequest, Model model,
			HttpServletRequest request) {

		return "login";
	}

	@PostMapping("/login-auth")
	public String loginUser(@ModelAttribute AuthenticationRequest authenticationRequest, Model model,
			HttpServletRequest request, HttpSession httpSession) {
		try {
			final UserDetails userDetails = autenticationService
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
				httpSession.setAttribute("userid", entity.getUserid());
				httpSession.setAttribute("typename", entity.getUserTypesEntity().getTypeName());
				model.addAttribute("typename", entity.getUserTypesEntity().getTypeName());
				model.addAttribute("village", entity.getVillCode());
				model.addAttribute("wbedname", entity.getWebMaster().getWbedname());
				model.addAttribute("wbemname", entity.getWebMaster().getWbemname());
				model.addAttribute("wbevname", entity.getWebMaster().getWbemname());
				
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

//	@RequestMapping("/")
//	public String home(Model model, HttpSession session) {
//		System.out.println("11111111111111111111111");
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String email = authentication.getName();
//		System.out.println("email-------------------------------=======> " + email);
//		 model.addAttribute("order",new Order());
//		user = appUsersRepo.findByUserid(email);
//
//		session.setAttribute("Dcode", user.getDcode());
//
//		System.out.println("user===> " + user.toString());
//
//		System.out.println(user.getDcode());
//		session.setAttribute("dcode", user.getDcode());
//		System.out.println("dcode------------->" + session.getAttribute("dcode"));
//		session.setAttribute("mcode", user.getMcode());
//		System.out.println("mcode--------->" + session.getAttribute("mcode"));
//
//		String userDetails = districtRepo.getDistByDcodeAndUserId(user.getUserid());
//		// String mandalCode=districtRepo. getDistByDcodeAndUserId(user.getMcode());
//		String distcode = userDetails.split(",")[0];
//		String mandcode = userDetails.split(",")[1];
//		String role = userDetails.split(",")[2];
//		System.out.println("district:" + distcode);
//		System.out.println("Mandal code:" + mandcode);
//		System.out.println("role:" + role);
//		session.setAttribute("WBDCODE", distcode);
//		session.setAttribute("WBMCODE", distcode);
//
//		/*
//		 * String
//		 * mandal=mandalRepo.getByMandalName(user.getDcode(),user.getMcode(),email);
//		 * System.out.println("mandal"+mandal); session.setAttribute("mandalName",
//		 * mandal);
//		 */
//
//		Collection<Roles> roles = user.getRoles();
//		roles.stream().forEach(a -> session.setAttribute("role", a.getName()));
//		// System.out.println("role===>"+session.getAttribute("role"));
//		return "home";
//	}

}
