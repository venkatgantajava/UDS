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
import com.ecrops.entity.WbMaster;
import com.ecrops.service.AuthenticationService;
import com.ecrops.service.UserRegService;
import com.ecrops.service.WbMasterService;

@Controller
public class MainController {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private Encrypt encrypt;

	@Autowired
	UserRegService userRegService;

	@Autowired
	WbMasterService wbMasterService;

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
			HttpServletRequest request, HttpSession session) {
		try {
			final UserDetails userDetails = authenticationService
					.loadUserByUsername(authenticationRequest.getUsername());
			String encpassword = authenticationRequest.getPassword();
			String password = encrypt.setSha256Password(userDetails.getPassword());
			if (encpassword.equals(password)) {
				UserRegEntity userRegEntity = userRegService.getSessionValues(authenticationRequest.getUsername());
				setSessionValues(session, userRegEntity);
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

	public void setSessionValues(HttpSession httpSession, UserRegEntity userRegEntity) {
		String userType = userRegEntity.getType_user();
		WbMaster wbMaster = null;

		String typeName = userRegEntity.getUserTypesEntity().getTypeName();
		if (userType != null && "17".equalsIgnoreCase(userType)) {
			getHeaderMessage(userRegEntity.getName(), typeName, "", "", "", httpSession);
		} else if (userType != null && "5".equalsIgnoreCase(userType)) {
			wbMaster = wbMasterService.getWbMasterDetailsForMandal(userRegEntity.getWbMcode(),
					userRegEntity.getWbDcode());
			httpSession.setAttribute("wbedname", wbMaster.getWbedname());
			httpSession.setAttribute("wbemname", wbMaster.getWbemname());
			httpSession.setAttribute("dcode", userRegEntity.getDistCode());
			httpSession.setAttribute("mcode", userRegEntity.getMandCode());
			httpSession.setAttribute("wbdcode", userRegEntity.getWbDcode());
			httpSession.setAttribute("wbmcode", userRegEntity.getWbMcode());

			getHeaderMessage(userRegEntity.getName(), typeName, wbMaster.getWbedname(), wbMaster.getWbemname(), "",
					httpSession);

		} else if (userType != null && "25".equalsIgnoreCase(userType)) {
			wbMaster = wbMasterService.getWbMasterDetailsForVillage(userRegEntity.getWbvcode(),
					userRegEntity.getWbMcode(), userRegEntity.getWbDcode());
			httpSession.setAttribute("wbedname", wbMaster.getWbedname());
			httpSession.setAttribute("wbemname", wbMaster.getWbemname());
			httpSession.setAttribute("wbevname", wbMaster.getWbevname());
			httpSession.setAttribute("dcode", userRegEntity.getDistCode());
			httpSession.setAttribute("wbdcode", userRegEntity.getWbDcode());
			httpSession.setAttribute("mcode", userRegEntity.getMandCode());
			httpSession.setAttribute("wbmcode", userRegEntity.getWbMcode());
			httpSession.setAttribute("wbvcode", userRegEntity.getWbvcode());

			getHeaderMessage(userRegEntity.getName(), typeName, wbMaster.getWbedname(), wbMaster.getWbemname(),
					wbMaster.getWbevname(), httpSession);

		} else if (userType != null && "31".equalsIgnoreCase(userType)) {
			getHeaderMessage(userRegEntity.getName(), typeName, "", "", "", httpSession);
		} else if (userType != null && "9".equalsIgnoreCase(userType)) {
			getHeaderMessage(userRegEntity.getName(), typeName, "", "", "", httpSession);
		} else if (userType != null && "22".equalsIgnoreCase(userType)) {
			getHeaderMessage(userRegEntity.getName(), typeName, "", "", "", httpSession);
		} else if (userType != null && "19".equalsIgnoreCase(userType)) {
			getHeaderMessage(userRegEntity.getName(), typeName, "", "", "", httpSession);
		} else if (userType != null && "18".equalsIgnoreCase(userType)) {
			getHeaderMessage(userRegEntity.getName(), typeName, "", "", "", httpSession);
		} else if (userType != null && "30".equalsIgnoreCase(userType)) {
			getHeaderMessage(userRegEntity.getName(), typeName, "", "", "", httpSession);
		} else if (userType != null && "2".equalsIgnoreCase(userType)) {
			getHeaderMessage(userRegEntity.getName(), typeName, "", "", "", httpSession);
		} else if (userType != null && "46".equalsIgnoreCase(userType)) {
			getHeaderMessage(userRegEntity.getName(), typeName, "", "", "", httpSession);
		} else if (userType != null && "44".equalsIgnoreCase(userType)) {
			getHeaderMessage(userRegEntity.getName(), typeName, "", "", "", httpSession);
		} else if (userType != null && "45".equalsIgnoreCase(userType)) {
			getHeaderMessage(userRegEntity.getName(), typeName, "", "", "", httpSession);
		}

		httpSession.setAttribute("role", userRegEntity.getType_user());
		httpSession.setAttribute("name", userRegEntity.getName());
		httpSession.setAttribute("userid", userRegEntity.getUserid());
		httpSession.setAttribute("typename", userRegEntity.getUserTypesEntity().getTypeName());
		httpSession.setAttribute("userType", userRegEntity.getUserTypesEntity().getUserType());

	}

	public void getHeaderMessage(String name, String typeName, String district, String mandal, String village,
			HttpSession httpSession) {

		String headerMessage = String.format("Welcome to %s %s %s %s %s", name, typeName, getVillage(village),
				getMandal(mandal), getDistrict(district));
		httpSession.setAttribute("headerMessage", headerMessage);
	}

	public String getVillage(String village) {
		return village != null && !village.isEmpty() ? village + "::Village, " : "";
	}

	public String getMandal(String mandal) {
		return mandal != null && !mandal.isEmpty() ? mandal + "::Mandal, " : "";
	}

	public String getDistrict(String district) {
		return district != null && !district.isEmpty() ? district + " ::District" : "";
	}

}
