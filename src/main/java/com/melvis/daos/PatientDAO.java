package com.melvis.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.melvis.models.Patient;
import com.melvis.utils.ConnectionUtil;
//This patientdao is responsible for communicating with the roles in the database
//Every DB table should have a dao class associated with it for organization
//We could just have one huge dao class with methods for every table, but that will be a long scroll
public class PatientDAO implements PatientDAOInterface{

	@Override
	public Patient getPatientById(int id) {
	try (Connection conn = ConnectionUtil.getConnection()){
		String sql = "select * from patient where pat_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery(); //execute the query into our new resultset
		while(rs.next()) {
			Patient pat = new Patient(
					rs.getInt("pat_id"),
					rs.getString("pat_name"),
					rs.getString("pat_address"),
					rs.getString("pat_number"),
					rs.getString("pat_dob"),
					rs.getString("pat_gender")
					);
			return pat;
		}
		
	}catch(SQLException e)	{
		System.out.println("Get Patient failed");
		e.printStackTrace();
	}
	return null;
	}


	@Override
	public void updatePatientName(int pat_id, String Pat_name) {
		// TODO Auto-generated method stub
		
	}

}