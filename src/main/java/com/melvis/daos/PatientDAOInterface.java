package com.melvis.daos;

import com.melvis.models.Patient;

public interface PatientDAOInterface {

	Patient getPatientById(int id);

	void updatePatientName(int pat_id, String Pat_name);

}
