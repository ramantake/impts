package com.cts.iptms.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TreatmentPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne( fetch = FetchType.EAGER, targetEntity = PatientDetail.class)
	@JoinColumn(name = "tp_pt_id")
	private PatientDetail ptDetail;		
	private String testDetails;			
	private String packageName;			 
	private String specialist;	
	private double cost;
	private String status;
	private String treatmentCommencementDate;
	private String treatmentEndDate;

}
