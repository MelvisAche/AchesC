package com.melvis.controllers;


	import javax.servlet.http.HttpSession;

	import com.google.gson.Gson;
	import com.melvis.models.LoginDTO;
	import com.melvis.services.AuthServices;

	import io.javalin.http.Handler;

	public class AuthController {
		AuthServices as = new AuthServices();
		
		public static HttpSession ses;
		
		public Handler loginHandler= (ctx)->{
			String body = ctx.body();
			Gson gson = new Gson();
			LoginDTO ldto = gson.fromJson(body, LoginDTO.class);
			String loginUsername = as.login(ldto.getUsername(), ldto.getPassword());
			if(loginUsername != null){
			
				ses = ctx.req.getSession();
				ctx.result("Welcome " + loginUsername);
				ctx.status(202);
				
			}else {ctx.status(401); //unauthorized
			       //ctx.result("You haven't logged in");
			}
			
			
		};


}
