package com.ecrops.controller;

import com.ecrops.entity.ActiveSeason;
import com.ecrops.model.EditCrBookingDtlsEntity;
import com.ecrops.model.EditCropBookingDetailsModel;
import com.ecrops.projection.ActiveSeasonProjection;
import com.ecrops.service.EditCrBookingDetailsService;
import com.ecrops.service.RepCultivatorDtlsService;
import com.ecrops.service.VillageSecService;
import com.ecrops.service.impl.ActiveSeasonServiceImpl;
import com.ecrops.util.ECropUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EditCropBookingDtlsController {

    ActiveSeasonServiceImpl activeSeasonService;
    EditCrBookingDetailsService editCrBookingDetailsService;
    VillageSecService villageSecService;

    public EditCropBookingDtlsController(ActiveSeasonServiceImpl activeSeasonService, EditCrBookingDetailsService editCrBookingDetailsService, VillageSecService villageSecService) {
        this.activeSeasonService = activeSeasonService;
        this.editCrBookingDetailsService = editCrBookingDetailsService;
        this.villageSecService = villageSecService;
    }

    @GetMapping("/editCropBookingDtls")
    public String loadEditCropBookingDtlsPage(Model model, HttpSession session) {
        List<ActiveSeason> cropYearActiveSeasonList = activeSeasonService.listAll();
        model.addAttribute("crYearList",cropYearActiveSeasonList);
        List<ActiveSeasonProjection> villageList = villageSecService.getVillageListByRbk(Integer.valueOf(ECropUtility.sessionData(session).getVsCode()));
        model.addAttribute("crVillageList", villageList);

        return "editCropBookingDtlsSearch";
    }

    @GetMapping("/editCropBookingDtls/details")
    public String getCultivatorDetailsByKathaNo(EditCropBookingDetailsModel ecbd, Model model) {
        List<EditCrBookingDtlsEntity> ecbdList = editCrBookingDetailsService.geEditCrBookingDetails(ecbd);
        model.addAttribute("editCrBookingDetailsList", ecbdList);
        return "editCrBookingDetails";
    }

}
