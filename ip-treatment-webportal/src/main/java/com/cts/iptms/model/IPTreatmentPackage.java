package com.cts.iptms.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class IPTreatmentPackage {
	private long id;
	private String ailmentCategory;
	PackageDetail packageDetail;
}