package com.melvis.daos;

import java.util.ArrayList;

import com.melvis.models.Doctor;

public interface DoctorDAOInterface {

	void insertDoctor(Doctor doctor, int pat_id);
	ArrayList<Doctor>getdoctor();

}
