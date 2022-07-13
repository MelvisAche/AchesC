package com.melvis.daos;

import java.util.ArrayList;

import com.melvis.models.Doctor;

public interface DoctorDAOInterface {

	boolean insertDoctor(Doctor doctor);
	ArrayList<Doctor>getdoctor();
	//boolean insertDoctor(Doctor doctor, int pat_id);

}
