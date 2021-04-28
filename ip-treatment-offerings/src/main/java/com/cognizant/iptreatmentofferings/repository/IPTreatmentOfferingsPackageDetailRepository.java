package com.cognizant.iptreatmentofferings.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.iptreatmentofferings.model.IPTreatmentPackage;


@Repository
public interface IPTreatmentOfferingsPackageDetailRepository extends JpaRepository<IPTreatmentPackage, Long>{

	@Query(value="select p from IPTreatmentPackage p where p.packageDetail.treatmentPackageName=:packageName and p.ailmentCategory=:category")
	IPTreatmentPackage findByName(@Param("packageName") String packageName, @Param("category")String category);
}

