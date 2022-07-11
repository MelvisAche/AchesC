package com.melvis;

import java.sql.Connection;
import java.sql.SQLException;

import com.melvis.controllers.DoctorControllers;

import com.melvis.daos.PatientDAO;
import com.melvis.daos.DiagnosisDAO;
import com.melvis.daos.DoctorDAO;
import com.melvis.models.Patient;
import com.melvis.models.Doctor;
import com.melvis.models.Diagnosis;
import com.melvis.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {
public static void main(String[] args) {
	
//	 EmployeeDAO eDAO = new EmployeeDAO();
//	 RoleDAO rDAO = new RoleDAO();
	System.out.println("============ Welcome to a simple Hospital management system=====");
	//Try-with-resources block. It test whether our connection works
	//It works by trying to open a certain resource
	
	try(Connection conn = ConnectionUtil.getConnection()){
		System.out.println("Connection Successful");
	}catch(SQLException e) {
		System.out.println("Connection failed...");
		e.printStackTrace();
	}//end of connection test

	Javalin app = Javalin.create(
			config -> {
				config.enableCorsForAllOrigins();
			}
			).start(3000); //we need .start() to start our java server to port 5000
	
	DoctorControllers pc = new DoctorControllers();
	
	//app.get() is the javalin method that takes in GET requests.
	app.get("/doctor", pc.getDoctorHandler);
}
}

