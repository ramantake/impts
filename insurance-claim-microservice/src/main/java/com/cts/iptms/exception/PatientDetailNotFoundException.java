package com.cts.iptms.exception;

public class PatientDetailNotFoundException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientDetailNotFoundException() {
		super("you are trying to find a non existing Patient");
	}

	
	
}
