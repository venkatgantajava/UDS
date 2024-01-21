package com.ecrops.controller;

import com.ecrops.entity.ActiveSeason;
import com.ecrops.entity.Cultivator;
import com.ecrops.entity.EditCrBookingDtlsEntity;
import com.ecrops.entity.WbMaster;
import com.ecrops.model.EditCropBookingDetailsModel;
import com.ecrops.projection.ActiveSeasonProjection;
import com.ecrops.service.RepCultivatorDtlsService;
import com.ecrops.service.VillageSecService;
import com.ecrops.service.WbMasterService;
import com.ecrops.service.impl.ActiveSeasonServiceImpl;
import com.ecrops.util.ECropUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EditCropBookingDtlsController {

    ActiveSeasonServiceImpl activeSeasonService;
    RepCultivatorDtlsService repCultivatorDtlsService;
    VillageSecService villageSecService;

    public EditCropBookingDtlsController(ActiveSeasonServiceImpl activeSeasonService, RepCultivatorDtlsService repCultivatorDtlsService, VillageSecService villageSecService) {
        this.activeSeasonService = activeSeasonService;
        this.repCultivatorDtlsService = repCultivatorDtlsService;
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
    public String getCultivatorDetailsByKathaNo(EditCropBookingDetailsModel ebd, Model model) {

        model.addAttribute("editCrBookingDetailsList", new ArrayList<EditCrBookingDtlsEntity>());
        return "editCrBookingDetails";
    }

}
