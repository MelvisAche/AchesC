package com.melvis.services;

import com.melvis.daos.AuthDAO;

public class AuthServices {
	AuthDAO aDAO = new AuthDAO();	
	public String login(String username, String Password) {
		if (aDAO.login(username, Password)) {
			return username;
		}
		return null;
	}
	}
