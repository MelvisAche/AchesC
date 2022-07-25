package com.melvis.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.melvis.utils.ConnectionUtil;

public class AuthDAO {

	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from users where user_name = ? and password =?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			//if anything gets returned then user exist
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Login failed... Please try logging in again.");
			e.printStackTrace();
		}
		
		return false;
	}

}
