package com.melvis.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.melvis.daos.DiagnosisDAO;
import com.melvis.models.Diagnosis;

import io.javalin.http.Handler;

public class DiagnosisController {
	
	DiagnosisDAO dDAO = new DiagnosisDAO();

	public Handler getDiagnosisHandler = (ctx) -> {
		ArrayList<Diagnosis> diag = dDAO.getDiagnosis();
		
		Gson gson = new Gson();
		String JSONdiagnosis = gson.toJson(diag);
		ctx.result(JSONdiagnosis);
		ctx.status(200);
	};

	public Handler insertDiagnosisHandler = (ctx) -> {
		//Post data is being posted to your backend which we access with ctx.body();
		//body?? it refers to the boody of the http request which were the incoming data is found
		String body = ctx.body();
		//create a new Gson object to make Json java conversion
		Gson gson = new Gson();
		//turn the incoming Json string directly into an Diagnosis object
		Diagnosis newDiag = gson.fromJson(body, Diagnosis.class);
		
		//If it succeeds, it'll call return true since that's the return type of insertDiagnosis
		if(dDAO.insertDiagnosis(newDiag)) {
			ctx.status(202); //202 stands for acception
		
		}else {ctx.status(406); //406 means wasn't accepted
		}
		
	
	};
	
	public Handler deleteDiagnosisHandler = (ctx) ->{
		
		int id = Integer.parseInt(ctx.pathParam("diag_id")); //to delete from the db
		
		if(dDAO.deleteDiagnosisId(id)) {
			ctx.status(202);
			
		}else {
			ctx.status(406);
		}
	};
	
	public Handler updateDiagnosisHandler = (ctx) ->{
		
		String results = ctx.body(); //path param gives us the value the user sends in
		String prescription = ctx.pathParam("prescription"); //parseInt converts ctx.body to integer
		
		if(dDAO.updateDiagnosisResults(results, prescription)) {
			ctx.status(202);
			
		}else {
			ctx.status(406);
		}
	};
	

}
