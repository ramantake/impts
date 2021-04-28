package com.cts.iptms.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "ip-treatment-offerings", url="http://localhost:9090/ip-treatment-offerings")
public interface IPTOFClient {
	@RequestMapping(path = "/IPTreatmentPackages", method = RequestMethod.GET)
	public ResponseEntity<?> getIPTreatmentPackages();

	@RequestMapping(path = "/IPTreatmentPackageByName/{category}/{packageName}", method = RequestMethod.GET)
	public ResponseEntity<?> getIPTreatmentPackageByAilmentCategoryAndName(@PathVariable String category,@PathVariable String packageName);
	
	@RequestMapping(path = "/specialists",method = RequestMethod.GET)
	public ResponseEntity<?> getSpecialistDetail();
}
