package com.ecrops.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecrops.entity.ReportEntity;
import com.ecrops.repo.ReportRepo;
import com.ecrops.repo.UDSReportsRepo;

@Controller
public class ReportController {

    @Autowired
    private ReportRepo reportRepo;
    
    @Autowired
    private UDSReportsRepo udsRepo;

    
    @PreAuthorize("hasAuthority('25')")
    @GetMapping("/reportdata")
    public String getReportData(HttpSession session,Model model) {
        model.addAttribute("list", reportRepo.getReportData(Integer.parseInt(session.getAttribute("vscode").toString())));
        return "rbkroles/report";
    }
    
    
    
    
    @PreAuthorize("hasAuthority('5') || hasAuthority('25') || hasAuthority('9')  || hasAuthority('17') ")
    @GetMapping("/reportq1")
	public String q1(Model model,HttpSession session) {
    	
		model.addAttribute("list", udsRepo.getQuantity(session));

		return "mao/reportQuantity";
	}
	
    @PreAuthorize("hasAuthority('5') || hasAuthority('25') || hasAuthority('9')  || hasAuthority('17')")
	@GetMapping("/reportq2")
	public String q2(Model model,HttpSession session) {
    	
		
		model.addAttribute("list", udsRepo.getQuantityQ(session));

		//System.out.println(reportsRepo.getQuantity(5070).get(0).getVsName());
		return "mao/reportQuantityT";
	}
}