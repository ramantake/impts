package com.cts.iptms.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.iptms.model.InitiateClaim;
import com.cts.iptms.model.InsurerDetail;

@FeignClient(name = "insurance-claim-microservice",url="http://localhost:9090/insurance-claim-microservice")
public interface ICClient {
	
	@RequestMapping(value = "/GetAllInsurerDetail", method = RequestMethod.GET )
	public List<InsurerDetail> getAllInsurerDetail();
	 
	@RequestMapping(value = "/GetInsurerByPackageName/{packageId}", method = RequestMethod.GET)
	public InsurerDetail getInsurerDetail(@RequestHeader(value = "Authorization", required = true) String authorizationHeader ,@PathVariable long packageId);	

	@RequestMapping(value = "/InitiateClaim", method = RequestMethod.POST)
	public int initiateClaim(@RequestHeader(value = "Authorization", required = true) String authorizationHeader,@RequestBody InitiateClaim initiateClaim);

	@RequestMapping(value = "/GetInsuredPatient/{patientId}", method = RequestMethod.GET)
	public InitiateClaim getInsurerdPatient(@RequestHeader(value = "Authorization", required = true) String authorizationHeader ,@PathVariable long patientId);
}
