package com.ecrops.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecrops.dto.MAOresetPassword;
import com.ecrops.entity.MandalsFusersho;
import com.ecrops.repo.UDSReportsRepo;
import com.ecrops.service.ChangePasswordToSha;
import com.ecrops.service.impl.UserRegistrationUpdateServiceImpl;

@Controller
public class ResetPasswordController {
	@Autowired
	ChangePasswordToSha changepasswordsha;

	@Autowired
	private com.ecrops.service.impl.User_registrationServiceImpl user_registrationService;

	@Autowired
	private UserRegistrationUpdateServiceImpl userRegistrationUpdateService;
	
	
	@Autowired
	private UDSReportsRepo udsReportsRepo;

	//@PreAuthorize("hasAuthority('9') || hasAuthority('25') ")
	@GetMapping("/horesetpwd")
	public String findAl(Model theModel, @ModelAttribute("result") String result) {
	    return "fmadmin/horesetpwd";
	}
	
	
	
	@GetMapping("/resetMaoPassword")
	public String resetMaoPasswordPage(Model model,HttpSession httpSession) {
		String userId1 = (String) httpSession.getAttribute("userid");
		model.addAttribute("MAOname", userId1);
		return "mao/resetMaoPassword";
	}
	
	
	@GetMapping("/resetMaoPasswordForBelowUsers")
	public String resetMaoPasswordBelowUsersPage(Model model,HttpSession httpSession) {
		
		return "mao/resetPasswordForBelowUsers";
	}
	
