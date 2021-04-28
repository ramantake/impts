package com.cts.iptms.model;






import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InitiateClaim {
	    private int id;
	    private String patientName;
	    private String ailment;
	    private String treatmentPackageName;
	    private String insurerName;
	    private int insuranceAmountLimit;
	    private int treatmentEndDateCost;
}

