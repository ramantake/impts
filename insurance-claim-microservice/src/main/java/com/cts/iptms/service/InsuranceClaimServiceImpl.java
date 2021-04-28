package com.cts.iptms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.iptms.exception.InsurerDetailNotFoundException;
import com.cts.iptms.exception.PatientDetailNotFoundException;
import com.cts.iptms.model.InitiateClaim;
import com.cts.iptms.model.InsurerDetail;
import com.cts.iptms.repository.InitiateClaimRepository;
import com.cts.iptms.repository.InsurerDetailRepository;

@Service
public class InsuranceClaimServiceImpl implements InsuranceClaimService {

	private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceClaimServiceImpl.class);

	@Autowired
	InsurerDetailRepository insurerDetailRepository;

	@Autowired
	InitiateClaimRepository initiateClaimRepository;

	@Override
	public List<InsurerDetail> getAllInsurerDetail() {
		LOGGER.debug("start");
		List<InsurerDetail> insurerDetailList;
		try {
			insurerDetailList = insurerDetailRepository.findAll();
		} catch (Exception e) {
			throw new InsurerDetailNotFoundException();
		}
		LOGGER.debug("end");
		return insurerDetailList;
	}

	@Override
	public InsurerDetail getInsurerDetail(long packageId) {
		LOGGER.debug("start");	 
		InsurerDetail insurerDetail = insurerDetailRepository.findById(packageId).orElseThrow(
				() -> new InsurerDetailNotFoundException("insurer details not found with id :" + packageId));
		LOGGER.debug("end");
		return insurerDetail;
	}

	 @Override
	    public int initiateClaim(InitiateClaim initiateClaim) {
	        LOGGER.debug("start");
	        int cost = initiateClaim.getTreatmentEndDateCost() - initiateClaim.getInsuranceAmountLimit();
	        if(cost<0) {
	            cost=0;
	        }
	        initiateClaim.setFinalCost(cost);
	        LOGGER.debug("end");
	        return cost;
	    } 
	 
		@Override
		public InitiateClaim getPatientFinalInfo(long id) {
			LOGGER.debug("start");
			InitiateClaim patientFinalInfo =initiateClaimRepository.findById(id).orElseThrow(() -> new PatientDetailNotFoundException());
			LOGGER.debug("end");
			return patientFinalInfo;
		}
}
