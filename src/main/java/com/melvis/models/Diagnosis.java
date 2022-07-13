package com.melvis.models;

public class Diagnosis {
	private int diag_id;
	private Patient pat;
	private Doctor doc;
	private int pat_id_fk; //used for inserting only
	private int doc_id_fk;//used for inserting only
	
	private String symptoms;
	private String diagnosis;
	private String results;
	private String prescription;
	
	public Diagnosis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diagnosis(int diag_id, Patient pat, Doctor doc, 
			String symptoms, String diagnosis, String results, String prescription) {
		super();
		this.diag_id = diag_id;
		this.pat = pat;
		this.doc = doc;
		
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.results = results;
		this.prescription = prescription;
	}

	public Diagnosis(Patient pat, Doctor doc, String symptoms,
			String diagnosis, String results, String prescription) {
		super();
		this.pat = pat;
		this.doc = doc;
		
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.results = results;
		this.prescription = prescription;
	}
	
	

	public Diagnosis(int diag_id, Patient pat, Doctor doc, int pat_id_fk, int doc_id_fk,
			String symptoms, String diagnosis, String results, String prescription) {
		super();
		this.diag_id = diag_id;
		this.pat = pat;
		this.doc = doc;
		this.pat_id_fk = pat_id_fk;
		this.doc_id_fk = doc_id_fk;
		
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.results = results;
		this.prescription = prescription;
	}

	@Override
	public String toString() {
		return "Diagnosis [ pat_id_fk=" + pat_id_fk
				+ ", doc_id_fk=" + doc_id_fk + ", symptoms=" + symptoms + ", diagnosis="
				+ diagnosis + ", results=" + results + ", prescription=" + prescription + "]";
	}

	public int getPat_id_fk() {
		return pat_id_fk;
	}

	public void setPat_id_fk(int pat_id_fk) {
		this.pat_id_fk = pat_id_fk;
	}

	public int getDoc_id_fk() {
		return doc_id_fk;
	}

	public void setDoc_id_fk(int doc_id_fk) {
		this.doc_id_fk = doc_id_fk;
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
