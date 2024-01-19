package com.ecrops.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.ecrops.dao.EcropDaoImpl;
import com.ecrops.dto.FormData;
import com.ecrops.dto.NonWebData;
import com.ecrops.entity.ActiveSeason;
//import com.ecrops.entity.Cr_Booking_PartitionEntity;
import com.ecrops.entity.NonWebLandData;
import com.ecrops.entity.NonWebReasonsEntity;
import com.ecrops.entity.PattMst_NonWebland;
import com.ecrops.entity.VillageEntity;
import com.ecrops.entity.WbMaster;
import com.ecrops.projection.ActiveSeasonProjection;
import com.ecrops.projection.SurveyNoProjection;
import com.ecrops.repo.Cr_booking_PartitionRepo;
import com.ecrops.repo.NonWebLandRepo;
import com.ecrops.repo.NonWebReasonsRepo;
import com.ecrops.repo.Patt_Mst_NonWebLandRepo;
//import com.ecrops.repo.VillageSecRevRepo;
import com.ecrops.service.DynamicTableService;
import com.ecrops.service.NonWebLandDataEntryService;
import com.ecrops.service.WbMasterService;
import com.ecrops.service.impl.ActiveSeasonServiceImpl;

@Controller
public class NonWebLandFarmersDataController {

	@Autowired

	private NonWebLandRepo nonWebLandRepo;

	@Autowired

	private DynamicTableService dynamicTableService;

	@Autowired

	private Patt_Mst_NonWebLandRepo patt_Mst_NonWebLandRepo;

	@Autowired

	private NonWebLandDataEntryService nonWebLandDataEntryService;

//	@Autowired
//	private ActiveSeasonServiceImpl ActiveSeasonServiceImpl;

	@Autowired

	private NonWebReasonsRepo nonWebReasonsRepo;
	
	@Autowired 
	
	private AadharValidationController aadharValidationController;

//	@Autowired
//	private VillageSecRevRepo villageSecRevRepo;

	@Autowired
	WbMasterService wbMasterService;
	
	@Autowired
	private ActiveSeasonServiceImpl activeSeasonService;

	@Autowired
	private Cr_booking_PartitionRepo cr_booking_PartitionRepo;

	@GetMapping("/nonweblandfarmersdata")

	public String farmersdata(Model model, HttpSession httpSession) {
		List<ActiveSeason> crandseason = activeSeasonService.listAll();
		Integer dcode = Integer.parseInt( (String) httpSession.getAttribute("dcode"));
		Integer mcode = Integer.parseInt( (String) httpSession.getAttribute("mcode"));
		//Integer dcode = (Integer) httpSession.getAttribute("dcode");
		//Integer mcode = (Integer) httpSession.getAttribute("mcode");
		
		List<WbMaster> village = wbMasterService.findWebVcodeAndVname(dcode, mcode);
		model.addAttribute("village", village);

		Object wbvcode = httpSession.getAttribute("wbvcode");
		Object wbevname = httpSession.getAttribute("mcode");

		Object wbdcode = httpSession.getAttribute("wbdcode");
		Object wbmcode = httpSession.getAttribute("wbmcode");

		System.out.println(httpSession.getAttribute("dcode"));

		model.addAttribute("crandseason", crandseason);

		return "nonwebland";

	}

	@PostMapping(path = "/surveyno", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)

	public String post(@ModelAttribute FormData formData, Model model, HttpSession httpSession,
			RedirectAttributes redirectAttributes, @RequestParam("vcode") String selectedVillageCode) {

		String surveyno = formData.getSurvyNo();
		System.out.println("surveyno::" + surveyno);

		int wbvcode = Integer.parseInt(selectedVillageCode);
		List<ActiveSeason> crandseason = activeSeasonService.listAll();
		Integer cropyear = crandseason.get(0).getCropyear();
		Integer activeYear = crandseason.get(0).getCropyear();
		//String a=aadharValidationController.validateAadhar(aadharno);
		String season = crandseason.get(0).getSeason();
		String[] str = season.split("@");
		//int crop_year = Integer.parseInt(str[1]);
		//String crop_Season = str[0];
		Integer wbdcode = (Integer) httpSession.getAttribute("wbdcode");

		//String partion_table="cr_booking_partition_"+season+wbdcode+cropyear;
		//String partition_table="ecrop"+"2023"+"."+"cr_booking_partition_r042023";
		
		String partion_table="cr_booking_partition_";
		
		// String srno = "";

	    if(wbdcode <= 9) {
	    	partion_table = partion_table + season + "0" + wbdcode + cropyear;
	    } else {
	    	partion_table = partion_table + season + wbdcode + cropyear;
	    }

	    if (activeYear == cropyear) {
	    	partion_table = "ecrop" + activeYear + "." + partion_table;
	    }
	    String srno = cr_booking_PartitionRepo.findSurveyNo(partion_table,wbvcode, surveyno);
		
		model.addAttribute("srno", srno);
		model.addAttribute("surveyno", surveyno);
		if (surveyno.equalsIgnoreCase(srno)) {
			String msg = "Survey number already exists";
			redirectAttributes.addFlashAttribute("msg", msg);

			return "redirect:/nonweblandfarmersdata";

		} else {
			int vcode = Integer.parseInt(selectedVillageCode);

			String msg = "Survey number doesnot exist";
			model.addAttribute("msg", msg);
			List<NonWebReasonsEntity> reasons = nonWebReasonsRepo.findReason();
			model.addAttribute("reasons", reasons);
			
			Integer dcode = Integer.parseInt((String) httpSession.getAttribute("dcode"));
			Integer mcode = Integer.parseInt((String) httpSession.getAttribute("mcode"));

			List<WbMaster> village = wbMasterService.findVillageName(dcode, mcode, vcode);
			String wbvname = village.get(0).getWbvname();
			int wbvcodes = village.get(0).getWbvcode();
			model.addAttribute("wbvname", wbvname);

			model.addAttribute("village", village);
			model.addAttribute("vcode" + vcode);
			model.addAttribute("wbvcodes", wbvcodes);
			return "surveynodoesnotexist";

		}

	}

