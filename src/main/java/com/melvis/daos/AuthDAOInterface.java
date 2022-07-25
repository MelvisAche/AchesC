package com.melvis.daos;

import org.eclipse.jetty.server.Authentication.User;


public interface AuthDAOInterface {
	boolean insertUser(User user);

}
