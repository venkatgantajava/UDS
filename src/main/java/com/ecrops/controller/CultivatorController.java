package com.ecrops.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecrops.entity.ActiveSeason;
import com.ecrops.entity.Cultivator;
import com.ecrops.service.CultivatorService;
import com.ecrops.service.impl.ActiveSeasonServiceImpl;

@Controller
public class CultivatorController {

	@Autowired
	private CultivatorService cultivatorService;

	@Autowired
	private ActiveSeasonServiceImpl activeSeasonService;

	@GetMapping("/kathaNo")
	public String getCultivatorDetailsByKathaNo(@RequestParam("fromKhno") Integer fromKhno, Model model) {

		System.out.println("kh_no : " + fromKhno);
		List<Cultivator> cultiVatorsList = cultivatorService.getCultivatorsByKathaNo(fromKhno);
		model.addAttribute("cultivatorsList", cultiVatorsList);

		List<ActiveSeason> cropYearActiveSeasonList = activeSeasonService.listAll();
		model.addAttribute("crYearList", Arrays
				.stream(cropYearActiveSeasonList.stream().mapToInt(ActiveSeason::getCropyear).distinct().toArray())
				.boxed().collect(Collectors.toList()));
		model.addAttribute("khNoList",
				Arrays.stream(cultiVatorsList.stream().mapToInt(Cultivator::getKhNo).distinct().toArray()).boxed()
						.collect(Collectors.toList()));
		model.addAttribute("cultivator", new Cultivator());

		return "addupdatecultivator";
	}

	@GetMapping("/katha")
	public String loadAddOrUpdateCultivator(Model model) {

		List<ActiveSeason> cropYearActiveSeasonList = activeSeasonService.listAll();
		model.addAttribute("crYearList", Arrays
				.stream(cropYearActiveSeasonList.stream().mapToInt(ActiveSeason::getCropyear).distinct().toArray())
				.boxed().collect(Collectors.toList()));
		model.addAttribute("cultivator", new Cultivator());

		return "addupdatecultivator";
	}

	@PostMapping("/cultivator/save")
	public String save(Cultivator cultivator, RedirectAttributes redirectAttributes) {

		Cultivator c = cultivatorService.save(cultivator);

		redirectAttributes.addFlashAttribute("message", "The Cultivator Details has been saved successfully!");

		return "addupdatecultivator";

	}

}
