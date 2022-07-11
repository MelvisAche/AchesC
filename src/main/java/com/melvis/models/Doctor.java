package com.melvis.models;

public class Doctor {
	private int id;
	private String doc_name;
	private String doc_field;
	private String doc_yoe;
	private Patient pat;
	
	public Doctor() {
		super();
	}
	
	public Doctor(String doc_name, String doc_field, String doc_yoe, Patient pat) {
		super();
		this.doc_name = doc_name;
		this.doc_field = doc_field;
		this.doc_yoe = doc_yoe;
		this.pat = pat;
	}
	
	public Doctor(int id, String doc_name, String doc_field, String doc_yoe, Patient pat) {
		super();
		this.id = id;
		this.doc_name = doc_name;
		this.doc_field = doc_field;
		this.doc_yoe = doc_yoe;
		this.pat = pat;
	}
	
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", doc_name=" + doc_name + ", doc_field=" + doc_field + ", doc_yoe=" + doc_yoe
				+ ", pat=" + pat + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public String getDoc_field() {
		return doc_field;
	}
	public void setDoc_field(String doc_field) {
		this.doc_field = doc_field;
	}
	public String getDoc_yoe() {
		return doc_yoe;
	}
	public void setDoc_yoe(String doc_yoe) {
		this.doc_yoe = doc_yoe;
	}
	public Patient getPat() {
		return pat;
	}
	public void setPat(Patient pat) {
		this.pat = pat;
	}
	

}
