package com.cts.iptms.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageDetail {

	
	private String treatmentPackageName;
	private String testDetails;
	private int cost;
	private int treatmentDurationInWeeks;
}
