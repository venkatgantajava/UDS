package com.ecrops.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/cultivator")
	public String loadAddOrUpdateCultivator(Model model) {

		List<ActiveSeason> cropYearActiveSeasonList = activeSeasonService.listAll();
		model.addAttribute("crYearList", Arrays
				.stream(cropYearActiveSeasonList.stream().mapToInt(ActiveSeason::getCropyear).distinct().toArray())
				.boxed().collect(Collectors.toList()));
		model.addAttribute("cultivator", new Cultivator());

		return "cultivatorsearch";
	}

	@GetMapping("/cultivator/kathaNo/")
	public String getCultivatorDetailsByKathaNo(@RequestParam("fromKhno") Integer fromKhno, Model model) {

		List<Cultivator> cultiVatorsList = cultivatorService.getCultivatorsByKathaNo(fromKhno);
		model.addAttribute("ownersList", cultiVatorsList.stream().filter(c -> "O".equalsIgnoreCase(c.getOwner_tenant()))
				.collect(Collectors.toList()));

		model.addAttribute("cultivatorsList", cultiVatorsList.stream()
				.filter(c -> "T".equalsIgnoreCase(c.getOwner_tenant())).collect(Collectors.toList()));

		model.addAttribute("cultivator", new Cultivator());

		return "addupdatecultivator";
	}

	@PutMapping("/cultivator/owner/update")
	public String updateCultivatorOwnerDetails(Cultivator cultivator, RedirectAttributes redirectAttributes) {

		cultivatorService.updateCultivatorOwnerDetails(cultivator);

		return "addupdatecultivator";

	}

	@PostMapping("/cultivator/tenant/save")
	public String saveCultivatorTenantData(Cultivator cultivator, Model model) {

		cultivatorService.saveTenant(cultivator);

		List<Cultivator> cultiVatorsList = cultivatorService.getCultivatorsByKathaNo(cultivator.getKhNo());
		model.addAttribute("ownersList", cultiVatorsList.stream().filter(c -> "O".equalsIgnoreCase(c.getOwner_tenant()))
				.collect(Collectors.toList()));

		model.addAttribute("cultivatorsList", cultiVatorsList.stream()
				.filter(c -> "T".equalsIgnoreCase(c.getOwner_tenant())).collect(Collectors.toList()));

		model.addAttribute("cultivator", new Cultivator());

		return "addupdatecultivator";

	}

	@PutMapping("/cultivator/tenant/update")
	public String updateCultivatorTenantDetails(Cultivator cultivator, RedirectAttributes redirectAttributes) {

		cultivatorService.updateCultivatorTenantDetails(cultivator);

		return "addupdatecultivator";

	}

	@DeleteMapping("/cultivator/tenant/delete")
	public String deleteCultivatorTenantDetails(Cultivator cultivator, RedirectAttributes redirectAttributes) {

		cultivatorService.deleteCultivatorTenantDetails(cultivator);

		return "addupdatecultivator";

	}

}
