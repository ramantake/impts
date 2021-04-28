package com.cognizant.iptreatmentofferings.exception;

public class PackageDetailNotFoundException  extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PackageDetailNotFoundException(String packageName) {
		super("No package details available with the name-"+packageName);
	}
}
