package com.melvis.daos;

import java.util.ArrayList;


import com.melvis.models.Patient;

public interface PatientDAOInterface {

	Patient getPatientById(int id);

	//boolean updatePatientName(int pat_id, String Pat_name);
	
	boolean insertPatient(Patient patient);
	ArrayList<Patient>getpatient();

}
