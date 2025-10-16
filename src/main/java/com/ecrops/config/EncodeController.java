package com.ecrops.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EncodeController {
	
	
	@GetMapping("/encode")
	public String encode() {
		
		
		return "encode";
		
		
	}
	
	
	@PostMapping("/generateHash")
	public String Hashencode() {
		
		
		return "redirect:encode";
		
		
	}

}
