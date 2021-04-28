package com.cts.iptms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;



import com.cts.iptms.client.ICClient;
import com.cts.iptms.client.IPTFClient;
import com.cts.iptms.client.IPTOFClient;
import com.cts.iptms.client.JwtTokenClient;
import com.cts.iptms.model.IPTreatmentPackage;
import com.cts.iptms.model.InitiateClaim;
import com.cts.iptms.model.InsurerDetail;
import com.cts.iptms.model.JwtResponse;
import com.cts.iptms.model.LoginRequest;
import com.cts.iptms.model.LoginResponse;
import com.cts.iptms.model.PatientDetail;
import com.cts.iptms.model.SpecialistDetail;
import com.cts.iptms.model.TreatmentPlan;
import com.cts.iptms.model.User;

import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j
@SessionAttributes("user")
public class WebPortalController {
		
	@Autowired
	IPTFClient iPTFClient;
	
	@Autowired
	IPTOFClient iPTFOClient;
	
	@Autowired
	ICClient iCClient;
	
	@Autowired
	private RestTemplate restTemplate;
	

	@Autowired
	private JwtTokenClient jwtClient;

	public JwtResponse getJwtResponse(User user) {
		return jwtClient.getJwt(user);
	}

	
	private static final Logger LOGGER = LoggerFactory.getLogger(WebPortalController.class);

	@GetMapping(value = "/adminDashboard")
	public ModelAndView getDashboard(HttpServletRequest request) {
	
		return new ModelAndView("adminDashboard");
		}
	
	
	
	
	public JwtResponse jwtResponse = new JwtResponse();
    String invalid;
	String jwtToken = "sample";

	String token = "Bearer " + jwtToken;

	@GetMapping("/login")
	public String loginFormm(Model theModel) {
		User user = new User();
		theModel.addAttribute("user", user);
		theModel.addAttribute("invalid", invalid);
		return "login";
	}

	@PostMapping("/loginValidate")
	public String getUser(@ModelAttribute("user") User user, Model model) {
		try {
			jwtResponse = getJwtResponse(user);
			invalid = null;
			model.addAttribute("username", user.getUsername());
			model.addAttribute("user", user);
			return "adminDashboard";
		} catch (Exception e) {
			invalid = "invalid credentials";
			model.addAttribute("invalid", invalid);
			return "redirect:login";
		}
	}
	
	@PostMapping(value = "/register")
	public ModelAndView getRegister(@RequestParam("pId") String id, @RequestParam("cost") int cost,
	@RequestParam("pName") String pack, @RequestParam("aName") String ailment) {
	log.info("START :: Method :: getRegister() :: ");
	ModelAndView mAV = new ModelAndView("registration");
	mAV.addObject("pack", pack);
	mAV.addObject("ailment", ailment);
	mAV.addObject("cost", cost);
	return mAV;
	}
	
	@PostMapping(value = "/registerSubmit")
	public ModelAndView registerPatient(@RequestParam("name") String name, @RequestParam("age") int age,
	@RequestParam("ailment") String ailment, @RequestParam("treatmentPackageName") String pkg,
	@RequestParam("cost") int cost, HttpServletRequest request) {
	PatientDetail patient = new PatientDetail(0, name, age, ailment, pkg, null);
	
	if (patient.getTreatmentPackageName().equalsIgnoreCase("Package 1"))
	patient.setTreatmentPackageName("package1");
	else if (patient.getTreatmentPackageName().equalsIgnoreCase("Package 2"))
	patient.setTreatmentPackageName("package2");
	
	TreatmentPlan tp = iPTFClient.formulateTreatmentTimetable(patient, cost);
	ModelAndView mAV = new ModelAndView("treatplan");
	mAV.addObject("plan", tp);
	return mAV;
	}
	
	@RequestMapping(path = "/registerPatient")
	public ModelAndView RegisterNewPatient(HttpServletRequest request) {	
			@SuppressWarnings("unchecked")
			List<IPTreatmentPackage> pckgresponse = (List<IPTreatmentPackage>)iPTFOClient.getIPTreatmentPackages().getBody();			
			ModelAndView modelandview = new ModelAndView("registerPatient");
			modelandview.addObject("plist", pckgresponse);
			return modelandview;
}
	
