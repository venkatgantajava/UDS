package com.ecrops.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecrops.dto.MAOresetPassword;
import com.ecrops.entity.MandalsFusersho;
import com.ecrops.entity.VillageForHO;
import com.ecrops.repo.MandalsFhorestpwdRepository;
import com.ecrops.repo.UDSReportsRepo;
import com.ecrops.repo.VillageRepositoryFhorestpwd;
import com.ecrops.service.ChangePasswordToSha;
import com.ecrops.service.impl.UserRegistrationUpdateServiceImpl;

@Controller
public class HoPasswordResetController {
	
	@Autowired 
    private com.ecrops.service.impl.User_registrationServiceImpl  user_registrationService;
	
	@Autowired 
    private UserRegistrationUpdateServiceImpl  userRegistrationUpdateService;
	
	
	@Autowired
	ChangePasswordToSha  changepasswordsha;
	
//	@PreAuthorize("hasAuthority('17')")
//	@GetMapping("/horesetpwd")
//	public String findAl(Model theModel)
//	{
//	    return "horoles/horesetpwd";   
//	} 
//	
//	@PreAuthorize("hasAuthority('17')")
//	@PostMapping("/posthoresetpwd")
//	public String fin(Model theModel, @RequestParam("username") String username,
//			@RequestParam("newpassword") String newpaessword,
//			@RequestParam("retypenewpassword") String retypenewpassword, HttpSession httpSession) {  
////		System.out.println("------->"+newpaessword);
//		
//		String md5 = changepasswordsha.encode(newpaessword);
////		System.out.println("-------------------------------------------------------------->"+md5);
////		String dcode =(String) httpSession.getAttribute("dcode");
//		String userId1 = (String)httpSession.getAttribute("userid");
//		
//	//	System.out.println("newpassword-"+newpassword);
////		System.out.println("retypenewpassword"+retypenewpassword);
//		
//		if(!newpaessword.equals(retypenewpassword)) {
//			theModel.addAttribute("msg", "Password and Retype Password are not Matching/User Name does not exists");
////			System.out.println("if");
//		}else {
//			String userId = user_registrationService.findAll(username);
//			
//			if(userId != null) {
////				int updateUserReg = userRegistrationUpdateService.findAll(md5,username,dcode);
//				int updateUserReg = userRegistrationUpdateService.findAll(md5,username);
//				if(updateUserReg > 0) {
//					String result="The Reset pasword was done successfully!";
////					System.out.println("userid--->"+userId1);
////					System.out.println("username--->"+username);
////					System.out.println("dcode--->"+dcode);
////					int insertTracer = userRegistrationUpdateService.insertTracer(userId1, username, dcode);
//					int insertTracer = userRegistrationUpdateService.insertTracer(userId1, username);
////					System.out.println("count-->"+insertTracer);
//					
//				}
//			}else {
//				theModel.addAttribute("msg", "User Name does not exists");
//			}
//		}
//		
//		
//		return "horoles/horesetpwd";
//
//	}
	

//	@Autowired
//	private MandalRepositoryFhorestpwd mandalRepositoryFhorestpwd;
	
	@Autowired
	private VillageRepositoryFhorestpwd fhorestpwd;

	@Autowired
	private MandalsFhorestpwdRepository mandalsFhorestpwdRepository;
	
	
	@Autowired
	private UDSReportsRepo udsReportsRepo;

	
	
	@PreAuthorize("hasAuthority('25')")
	@GetMapping("/horesetpwdRsk")
	public String findAlMao(Model theModel, HttpSession httpSession) {
		String mcode = (String) httpSession.getAttribute("vscode").toString();
//		System.out.println("dcode-------->"+dcode);
		List<VillageForHO> mandals = fhorestpwd.getRbk(Integer.parseInt(mcode));
//		System.out.println("mandals------->"+mandals.size());
		theModel.addAttribute("mandal", mandals);
		return "horoles/horesetpwdrsk";
	}
	
	
	
	
	@PreAuthorize("hasAuthority('25')")
	@GetMapping("/getUseridRsk")
	@ResponseBody
	public List<MandalsFusersho> getMandalnamesFhoMao(HttpSession session) {
//		System.out.println("--------->"+mandalname);
	    List<MandalsFusersho> mandalsFho = null;
	    try {
	    	mandalsFho  = mandalsFhorestpwdRepository.getUsersMao(session.getAttribute("vscode").toString());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
//	    System.out.println("--------->"+mandalsFho.size());
	    return mandalsFho;
	}
	
	
	
	
	@PreAuthorize("hasAuthority('25')")
	@PostMapping("/posthoresetpwdRsk")
	public String finMao(Model theModel, @RequestParam("username") String username,
			@RequestParam("newpassword") String newpaessword,
			@RequestParam("retypenewpassword") String retypenewpassword, HttpSession httpSession) {
		String md5 = changepasswordsha.encode(newpaessword);
		String dcode = (String) httpSession.getAttribute("dcode");
		String mcode = (String) httpSession.getAttribute("mcode");
		String userId1 = (String) httpSession.getAttribute("userid");
		if (!newpaessword.equals(retypenewpassword)) {
			theModel.addAttribute("msg", "Password and Retype Password are not Matching/User Name does not exists");
		} else {
			String userId = user_registrationService.findAll(username);
			if (userId != null) {
				int updateUserReg = userRegistrationUpdateService.findAllMao(md5, username, dcode,mcode);
				if (updateUserReg > 0) {
					String result = "The Reset pasword was done successfully!";
					theModel.addAttribute("msg", result);
					int insertTracer = userRegistrationUpdateService.insertTracer(userId1, username, dcode,mcode);
				}
			} else {
				theModel.addAttribute("msg", "User Name does not exists");
			}
		}
		return "horoles/horesetpwdrsk";
	}
	
	

	@PreAuthorize("hasAuthority('17')")
	@GetMapping("/ddapreset")
	public String findAl(Model theModel)
	{
	    return "ddap/ddapadminResetPassword";   
	} 
	
	@PreAuthorize("hasAuthority('5')")
	@GetMapping("/horesetpwdRskDAO")
	public String findAlRSKuserid(Model theModel, HttpSession httpSession) {
		String mcode = (String) httpSession.getAttribute("vscode").toString();
//		System.out.println("dcode-------->"+dcode);
		List<VillageForHO> mandals = fhorestpwd.getRbk(Integer.parseInt(mcode));
//		System.out.println("mandals------->"+mandals.size());
		theModel.addAttribute("mandal", mandals);
		return "horoles/horesetpwdrsk";
	}
	
	@PreAuthorize("hasAuthority('9')")
	@GetMapping("/posthoresetpwdDAO")
	public String DaoResetPasswaord()
	{
		return "dao/posthoresetpwdDAO";
	}
	
	
	@PreAuthorize("hasAuthority('9')")
	@GetMapping("/getMaoData")
	@ResponseBody
	public List<MAOresetPassword> getMandalnamesFhoDAO(HttpSession session) {
//		System.out.println("--------->"+mandalname);
	    List<MAOresetPassword> mandalsFho = null;
	    try {
	    	mandalsFho  = udsReportsRepo.getMao(session.getAttribute("dcode").toString());
	    	System.out.println(mandalsFho.get(0).getMandalName());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    System.out.println("--------->"+mandalsFho.size());
	    return mandalsFho;
	}
}