	@PreAuthorize("hasAuthority('5')")
	@PostMapping("/postMaoPassword")
	public String resetMaoPassword(Model theModel, @RequestParam("username") String username,
            @RequestParam("newpassword") String newpaessword,
            @RequestParam("retypenewpassword") String retypenewpassword,
            HttpSession httpSession, RedirectAttributes redirect) {
		try {
		  String result = "";
		  String md5 = changepasswordsha.encode(newpaessword);
		
		  String userId1 = (String) httpSession.getAttribute("userid");
		  String role = (String) httpSession.getAttribute("role");
		  
		  System.err.println("role=====>"+role);
		  System.err.println("role=====>"+userId1);
		  System.err.println(userId1 != null && userId1.startsWith("MAO_"));
		  
		  if (!"5".equals(role) || userId1 == null || !username.startsWith("MAO_") && !username.startsWith("RBK_")) {
			    redirect.addFlashAttribute("result", "Not Allowed");
			    return "redirect:/resetMaoPassword";
			}
		  
		
		  if (!newpaessword.equals(retypenewpassword)) {
		      result = "Password and Retype Password are not Matching";
		      redirect.addFlashAttribute("result", result);
		      return "redirect:/resetMaoPassword";
		  }
		  
		//  if(newpaessword.equalsIgnoreCase("Test@123") || newpaessword.equalsIgnoreCase("Agri@123")|| newpaessword.equalsIgnoreCase("Test@1234") || newpaessword.equalsIgnoreCase("Agri@1234"))
		//	{
		//		result="New Password should not be Default Password";
		//	}
		  
		  
		
		  String userId = user_registrationService.findAll(username);
		  if (userId == null) {
		      result = "Invalid Userid";
		      redirect.addFlashAttribute("result", result);
		      return "redirect:/resetMaoPassword";
		  }
		
		      int updateUserReg = userRegistrationUpdateService.findAll(md5, username);
		      if (updateUserReg > 0) {
		          result = "Password Changed successfully !";
		      } else {
		          result = "Password Reset Unsuccessful";
		      }
		
		  redirect.addFlashAttribute("result", result);
		  return "redirect:/resetMaoPassword";
		
		} catch (Exception e) {
		  e.printStackTrace(); 
		  redirect.addFlashAttribute("result", "An unexpected error occurred. Please try again.");
		  return "redirect:/resetMaoPassword";
		}
}

	
	@GetMapping("/resetDaoPassword")
	public String resetDaoPassword(Model model,HttpSession httpSession) {
		String userId1 = (String) httpSession.getAttribute("userid");
		model.addAttribute("DAOname", userId1);
		return "Dao/resetDaoPassword";
	}
	
	
	@PreAuthorize("hasAuthority('5')")
	@GetMapping("/getUseridMao")
	@ResponseBody
	public List<MAOresetPassword> getMandalnamesFhoMao(HttpSession session) {
//		System.out.println("--------->"+mandalname);
	    List<MAOresetPassword> mandalsFho = null;
	    try {
	    	mandalsFho  = udsReportsRepo.getRsk(session.getAttribute("mcode").toString());
	    	System.out.println(mandalsFho.get(0).getMandalName());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    System.out.println("--------->"+mandalsFho.size());
	    return mandalsFho;
	}
	
	

	
	
	@PostMapping("/postDaoResetpassword")
	public String daoResetPassword(Model theModel, @RequestParam("username") String username,
	                  @RequestParam("newpassword") String newpaessword,
	                  @RequestParam("retypenewpassword") String retypenewpassword,
	                  HttpSession httpSession, RedirectAttributes redirect) {
	    try {
	        String result = "";
	        String md5 = changepasswordsha.encode(newpaessword);

	        String userId1 = (String) httpSession.getAttribute("userid");
	        String role = (String) httpSession.getAttribute("role");
	        
	        
	        if(!username.startsWith("DAO_")&&!username.startsWith("MAO_")) {
	        	result = "Not allowed";
	            redirect.addFlashAttribute("result", result);
	            return "redirect:/resetDaoPassword";
	        }
	        	
	        
	        

	        if (!newpaessword.equals(retypenewpassword)) {
	            result = "Password and Retype Password are not Matching";
	            redirect.addFlashAttribute("result", result);
	            return "redirect:/resetDaoPassword";
	        }
	        
//	        if(newpaessword.equalsIgnoreCase("Test@123") || newpaessword.equalsIgnoreCase("Agri@123")|| newpaessword.equalsIgnoreCase("Test@1234") || newpaessword.equalsIgnoreCase("Agri@1234"))
//			{
//				result="New Password should not be Default Password";
//			}
	        
	        

	        String userId = user_registrationService.findAll(username);
	        if (userId == null) {
	            result = "Invalid Userid";
	            redirect.addFlashAttribute("result", result);
	            return "redirect:/resetDaoPassword";
	        }

	            int updateUserReg = userRegistrationUpdateService.findAll(md5, username);
	            if (updateUserReg > 0) {
	                result = "Password Changed successfully !";
	            } else {
	                result = "Password Reset Unsuccessful";
	            }

	        redirect.addFlashAttribute("result", result);
	        return "redirect:/resetDaoPassword";

	    } catch (Exception e) {
	        e.printStackTrace(); 
	        redirect.addFlashAttribute("result", "An unexpected error occurred. Please try again.");
	        return "redirect:/resetDaoPassword";
	    }
	}




	@PostMapping("/posthoresetpwd")
	public String fin(Model theModel, @RequestParam("username") String username,
	                  @RequestParam("newpassword") String newpaessword,
	                  @RequestParam("retypenewpassword") String retypenewpassword,
	                  HttpSession httpSession, RedirectAttributes redirect) {
	    try {
	        String result = "";
	        String md5 = changepasswordsha.encode(newpaessword);

	        String userId1 = (String) httpSession.getAttribute("userid");
	        String role = (String) httpSession.getAttribute("role");
	        
	        

	        if (!newpaessword.equals(retypenewpassword)) {
	            result = "Password and Retype Password are not Matching";
	            redirect.addFlashAttribute("result", result);
	            return "redirect:/ddapreset";
	        }
	        
//	        if(newpaessword.equalsIgnoreCase("Test@123") || newpaessword.equalsIgnoreCase("Agri@123")|| newpaessword.equalsIgnoreCase("Test@1234") || newpaessword.equalsIgnoreCase("Agri@1234"))
//			{
//				result="New Password should not be Default Password";
//			}
	        
	        

	        String userId = user_registrationService.findAll(username);
	        if (userId == null) {
	            result = "Invalid Userid";
	            redirect.addFlashAttribute("result", result);
	            return "redirect:/ddapreset";
	        }

	            int updateUserReg = userRegistrationUpdateService.findAll(md5, username);
	            if (updateUserReg > 0) {
	                result = "Password Changed successfully !";
	            } else {
	                result = "Password Reset Unsuccessful";
	            }

	        redirect.addFlashAttribute("result", result);
	        return "redirect:/ddapreset";

	    } catch (Exception e) {
	        e.printStackTrace(); 
	        redirect.addFlashAttribute("result", "An unexpected error occurred. Please try again.");
	        return "redirect:/ddapreset";
	    }
	}

	// RestPassword

	@PreAuthorize("hasAuthority('61') || hasAuthority('62') || hasAuthority('63') || hasAuthority('31') || hasAuthority('9') || hasAuthority('5') || hasAuthority('64') || hasAuthority('25')")
	@GetMapping("/resetPassword")
	public String resetPassword(Model theModel) {
		return "fmadmin/resetPassword";
	}

	@PreAuthorize("hasAuthority('61') || hasAuthority('62') || hasAuthority('63') || hasAuthority('31') || hasAuthority('9') || hasAuthority('25') || hasAuthority('64')")
	@PostMapping("/resetPwd")
	public String resetPasswords(Model theModel, @RequestParam("username") String username,
			@RequestParam("newpassword") String newpaessword,
			@RequestParam("retypenewpassword") String retypenewpassword, HttpSession httpSession,RedirectAttributes redirect) {
		String result="";
		String md5 = changepasswordsha.encode(newpaessword);

		String userId1 = (String) httpSession.getAttribute("userid");

		if (!newpaessword.equals(retypenewpassword)) {
			theModel.addAttribute("msg", "Password and Retype Password are not Matching/User Name does not exists");
			result="Password and Retype Password are not Matching/User Name does not exists";
		}
		
		
		if(newpaessword.equalsIgnoreCase("Test@123") || newpaessword.equalsIgnoreCase("Agri@123")|| newpaessword.equalsIgnoreCase("Test@1234") || newpaessword.equalsIgnoreCase("Agri@1234"))
		{
			result="New Password should not be Default Password";
		}
		
		else {
			String userId = user_registrationService.findAll(username);

			if (userId != null) {
				
				int updateUserReg = userRegistrationUpdateService.findAll(md5, username);
				if (updateUserReg > 0) {
					 result = "The Change password was  successfull !";

					int insertTracer = userRegistrationUpdateService.insertTracer(userId1, username);

				}
				else {
					 result = "The Change password  was  Unsuccessfull !";
				}
			}
			else {
				theModel.addAttribute("msg", "User Name does not exists");
				result="User Name does not exists";
			}
		}

        redirect.addFlashAttribute("result", result);
        return "redirect:/resetPassword";

	}

}
