package com.ecrops.controller;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecrops.captcha.CaptchaDetails;
import com.ecrops.captcha.CaptchaGenerator;
import com.ecrops.config.Encrypt;
import com.ecrops.config.UserPrincipal;
import com.ecrops.dto.AuthenticationRequest;
import com.ecrops.entity.ActiveSeason;
import com.ecrops.entity.AppUser;
import com.ecrops.entity.UserRegEntity;
import com.ecrops.entity.User_registration;
import com.ecrops.entity.VillageSecRevEntity;
import com.ecrops.entity.WbMaster;
import com.ecrops.repo.DispatchRepo;
import com.ecrops.repo.EmpRepo;
import com.ecrops.repo.UserRegRepo;
import com.ecrops.repo.User_registrationRepository;
import com.ecrops.repo.VillageSecRevRepository;
import com.ecrops.service.LastLoginService;
import com.ecrops.service.WbMasterService;
import com.ecrops.service.impl.ActiveSeasonServiceImpl;
import com.ecrops.util.ECropUtility;
import java.util.List;
import java.util.Objects;

@Controller
public class MainController {

	@Autowired
	private Encrypt encrypt;
	@Autowired
	private EmpRepo empRep;
	@Autowired
	WbMasterService wbMasterService;

	@Autowired
	UserRegRepo userRegRepo;
	@Autowired
	private VillageSecRevRepository villageSecRevRepository;

	@Autowired
	private LastLoginService lastLoginRepo;

	@Autowired
	private ActiveSeasonServiceImpl activeSeasonService;
	@Autowired
	private User_registrationRepository user_registrationRepository;

	@Autowired
	DispatchRepo dispRep;
	String time = null;

	CaptchaDetails detail;
	@Autowired
	private CaptchaGenerator captchagenerator;

