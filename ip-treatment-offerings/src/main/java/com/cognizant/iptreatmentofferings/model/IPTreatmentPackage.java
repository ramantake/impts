package com.cognizant.iptreatmentofferings.model;

import javax.persistence.*;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="IPTREATMENTPACKAGE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IPTreatmentPackage {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String ailmentCategory;
	
	@Embedded
	PackageDetail packageDetail;
}