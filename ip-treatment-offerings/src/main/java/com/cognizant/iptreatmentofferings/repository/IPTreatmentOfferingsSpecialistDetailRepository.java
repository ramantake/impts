package com.cognizant.iptreatmentofferings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.iptreatmentofferings.model.SpecialistDetail;


@Repository
public interface IPTreatmentOfferingsSpecialistDetailRepository extends JpaRepository<SpecialistDetail, Long>{

}
