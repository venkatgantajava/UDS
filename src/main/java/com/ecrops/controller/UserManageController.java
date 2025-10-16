package com.ecrops.controller;

import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecrops.config.EmailValidator;
import com.ecrops.config.RegularExpressionclassMethod;
import com.ecrops.entity.UserRegEntity;
import com.ecrops.repo.UserDeactiVationRepo;
import com.ecrops.repo.UserRegRepo;
import com.ecrops.repo.UserRegistrationRepoForProfile;
import com.ecrops.repo.UserRegistrationRepository;
import com.ecrops.repo.UserRegistrationUpdate;
import com.ecrops.repo.UserTypesRepo;
import com.ecrops.util.Verhoeff;
import com.itextpdf.text.log.SysoCounter;


@Controller
public class UserManageController {
	
	

	
@Autowired
	
	private EmailValidator emailValidator;
	@Autowired
	UserRegRepo userRepo;
	
	@Autowired
	UserRegistrationRepoForProfile userRegRepo;
	
	
	@Autowired
	UserDeactiVationRepo userDeactivation;
	
	@Autowired
	UserTypesRepo userTypeRepo;
	@Autowired
	EncryptionController encryptionController;

	@PreAuthorize("!hasAuthority('25')")

//	@GetMapping("/updateProfiles1")
	public String changePwd(HttpSession session,Model model) {

		 String userid=(String) session.getAttribute("name").toString();
		 String role=(String) session.getAttribute("role").toString();
        UserRegEntity userDetails=userRepo.getUserDetailsForProfileUpdate(userid);
      	model.addAttribute("userDetails", userDetails);
      	model.addAttribute("userid",userid);
      	model.addAttribute("role",userTypeRepo.getUserType(Integer.parseInt(role)).get(0).getWbvname());
      	
     System.out.println("useredd::"+session.getAttribute("wbedname"));
      
      	if(session.getAttribute("wbedname")!=null) {
      		model.addAttribute("district",session.getAttribute("wbedname").toString());
      	}
      	else {
      		model.addAttribute("district","");
      	}
      	
      	return "usermanagement/ChangePwd";
	}
	
	@PreAuthorize("!hasAuthority('25')")
//	@PostMapping("/updateProfiles")
	public String pwdUpdated(@RequestParam("name") String name,@RequestParam("mobile") String mobile,@RequestParam("email") String email,
			@RequestParam("aadhaar") String aadhar, Model model,HttpSession session,HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception {
		System.out.println("------------"+aadhar);
		
		
		if( name == null || name.equals("") || mobile.equals("") || mobile==null    || email==null || email.isEmpty() || aadhar==null || aadhar.equals("") || mobile.length()!=10  ) {
	    	return "ErrorPage";
	    }
		String endata="";
		
		String eaid=new String (Base64.getDecoder().decode(aadhar ));
		
		
		try {
			
			 endata = encryptionController.decryptData(eaid);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String firstSixdigits=endata.substring(0, 6);
		String aid2=endata.substring(6, 18);
		
		
		
	//	String aadhaar= new String (Base64.getDecoder().decode(aadhar));
		
		
		
		
	//	String endata = encryptionController.decryptData(aadhaar);
		System.out.println("endata--->>"+endata);
		


    String userid=(String) session.getAttribute("name").toString();
   
    String role =(String) session.getAttribute("role").toString();
    String sts="";
    if(Integer.parseInt(role)==30) {
    	 sts=request.getParameter("inchargeSts");
    	System.out.println("Status---------->"+sts);
    }
     
      if(userRegRepo.findByAadharIdAndUseridNot(aid2,userid).size()>0) {
    	  System.out.println("userRegRepo.findByAadharIdAndUseridNot(aadhaar,userid).size()>>>>>>>>>>>>>>"+userRegRepo.findByAadharIdAndUseridNot(aid2,userid).size());
    	  redirectAttributes.addFlashAttribute("msg", "Aadhaar No Already Exists");
      }else {
    	  int i=  userDeactivation.insertIntoUserDeactivation(userid);
    	if(i==1) {
    		boolean uid=Verhoeff.validateVerhoeff(aid2);
    		//boolean mail = RegularExpressionclassMethod.checkstring(email);
    		boolean mail =EmailValidator.isValidEmail(email);
    		
    		boolean phno = RegularExpressionclassMethod.checkstring(mobile);
    		//boolean nam = RegularExpressionclassMethod.checkstring(name);
    		boolean nam =EmailValidator.isValidString(name);
    		System.out.println("uid"+uid);
    		if(uid && mail && phno && nam)
    		{
    		int status =userDeactivation.userUpdation(name,mobile,email,aid2,userid,sts,role);
    		  if(status==1) {
    			userDeactivation.insertIntoTraceWeb(name,userid,role,request );
    	    	 redirectAttributes.addFlashAttribute("msg", "Profile Updated successfully");

    		  }}
    		  else{
    		    	 redirectAttributes.addFlashAttribute("msg", "Improper Data Found");

    		  }
    		  
    	  }
      }
    
	return "redirect:/updateProfiles1";
	}
	
	
	@PreAuthorize("!hasAuthority('25')")
//	@GetMapping("/updateProfile")
	public String updateProfile(HttpSession session,Model model) {
	return "UpdateProfile";
	}
	
	
	
	//@PreAuthorize("!hasAuthority('25')")
	//@GetMapping("/updateSignature")
	public String updateProfileName(HttpSession session,Model model) {
		   String userid=(String) session.getAttribute("name").toString();
		    model.addAttribute(userid, userid);
	return "usermanagement/signature";
	}

	//@PostMapping("/updateSignature")
	public String updateProfiles(HttpSession session,Model model) {
	return "usermanagement/signature";
	}
	
	
	
	
}
