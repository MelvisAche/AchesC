package com.melvis.models;

public class Diagnosis {
	private int diag_id;
	private Patient pat;
	private Doctor doc;
	private String pat_name;
	private String symptoms;
	private String diagnosis;
	private String results;
	private String prescription;
	
	public Diagnosis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diagnosis(int diag_id, Patient pat, Doctor doc, String pat_name, String symptoms, String diagnosis, String results,
			String prescription) {
		super();
		this.diag_id = diag_id;
		this.pat = pat;
		this.doc = doc;
		this.pat_name = pat_name;
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.results = results;
		this.prescription = prescription;
	}

	public Diagnosis(Patient pat, Doctor doc, String pat_name, String symptoms, String diagnosis, String results, String prescription) {
		super();
		this.pat = pat;
		this.doc = doc;
		this.pat_name = pat_name;
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.results = results;
		this.prescription = prescription;
	}

	@Override
	public String toString() {
		return "Diagnosis [diag_id=" + diag_id + ", pat=" + pat + ", doc=" + doc + ", pat_name=" + pat_name
				+ ", symptoms=" + symptoms + ", diagnosis=" + diagnosis + ", results=" + results + ", prescription="
				+ prescription + "]";
	}

	public int getDiag_id() {
		return diag_id;
	}

	public void setDiag_id(int diag_id) {
		this.diag_id = diag_id;
	}

	public Patient getPat() {
		return pat;
	}

	public void setPat(Patient pat) {
		this.pat = pat;
	}

	public Doctor getDoc() {
		return doc;
	}

	public void setDoc(Doctor doc) {
		this.doc = doc;
	}
	
	public String getPat_name() {
		return pat_name;
	}

	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	
}
