package com.cts.iptms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cts.iptms.model.PatientDetail;
import com.cts.iptms.model.TreatmentPlan;
import com.cts.iptms.service.IPTreatmentServiceImpl;


@RestController
public class TreatmentController {
	
	@Autowired
	IPTreatmentServiceImpl iptService;
	
	@PostMapping(value = "/formulatetreatmenttimetable/{cost}")
	public TreatmentPlan formulateTreatmentTimetable(@RequestBody PatientDetail patientDetail, @PathVariable int cost) {
	return iptService.getTreatmentPlan(patientDetail, cost);
}
	

	
	@GetMapping("/getAllPlans")
	public List<TreatmentPlan> getAllPatients(){
		return iptService.getAllPlans();
	}
	
	@GetMapping("/getPatient/{ptId}")
	public PatientDetail getPatient(@PathVariable long ptId ){
		return iptService.getPatient(ptId);
	}
	
	@GetMapping("/getplan/{ptId}")
	public TreatmentPlan getAPlan(@PathVariable int ptId ){
		return iptService.getPlan(ptId);
	}
	
	@PutMapping("/updatePlan/{pId}")
	public void updatePlan(@PathVariable long pId) {
		iptService.updatePlan(pId);
	}
	
	@GetMapping("/getOnGoingTreatmentPlanList")
	public List<TreatmentPlan> getOnGoingTreatmentPlanList(){
		return iptService.getOnGoingTreatmentPlanList();		
	}
}