	@PostMapping(path = "/postdata", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String postdata(@ModelAttribute NonWebLandData nonWebLandData,
			@ModelAttribute PattMst_NonWebland pattMst_NonWebland, Model model, HttpSession httpSession,
			@RequestParam("vcode") int villageCode, @RequestParam("cr_farmeruid") String aadharNo,
			@RequestParam("cr_sno") String cr_sno, @RequestParam("kh_no") int kh_no, @RequestParam("cr_farmeruid") String aadharno) {
		System.out.println("villageCode" + villageCode);
		List<ActiveSeason> crandseason = activeSeasonService.listAll();

		//List<ActiveSeasonProjection> crandseason = ActiveSeasonServiceImpl.seasonAndYearDetails();
		//String cropyear = crandseason.get(0).getCropyear();
		Integer cropyear = crandseason.get(0).getCropyear();

		String a=aadharValidationController.validateAadhar(aadharno);
		//String season = crandseason.get(0).getSeasonvalue();
		String season = crandseason.get(0).getSeason();

		String[] str = season.split("@");
		int crop_year = Integer.parseInt(str[1]);
		String crop_Season = str[0];

		
		int dcode = (int) httpSession.getAttribute("dcode");
		int mcode = (int) httpSession.getAttribute("mcode");
		Object wbevname = httpSession.getAttribute("mcode");

		Integer wbdcode = Integer.parseInt((String) httpSession.getAttribute("wbdcode"));
		int wbmcode = (int) httpSession.getAttribute("wbmcode");

		nonWebLandData.setCr_vcode(villageCode);

		List<WbMaster> village = wbMasterService.findWebVcodeAndVname(dcode, mcode);
		model.addAttribute("village", village);

		System.out.println("village" + village);
		nonWebLandData.setBookingId(nonWebLandData.getBookingId());
		nonWebLandData.setCr_dist_code(wbdcode);
		nonWebLandData.setCr_mand_code(wbmcode);
		nonWebLandData.setOccupname(nonWebLandData.getOccupname());

		nonWebLandData.setOccupfname(nonWebLandData.getOccupfname());

		// nonWebLandData.setOc_name(nonWebLandData.getOc_name());
		String oc_name = nonWebLandData.getOc_name();
		String oc_fname = nonWebLandData.getOc_fname();
		String occupname = nonWebLandData.getOccupname();
		String occupfname = nonWebLandData.getOccupfname();
		int tot_extent = nonWebLandData.getTot_extent();

		nonWebLandData.setOc_fname(nonWebLandData.getOc_fname());
		String part_key = "";
		if (wbdcode <= 9) {
			part_key = crop_Season + "0" + wbdcode + crop_year;

		} else {
			part_key = crop_Season + wbdcode + crop_year;
		}
		nonWebLandData.setPart_key(part_key);

		// nonWebLandDataEntryService.saveNonWebLandData(nonWebLandData);

		pattMst_NonWebland.setCr_dist_code(wbdcode);
		pattMst_NonWebland.setCr_mand_code(wbmcode);
		pattMst_NonWebland.setCr_season(crop_Season);
		pattMst_NonWebland.setCr_year(crop_year);
		String aadhar=aadharNo.replace(" ", "");
		//String aadharNumber=aadhar.trim();
		String trimmedAadhar = aadhar.substring(0, Math.min(aadhar.length(), 12)); 
		System.out.println("aadhar.length()"+(aadhar.length()));
		
		
		
		pattMst_NonWebland.setCr_farmeruid(trimmedAadhar);
		nonWebLandData.setCr_farmeruid(trimmedAadhar);

		pattMst_NonWebland.setCr_vcode(villageCode);

		pattMst_NonWebland.setCr_sno(cr_sno);
		pattMst_NonWebland.setKh_no(kh_no);
		pattMst_NonWebland.setPart_key(part_key);

		// patt_Mst_NonWebLandRepo.save(pattMst_NonWebland);
		String dynamictable = "ecrop2023" + "." + "cr_booking_nwb";
		String dynamictable2 = "ecrop2023" + "." + "pattmast_nonwebland";


		nonWebLandData.setCr_season(crop_Season);

		String crSno = nonWebLandData.getCr_sno();
		int cr_dist_code = nonWebLandData.getCr_dist_code();
		int cr_mand_code = nonWebLandData.getCr_mand_code();
		int cr_vcode = nonWebLandData.getCr_vcode();
		int cr_year = nonWebLandData.getCr_year();
		String cr_season = nonWebLandData.getCr_season();
		String cr_farmeruid = nonWebLandData.getCr_farmeruid();
		try {

		dynamicTableService.insertIntoDynamicTable(dynamictable, crSno, part_key, cr_dist_code, cr_mand_code, cr_vcode,
				cr_year, cr_season, cr_farmeruid, kh_no, oc_name, oc_fname, occupname, occupfname, tot_extent);
		dynamicTableService.insertIntoDynamicTable(dynamictable2, crSno, part_key, cr_dist_code, cr_mand_code, cr_vcode,
				cr_year, cr_season, cr_farmeruid, kh_no, oc_name, oc_fname, occupname, occupfname, tot_extent);
		
		System.out.println("data inserted");
		return "data added successfully";
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("data is not inserted");
			return "Duplicate data will not be inserted";
		}

	}

}
