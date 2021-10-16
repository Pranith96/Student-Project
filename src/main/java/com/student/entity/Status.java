package com.student.entity;

public enum Status {

	ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

	private String description;

	Status(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
