package com.cognizant.iptreatmentofferings.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageDetail {

	
	private String treatmentPackageName;
	private String testDetails;
	private int cost;
	private int treatmentDurationInWeeks;
}
