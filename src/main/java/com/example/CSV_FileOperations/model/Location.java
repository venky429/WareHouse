package com.example.CSV_FileOperations.model;

public enum Location {
	ITEM009("A"), PROD001("B"), SKU006("C"), SKU008("D"), NEXT1("Z"), NEXT12("Y"), NEXT3("X"), DEFAULT("AA");

	private final String locationName;

	Location(String locationName) {
		this.locationName = locationName;
	}

	public String getlocationName() {
		return locationName;
	}
}