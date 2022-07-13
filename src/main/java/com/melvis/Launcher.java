package com.melvis;

import java.sql.Connection;
import java.sql.SQLException;

import com.melvis.controllers.DiagnosisController;
import com.melvis.controllers.DoctorControllers;
import com.melvis.controllers.PatientController;
import com.melvis.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {
public static void main(String[] args) {
	

	System.out.println("============ Welcome to a simple Hospital management system=====");
	//Try-with-resources block. It test whether our connection works
	//It works by trying to open a certain resource
	
	try(Connection conn = ConnectionUtil.getConnection()){
		System.out.println("Connection Successful...");
	}catch(SQLException e) {
		System.out.println("Connection failed...");
		e.printStackTrace();
	}//end of connection test

	Javalin app = Javalin.create(
			config -> {
				config.enableCorsForAllOrigins();
			}
			).start(8080); //we need .start() to start our java server to port 5000
	
	DoctorControllers dc = new DoctorControllers();
	//app.get() is the javalin method that takes in GET requests.
	app.get("/doctor", dc.getDoctorHandler);
	app.post("/insertDoctor", dc.insertDoctorHandler);
	app.put("/doctor/:field", dc.updateDoctorHandler);
	app.delete("/doctor/:doc_id", dc.deleteDoctorHandler);
	
	
	PatientController pc = new PatientController();
	app.get("/patient", pc.getPatientHandler);
	app.post("/insertPatient", pc.insertPatientHandler);
	app.put("/patient/:name", pc.updatePatientHandler);
	app.delete("/patient/:pat_id", pc.deletePatientHandler);
	
	DiagnosisController dcn = new DiagnosisController();
	app.get("/diagnosis", dcn.getDiagnosisHandler);
	app.post("/insertDiagnosis", dcn.insertDiagnosisHandler);
	app.put("/diagnosis/:prescription", dcn.updateDiagnosisHandler);
	app.delete("/diagnosis/:diag_id", dcn.deleteDiagnosisHandler);
}
}