	@GetMapping("/login-auth")
	public String homePage(@ModelAttribute AuthenticationRequest authenticationRequest, Model model,
			HttpServletRequest request, HttpSession httpSession) {

		ActiveSeason active = null;
		WbMaster wbMaster = null;
		List<VillageSecRevEntity> villageSecRevEntity = null;
		ECropUtility.setSessionData();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("authentication=>" + authentication.toString());
		User_registration registration = new User_registration();
//		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

		System.out.println("-----------------" + userPrincipal.getPassword());
		httpSession.setAttribute("dcode", userPrincipal.getDcode());
//            System.out.println("dcode------->"+userPrincipal.getDcode());
		httpSession.setAttribute("mcode", userPrincipal.getMandalCode());
		httpSession.setAttribute("wbdcode", userPrincipal.getwbDcode());
		httpSession.setAttribute("wbmcode", userPrincipal.getwbMcode());
		httpSession.setAttribute("name", userPrincipal.getUsername());
		httpSession.setAttribute("role", userPrincipal.getTypeUser());
		httpSession.setAttribute("wbvcode", userPrincipal.getwbvcode());
		httpSession.setAttribute("vscode", userPrincipal.getVillCode());
		httpSession.setAttribute("userid", userPrincipal.getUserid());
		// System.out.println("last
		// login----------->"+lastLoginRepo.getLastLogin(userPrincipal.getUserid()));
		time = lastLoginRepo.getLastLogin(userPrincipal.getUserid());

		dispRep.insertWhenLogin(userPrincipal.getUserid(), request.getRemoteAddr());

		String userType = userPrincipal.getTypeUser();

		if (userPrincipal.getPassword().equals("103657e83fbc3a31181c3263965c2466")
//				|| userPrincipal.getPassword().equals("8177da925c9dccb757ae4611dc3e58a4") 
//				|| userPrincipal.getPassword().equals("8a3416c7af0b4ee38eb390a22350c283")
		) {
			if (!userPrincipal.getTypeUser().equals("5") && !userPrincipal.getTypeUser().equals("17")) {
				model.addAttribute("login",
						"As this is your first login, Please contact your admin to change your passsword");
				httpSession.setAttribute("chk", "firstTime");
				return "changePasswordRequest";
			}
			if (userType != null && ("17".equalsIgnoreCase(userType) || "64".equalsIgnoreCase(userType)
					|| "62".equalsIgnoreCase(userType) || "61".equalsIgnoreCase(userType))) {
				getHeaderMessage(userPrincipal.getName(), userPrincipal.getUsername(), "", "", "", httpSession,
						lastLoginRepo.getLastLogin(userPrincipal.getUserid()));

			} else if (userType != null && ("5".equalsIgnoreCase(userType))) {
				wbMaster = wbMasterService.getWbMasterDetailsForMandal(userPrincipal.getwbMcode(),
						userPrincipal.getwbDcode());
				if (wbMaster != null) {

					httpSession.setAttribute("wbedname", wbMaster.getWbedname());
					httpSession.setAttribute("wbemname", wbMaster.getWbemname());
					httpSession.setAttribute("wbevname", wbMaster.getWbevname());
					getHeaderMessage(userPrincipal.getName(), userPrincipal.getUsername(), wbMaster.getWbedname(),
							wbMaster.getWbemname(), "", httpSession,
							lastLoginRepo.getLastLogin(userPrincipal.getUserid()));
				}

			}

			return "home";
		}

		httpSession.setAttribute("chk", "notFirstTime");

		String user = userPrincipal.getUsername();

		if (userType != null && ("17".equalsIgnoreCase(userType) || "63".equalsIgnoreCase(userType)
				|| "64".equalsIgnoreCase(userType) || "61".equalsIgnoreCase(userType)
				|| "62".equalsIgnoreCase(userType))) {
			getHeaderMessage(userPrincipal.getName(), userPrincipal.getUsername(), "", "", "", httpSession,
					lastLoginRepo.getLastLogin(userPrincipal.getUserid()));

		} else if (userType != null && ("25".equalsIgnoreCase(userType))) {
			// System.out.println("---in---");
			villageSecRevEntity = villageSecRevRepository.getWbMasterDetailsForVillage(
					Integer.parseInt(userPrincipal.getvillCode()), userPrincipal.getwbMcode(),
					userPrincipal.getwbDcode());

			httpSession.setAttribute("wbedname", villageSecRevEntity.get(0).getWbedname());
			httpSession.setAttribute("wbemname", villageSecRevEntity.get(0).getWbemname());
			httpSession.setAttribute("wbevname", villageSecRevEntity.get(0).getWbvname());
			getHeaderMessage(
					empRep.getEmpName(Integer.parseInt(userPrincipal.getVillCode()),
							Integer.parseInt(userPrincipal.getMandalCode().toString())),
					userPrincipal.getUsername(), villageSecRevEntity.get(0).getWbedname(),
					villageSecRevEntity.get(0).getWbemname(), villageSecRevEntity.get(0).getWbvname(), httpSession,
					lastLoginRepo.getLastLogin(userPrincipal.getUserid()));
			

		} else if (userType != null && ("9".equalsIgnoreCase(userType) || "65".equalsIgnoreCase(userType))) {
			String distList = wbMasterService.findDCode(Integer.parseInt(userPrincipal.getDcode()));
			httpSession.setAttribute("wbdcode", userPrincipal.getwbDcode());
			httpSession.setAttribute("dcode", userPrincipal.getDcode());
			getHeaderMessage(userPrincipal.getName(), userPrincipal.getUsername(), distList, "", "", httpSession,
					lastLoginRepo.getLastLogin(userPrincipal.getUserid()));
		}

		else if (userType != null && ("31".equalsIgnoreCase(userType))) {

			List<String> distList = wbMasterService.findDistByCode(userPrincipal.getwbDcode());
			String distName = null;
			if (distList.size() > 0) {
				distName = distList.get(0);
			}
			httpSession.setAttribute("dcode", userPrincipal.getDcode());
			httpSession.setAttribute("mcode", userPrincipal.getMandalCode());
			getHeaderMessage(userPrincipal.getName(), userPrincipal.getUsername(), distName, "", "", httpSession,
					lastLoginRepo.getLastLogin(userPrincipal.getUserid()));
		} else if (userType != null && ("5".equalsIgnoreCase(userType))) {
			wbMaster = wbMasterService.getWbMasterDetailsForMandal(userPrincipal.getwbMcode(),
					userPrincipal.getwbDcode());
			if (wbMaster != null) {

				httpSession.setAttribute("wbedname", wbMaster.getWbedname());
				httpSession.setAttribute("wbemname", wbMaster.getWbemname());
				httpSession.setAttribute("wbevname", wbMaster.getWbevname());
				getHeaderMessage(userPrincipal.getName(), userPrincipal.getUsername(), wbMaster.getWbedname(),
						wbMaster.getWbemname(), "", httpSession, lastLoginRepo.getLastLogin(userPrincipal.getUserid()));
			}

		}

		httpSession.getId();
		System.out.println("sid" + httpSession.getId());
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("JSESSIONID")) {
					System.out.println("Cookie Value: " + cookie.getValue());
					if (!httpSession.getId().equals(cookie.getValue())) {
						System.out.println("logout");
						return "logout";
					}
				}
			}
		}

		return "home";
	}

	@GetMapping("/")
	public String loginPage(@ModelAttribute AuthenticationRequest authenticationRequest, Model model,
			HttpServletRequest request, HttpSession session, HttpServletResponse response,
			@ModelAttribute("appuser") AppUser appuser, BindingResult bindingResult) {
		System.out.println("password----------------->" + request.getParameter("password"));
		model.addAttribute("appuser", new AppUser());

		// Generate a new CAPTCHA
		detail = captchagenerator.generateCaptcha();
		model.addAttribute("usercaptcha", detail.getCaptcha());
		session.setAttribute("answer", detail.getAnswer());
		System.out.println("called");
		Integer answer = (Integer) session.getAttribute("answer");

		if (answer == null || !answer.equals(appuser.getAnswer())) {
			bindingResult.rejectValue("answer", "InvalidCaptcha", "Captcha should be equal to answer.");
		}

		String isCaptchaError = request.getParameter("captcha_error");
		String isLoginError = request.getParameter("error");
		if (Objects.nonNull(isLoginError) && "true".equalsIgnoreCase(isLoginError)) {
			model.addAttribute("msg", "Invalid Credentials");
		} else if (Objects.nonNull(isCaptchaError) && "true".equalsIgnoreCase(isCaptchaError)) {
			model.addAttribute("msg", "Invalid Captcha");
		}
		return "login";

	}

	@PreAuthorize("hasAuthority('25')  || hasAuthority('5')  || hasAuthority('17') " + " || hasAuthority('9')    "
			+ " || hasAuthority('31') ||  hasAuthority('61') ||  hasAuthority('63') ||  hasAuthority('62') ")
	@GetMapping("/home")
	public String home(@ModelAttribute AuthenticationRequest authenticationRequest, Model model,
			HttpServletRequest request, HttpSession session) {

		return "home";

	}

	public void getHeaderMessage(String name, String typeName, String district, String mandal, String village,
			HttpSession httpSession, String time) {

		String headerMessage = String.format(
				"Welcome to %s, %s, %s %s %s	\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0	Last Login : %s",
				name, typeName, getVillage(village), getMandal(mandal), getDistrict(district), time);
		httpSession.setAttribute("headerMessage", headerMessage);
	}

	public String getVillage(String village) {
		return village != null && !village.isEmpty() ? "RBK :: " + village + ", " : "";
	}

	public String getMandal(String mandal) {
		return mandal != null && !mandal.isEmpty() ? "Mandal :: " + mandal + ", " : "";
	}

	public String getDistrict(String district) {
		return district != null && !district.isEmpty() ? " District :: " + district : "";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) {

		authentication = SecurityContextHolder.getContext().getAuthentication();

		try {

			UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
			System.out.println(lastLoginRepo.updateLastLogin(userPrincipal.getUserid()));
		} catch (Exception e) {
			System.out.println(e);
		}

		String username = authentication.getName();

		if (username != null) {
			Cookie cookie = new Cookie("JSESSSIONID", null);
			cookie.setMaxAge(0);
			cookie.setSecure(true);
			cookie.setHttpOnly(true);
			cookie.setPath("/");
			response.addCookie(cookie);

		}
		new SecurityContextLogoutHandler().logout(request, response, authentication);
		session = request.getSession();
		return "redirect:/";
	}

}