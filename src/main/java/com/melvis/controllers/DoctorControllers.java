package com.melvis.controllers;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.melvis.daos.DoctorDAO;
import com.melvis.models.Doctor;


import io.javalin.http.Handler;

public class DoctorControllers {

	DoctorDAO dDAO = new DoctorDAO();

	public Handler getDoctorHandler = (ctx) -> {
		ArrayList<Doctor> doctor = dDAO.getDoctor();
		
		Gson gson = new Gson();
		String JSONdoctor = gson.toJson(doctor);
		ctx.result(JSONdoctor);
		ctx.status(200);
	};

	public Handler insertDoctorHandler = (ctx) -> {
		//Post data is being posted to your backend which we access with ctx.body();
		//body?? it refers to the boody of the http request which were the incoming data is found
		String body = ctx.body();
		//create a new Gson object to make Json java conversion
		Gson gson = new Gson();
		//turn the incoming Json string directly into an Employee object
		Doctor newDoc = gson.fromJson(body, Doctor.class);
		
		//If it succeeds, it'll call return true since that's the return type of insertEmployee
		if(dDAO.insertDoctor(newDoc)) {
			ctx.status(202); //202 stands for acception
		
		}else {ctx.status(406); //406 means wasn't accepted
		}
		
	
	};
	
	public Handler deleteDoctorHandler = (ctx) ->{
		// A string to hold the role title which comes in to hold the path parameter
		int id = Integer.parseInt(ctx.pathParam("doc_id")); //to delete from the db
		
		if(dDAO.deleteDoctorId(id)) {
			ctx.status(202);
			
		}else {
			ctx.status(406);
		}
	};
	
	public Handler updateDoctorHandler = (ctx) ->{
		// A string to hold the role title which comes in to hold the path parameter
		int yoe = Integer.parseInt(ctx.body()); //parseInt converts ctx.body to integer 
		String field = ctx.pathParam("field");//path param gives us the value the user sends in
		
		if(dDAO.updateDoctorYoe(yoe, field)) {
			ctx.status(202);
			
		}else {
			ctx.status(406);
		}
	};
	
	
}
