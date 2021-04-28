package com.cts.iptms.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "initiate_claim")
public class InitiateClaim {
    @Id
    private long id;
    private String patientName;
    private String ailment;
    private String treatmentPackageName;
    private String insurerName;
    private int insuranceAmountLimit;
    private int treatmentEndDateCost;
    private int finalCost;
}
