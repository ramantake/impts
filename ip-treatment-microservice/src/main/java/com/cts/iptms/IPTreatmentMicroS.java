package com.cts.iptms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.cts.iptms.model.PatientDetail;
import com.cts.iptms.model.TreatmentPlan;
import com.cts.iptms.repository.PatientDetailRepository;
import com.cts.iptms.repository.TreatmentPlanRepository;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class IPTreatmentMicroS implements CommandLineRunner {

	
	@Autowired
	PatientDetailRepository patientdetailRepository;

	@Autowired
	TreatmentPlanRepository tPRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(IPTreatmentMicroS.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	PatientDetail patientDetail = new PatientDetail(1,"Shubham",22,"Urology","Package1","12/04/2021");
	patientdetailRepository.save(patientDetail);
	TreatmentPlan tp= new TreatmentPlan(1,patientDetail,"Urine Test, Blood Test",patientDetail.getTreatmentPackageName(),"Raman Take",4000,"Completed","12/04/2021","22/04/2021");
	tPRepo.save(tp);
PatientDetail patientDetail1 = new PatientDetail(2,"Shreyas",22,"Orthopedics","Package2","09/03/2021");
	patientdetailRepository.save(patientDetail1);
	TreatmentPlan tp1= new TreatmentPlan(2,patientDetail1,"Cystoscopy, VCUG-XRAY",patientDetail1.getTreatmentPackageName(),"Aniket Karanjkar",5000,"Completed","09/03/2021","01/04/2021");
	tPRepo.save(tp1);

	}

}
