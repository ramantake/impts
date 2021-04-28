package com.cts.iptms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecialistDetail {
	private long id;
	private String name;
	private String areaOfExpertise;
	private int experienceInYear;
	private String contactNumber;
}
