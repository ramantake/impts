package com.cts.iptms.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.iptms.model.PatientDetail;
import com.cts.iptms.model.TreatmentPlan;

@FeignClient(name = "ip-treatment-microservice" ,url="http://localhost:9090/ip-treatment-microservice")
public interface IPTFClient {
	
	@RequestMapping(value = "/formulatetreatmenttimetable/{cost}", method = RequestMethod.POST)
	public TreatmentPlan formulateTreatmentTimetable(@RequestBody PatientDetail patientDetail,@PathVariable int cost);
	
	@GetMapping("/getPatient/{ptId}")
	public PatientDetail getPatient(@PathVariable long ptId);
	
	@GetMapping("/getAllPlans")
	public List<TreatmentPlan> getAllPatients();
	
	@GetMapping("/getplan/{ptId}")
	public TreatmentPlan getAPlan(@PathVariable long ptId);
	
	@PutMapping("/updatePlan/{pId}")
	public void updatePlan(@PathVariable long pId);
	
	@GetMapping("/getOnGoingTreatmentPlanList")
	public List<TreatmentPlan> getOnGoingTreatmentPlanList();
}
