package com.ecrops.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecrops.dto.crop.request.CCRCPullRequest;
import com.ecrops.dto.crop.response.CCRCPullResponse;
import com.ecrops.dto.crop.response.CropYearCCRC;
import com.ecrops.repo.crop.CcrcCropRepository;
import com.ecrops.repo.crop.CcrcCropServiceRepo;
import com.ecrops.service.impl.WbMasterServiceCcrc;

@Controller
public class CcrcController {

	@Autowired
	private CcrcCropServiceRepo ccrcCropServiceRepo;

	@Autowired
	private CcrcCropRepository ccrcCropRepository;

	@Autowired
	private WbMasterServiceCcrc wbMasterServiceCcrc;

	// Handle requests to the weblandCropEntry page
	@GetMapping("/ccrcCropEntry")
	public String ccrcData(Model model, HttpSession httpSession) {
		System.out.println("ccrcData is called");
		List<CropYearCCRC> activeSeasons = ccrcCropRepository.getCropYear();
		model.addAttribute("activeSeasons", activeSeasons);
		model.addAttribute("CCRCPullResponse", new CCRCPullResponse());
		return "CcrcCropEntry";
	}

	@PostMapping("/fetch-ccrc-crop-data")
	public String fetchCCRCDetails(@ModelAttribute CCRCPullRequest dto, Model model, HttpSession session,
			HttpServletRequest request) {
		try {

			/*
			 * String mandalCode=(String)session.getAttribute("mcode"); String
			 * districtCode=(String) session.getAttribute("dcode");
			 */

			Integer distCode = Integer.valueOf((String) session.getAttribute("dcode"));
			Integer mandCode = Integer.valueOf((String) session.getAttribute("mcode"));

			System.out.println("fetchCCRCDetails is called");
			// Extract user information from the session
			String userId = (String) session.getAttribute("userid");
			/*
			 * String dCodeStr = (String) session.getAttribute("wbdcode"); String mCodeStr =
			 * (String) session.getAttribute("wbmcode");
			 */

			// Extract district code and mandal code from session
			Integer dCode = (Integer)session.getAttribute("wbdcode");
			Integer mCode = (Integer) session.getAttribute("wbmcode");

			// Extract crop year information from the form
			String seasonWithYear = dto.getCropyear();
			String season = seasonWithYear.split("@")[0];
			Integer cropYear = Integer.valueOf(seasonWithYear.split("@")[1]);

			// Extract village information from the form
			String villageString = dto.getVillage().replaceAll(",", "");
			if (villageString.isEmpty()) {
				throw new IllegalArgumentException("Village number is empty");
			}
			// Parse the village code
			Integer villageCode = Integer.valueOf(villageString);
			String ipAddress = request.getRemoteAddr();

			String villageName = wbMasterServiceCcrc.getVillageNameByCode(villageCode);

			// Service method to check, insert, and view CCRC crop details
			System.out.println("Service Is calling");
			CCRCPullResponse pullResponse = ccrcCropServiceRepo.checkInsertAndViewCccrcCropDetails(cropYear, userId,
					ipAddress, dCode, villageCode, mCode, season, cropYear, mandCode, distCode);

			// Add attributes to the model for rendering in the view
			model.addAttribute("message", pullResponse.getMessage());
			model.addAttribute("TotalRecords", pullResponse.getCropDataCcrc().size());
			// model.addAttribute("selectedCropYear", season);
			// model.addAttribute("selectedVillageCode", villageCode);
			model.addAttribute("selectedVillageName", villageName);

			System.out.println("TotalRecords:------------->" + pullResponse.getCropDataCcrc().size());

			// retrieved crop data
			System.out.println("**************");
			System.out.println("cropYear:  " + cropYear);
			System.out.println("**************");
			System.out.println("selectedSeason:  " + season);
			System.out.println("**************");
			System.out.println("selectedVillageCode:   " + villageCode);
			System.out.println("**************");
			System.out.println("selectedVillageName:   " + villageName);

			return "selected-data-ccrc";
		} catch (Exception e) {
			// Handle unexpected error
			e.printStackTrace();
			model.addAttribute("errorMessage", "An unexpected error occurred");
			return "CcrcCropEntry";
		}
	}
}