	@RequestMapping(path = "/ViewAllPackages")
	public ModelAndView getIPTreatmentPackages(HttpServletRequest request) {	
			@SuppressWarnings("unchecked")
			List<IPTreatmentPackage> pckgresponse = (List<IPTreatmentPackage>)iPTFOClient.getIPTreatmentPackages().getBody();			
			ModelAndView modelandview = new ModelAndView("ViewAllPackages");
			modelandview.addObject("plist", pckgresponse);
			return modelandview;
}
		

	@SuppressWarnings("unused")
	@GetMapping(value = "/viewAllInsurer")
	public ModelAndView claimInsurance( HttpServletRequest request) {
		LOGGER.debug("start");
		
	
	
			ModelAndView mAV = new ModelAndView("viewAllInsurer");
			List<InsurerDetail> insurers = iCClient.getAllInsurerDetail();
			mAV.addObject("insurers", insurers);
			return mAV;
	
	}
	
	

	@GetMapping(value = "/claimInsurance")
	public ModelAndView claimInsurance(@RequestParam("id") int ptId, HttpServletRequest request) {
		@SuppressWarnings("unused")
			ModelAndView mAV = new ModelAndView("claim");
			List<InsurerDetail> insurers = iCClient.getAllInsurerDetail();
			mAV.addObject("ptId", ptId);
			mAV.addObject("insurers", insurers);
			return mAV;
	}
	
	@PostMapping(value="/initiateClaim")
	public ModelAndView initiateClaim(@RequestParam long ptId, @RequestParam int insId ,HttpServletRequest request) {
		LOGGER.debug("start");	
			InsurerDetail ins = iCClient.getInsurerDetail(token,insId);
			PatientDetail pt = iPTFClient.getPatient(ptId);
			TreatmentPlan tp =  iPTFClient.getAPlan(ptId);
			InitiateClaim ic = new InitiateClaim(1, pt.getName(), pt.getAilment(), tp.getPackageName(), ins.getInsurerName(),  ins.getInsuranceAmountLimit(), tp.getCost());
			int amt = iCClient.initiateClaim(token,ic);
			iPTFClient.updatePlan(ptId);
			ModelAndView mAV = new ModelAndView("final");
			mAV.addObject("Outstanding", amt);
			mAV.addObject("InsurAmt",ins.getInsuranceAmountLimit());
			mAV.addObject("total", tp.getCost() );
			LOGGER.debug("End");
			return  mAV;
			
	}
	
	@GetMapping(value = "/getOnGoingTreatmentPlanList")
	public ModelAndView getTreatmentPlans(HttpServletRequest request) {	
			List<TreatmentPlan> treatmentPlan = iPTFClient.getOnGoingTreatmentPlanList();
			ModelAndView mAV = new ModelAndView("onGoing");	
			mAV.addObject("plan", treatmentPlan);
			return mAV;
		}
	
	
	
	@GetMapping(value = "/patients")
	public ModelAndView getPatients(HttpServletRequest request) {
		
			List<TreatmentPlan> tlist = iPTFClient.getAllPatients();
			ModelAndView mAV = new ModelAndView("patients");
			mAV.addObject("tlist", tlist);
			return mAV;
	}
	

	@RequestMapping(value = "/specialist")
	public ModelAndView getSpecialist(HttpServletRequest request) {
			@SuppressWarnings("unchecked")
			List<SpecialistDetail> specialists = (List<SpecialistDetail>)iPTFOClient.getSpecialistDetail().getBody();
			ModelAndView mAV = new ModelAndView("Specialist");
			mAV.addObject("specialist", specialists);
			return mAV;
	}
	
	/*@GetMapping(value = "/login")
	public String login() {
		return "login";
	}*/

	
	@GetMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/");	}
	/*
	@PostMapping(value = "/login")
	public String successfulLogin(@RequestParam String username, @RequestParam String password, HttpSession session, ModelMap model) {
		LoginRequest request = new LoginRequest();
		request.setUsername(username);
		request.setPassword(password);
		
		try {
			
			ResponseEntity<LoginResponse> response = restTemplate.postForEntity(
					"http://localhost:9090/authentication-service/authenticate", request, LoginResponse.class);
			LoginResponse loginResponse = response.getBody();
			String token = loginResponse.getToken();
			User user = loginResponse.getUser();
			int userId = user.getId().intValue();

			session.setAttribute("userId", userId);
			session.setAttribute("token", token);
			return "adminDashboard";
			
		}
		catch (Exception e) {
			model.put("error", "Invalid Credentials");
			return "login";
		}



	}*/
	
}
