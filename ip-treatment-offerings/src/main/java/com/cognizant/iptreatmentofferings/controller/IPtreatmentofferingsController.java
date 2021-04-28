package com.cognizant.iptreatmentofferings.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.iptreatmentofferings.model.IPTreatmentPackage;
import com.cognizant.iptreatmentofferings.model.SpecialistDetail;
import com.cognizant.iptreatmentofferings.service.IPtreatmentofferingsService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IPtreatmentofferingsController {
	@Autowired
	IPtreatmentofferingsService iptreatmentofferingsService;
	
	@ResponseBody
	@GetMapping(path = "/IPTreatmentPackages")
	public List<IPTreatmentPackage> getIPTreatmentPackages() {
		log.debug("Start : {}", "getIPTreatmentPackages");
		log.debug("END : {}", "getIPTreatmentPackages");
		return iptreatmentofferingsService.getIPTreatmentPackages() ;
	}
	@ResponseBody
	@GetMapping(path = "/IPTreatmentPackageByName/{category}/{packageName}")
	public IPTreatmentPackage getIPTreatmentPackageByAilmentCategoryAndName(@PathVariable String category,@PathVariable String packageName) {
		log.debug("Start : {}", "getIPTreatmentPackageByAilmentCategoryAndName");
		log.debug("End : {}", "getIPTreatmentPackageByAilmentCategoryAndName");
		return  iptreatmentofferingsService.getIPTreatmentPackageByAilmentCategoryAndName(packageName,category) ;
	}
	@ResponseBody
	@GetMapping(value = "/specialists")
	public List<SpecialistDetail> getSpecialists(){
		log.debug("Start : {}", "getSpecialists");
		log.debug("End : {}", "getSpecialists");
		return iptreatmentofferingsService.getSpecialists();
	}

}
