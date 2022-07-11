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

	
}
