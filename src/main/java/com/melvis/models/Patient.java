package com.melvis.models;

public class Patient {
	private int pat_id;
	private String pat_name;
	private String pat_address;
	private String pat_number;
	private String dob;
	private String gender;
	
	public Patient() {
		super();	
	}

	@Override
	public String toString() {
		return "Patient [pat_id=" + pat_id + ", pat_name=" + pat_name + ", pat_address=" + pat_address + ", pat_number="
				+ pat_number + ", dob=" + dob + ", gender=" + gender + "]";
	}

	public Patient(int pat_id, String pat_name, String pat_address, String pat_number, String dob, String gender) {
		super();
		this.pat_id = pat_id;
		this.pat_name = pat_name;
		this.pat_address = pat_address;
		this.pat_number = pat_number;
		this.dob = dob;
		this.gender = gender;
	}
	
	public Patient(String pat_name, String pat_address, String pat_number, String dob, String gender) {
		super();
		this.pat_name = pat_name;
		this.pat_address = pat_address;
		this.pat_number = pat_number;
		this.dob = dob;
		this.gender = gender;
	}

	public int getPat_id() {
		return pat_id;
	}

	public void setPat_id(int pat_id) {
		this.pat_id = pat_id;
	}

	public String getPat_name() {
		return pat_name;
	}

	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}

	public String getPat_address() {
		return pat_address;
	}

	public void setPat_address(String pat_address) {
		this.pat_address = pat_address;
	}

	public String getPat_number() {
		return pat_number;
	}

	public void setPat_number(String pat_number) {
		this.pat_number = pat_number;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
