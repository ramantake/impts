package com.cts.iptms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.iptms.model.InitiateClaim;
import com.cts.iptms.model.InsurerDetail;
import com.cts.iptms.service.InsuranceClaimServiceImpl;



@RestController
public class InsuranceClaimController {

	@Autowired
	InsuranceClaimServiceImpl insuranceClaimServiceImpl;
	private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceClaimController.class);
	

	@GetMapping(value = "/GetAllInsurerDetail")
	public List<InsurerDetail> getAllInsurerDetail() {
		LOGGER.debug("start");
		List<InsurerDetail> insurerDetailList = insuranceClaimServiceImpl.getAllInsurerDetail();
		LOGGER.debug("end");
		return insurerDetailList;
	}

	@GetMapping(value = "/GetInsurerByPackageName/{packageId}")
	public InsurerDetail getInsurerDetail( @PathVariable long packageId) {
		LOGGER.debug("start");	
		InsurerDetail insurerDetail = insuranceClaimServiceImpl.getInsurerDetail(packageId);
		LOGGER.debug("end");
		return insurerDetail;
	}
	
	@PostMapping(value = "/InitiateClaim")
    public int initiateClaim( @RequestBody InitiateClaim initiateClaim) {
        LOGGER.debug("start");   
        int cost = insuranceClaimServiceImpl.initiateClaim(initiateClaim);
        LOGGER.debug("end");
        return cost;
    }

	@GetMapping(value = "/GetInsuredPatient/{patientId}")
	public InitiateClaim getInsurerdPatient(@PathVariable long patientId) {
		LOGGER.debug("start");
		InitiateClaim initiateClaim=insuranceClaimServiceImpl.getPatientFinalInfo(patientId);
		LOGGER.debug("end");
		return initiateClaim;
	}
}
