package com.melvis.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.melvis.daos.PatientDAO;
import com.melvis.models.Patient;

import io.javalin.http.Handler;

public class PatientController {
	
	PatientDAO pDAO = new PatientDAO();
	
	public Handler getPatientHandler = (ctx) -> {
		ArrayList<Patient> pat = pDAO.getpatient();
		
		Gson gson = new Gson();
		String JSONpatient = gson.toJson(pat);
		ctx.result(JSONpatient);
		ctx.status(200);
	};
	
	public Handler updatePatientHandler = (ctx) ->{
		// A string to hold the patient name  which comes in to hold the path parameter
		String address = ctx.body();
		String name = ctx.pathParam("name"); //path param gives us the value the user sends in
		//parseInt converts ctx.body to integer
		
		if(pDAO.updatePatientAddress(address, name)) {
			ctx.status(202);
			
		}else {
			ctx.status(406);
		}
	};
	
	public Handler deletePatientHandler = (ctx) ->{
		// A string to hold the role title which comes in to hold the path parameter
		int id = Integer.parseInt(ctx.pathParam("pat_id")); //to delete from the db
		
		if(pDAO.deletePatientId(id)) {
			ctx.status(202);
			
		}else {
			ctx.status(406);
		}
	};
	
	public Handler insertPatientHandler = (ctx) -> {
		//Post data is being posted to your backend which we access with ctx.body();
		//body?? it refers to the boody of the http request which were the incoming data is found
		String body = ctx.body();
		//create a new Gson object to make Json java conversion
		Gson gson = new Gson();
		//turn the incoming Json string directly into an Employee object
		Patient newPat = gson.fromJson(body, Patient.class);
		
		//If it succeeds, it'll call return true since that's the return type of insertEmployee
		if(pDAO.insertPatient(newPat)) {
			ctx.status(202); //202 stands for acception
		
		}else {ctx.status(406); //406 means wasn't accepted
		}
		
	
	};
	
}