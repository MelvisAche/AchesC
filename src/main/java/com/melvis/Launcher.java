package com.melvis;

import java.sql.Connection;
import java.sql.SQLException;

import com.melvis.controllers.DiagnosisController;
import com.melvis.controllers.DoctorControllers;
import com.melvis.controllers.PatientController;
import com.melvis.utils.ConnectionUtil;
import com.melvis.controllers.AuthController;
import com.melvis.daos.AuthDAO;

import io.javalin.Javalin;

public class Launcher {
public static void main(String[] args) {
	

	System.out.println("============ Welcome to a simple Hospital management system=====");
	//Testing connection
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
			).start(8080); //.start() starts our java server to port 8080
	
	DoctorControllers dc = new DoctorControllers();
	//app.get() is the javalin method that takes in GET requests.
	app.get("/doctor", dc.getDoctorHandler);
	app.post("/insertDoctor", dc.insertDoctorHandler);
	app.put("/doctor/:field", dc.updateDoctorHandler);//updating yoe where field equals
	app.delete("/doctor/:doc_id", dc.deleteDoctorHandler);
	
	
	PatientController pc = new PatientController();
	app.get("/patient", pc.getPatientHandler);
	app.post("/insertPatient", pc.insertPatientHandler);
	app.put("/patient/:name", pc.updatePatientHandler);//updating address where patient name equals
	app.delete("/patient/:pat_id", pc.deletePatientHandler);
	
	DiagnosisController dcn = new DiagnosisController();
	app.get("/diagnosis", dcn.getDiagnosisHandler);
	app.post("/insertDiagnosis", dcn.insertDiagnosisHandler);
	app.put("/diagnosis/:prescription", dcn.updateDiagnosisHandler);//updating results where prescription equals to
	app.delete("/diagnosis/:diag_id", dcn.deleteDiagnosisHandler);
	
	//Login
	AuthDAO aDAO = new AuthDAO();
	System.out.println(aDAO.login("Melvis", "2554") || aDAO.login("Khalifa", "password0028"));
	AuthController ac = new AuthController();
	app.post("/login", ac.loginHandler);
}
}

