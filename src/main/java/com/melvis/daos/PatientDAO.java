package com.melvis.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.melvis.models.Doctor;
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


//	@Override
//	public boolean updatePatientName(int pat_id, String Pat_name) {
//		return false;
//		// TODO Auto-generated method stub
//		
//	}


	public boolean updatePatientAddress(String address, String name) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "update patient set pat_address = ? where pat_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, address);
			ps.setString(2, name);
			ps.executeUpdate();
			System.out.println("Dear " + name + " your address has been updated to " + address);
			return true;
		}catch(SQLException e)	{
			System.out.println("Failed to update patient address");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deletePatientId(int id) {
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "delete from patient where pat_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println(id + " has been deleted successfully ");
			return true;
		}catch(SQLException e)	{
			System.out.println("Failed to delete");
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public boolean insertPatient(Patient patient) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "insert into patient(pat_name, pat_address, pat_number, pat_dob, pat_gender) values (?,?,?,?,?);";
			//Instantiate a prepared statement to fill in the variable of our sql
			PreparedStatement ps = conn.prepareStatement(sql);
			//Fill in the values of our variables using ps.
			
			ps.setString(1, patient.getPat_name());
			ps.setString(2, patient.getPat_address());
			ps.setString(3, patient.getPat_number());
			ps.setString(4, patient.getDob());
			ps.setString(5, patient.getGender());
			
			
			ps.executeUpdate();//this sends our sql off to the database
			
			System.out.println("Patient " + patient.getPat_name() + " was completed successfully...");
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Insert Patient failed");
			e.printStackTrace();
		return false;
		}
	}


	@Override
	public ArrayList<Patient> getpatient() {
			 
			try(Connection conn = ConnectionUtil.getConnection()){
				String sql = "select * from patient;";
				//no variables do we don't need a preparedStatement
				//What we use is
				Statement s = conn.createStatement();
				//import statement from java.sql
				//remember to execute 
				ResultSet rs = s.executeQuery(sql);
				
				ArrayList<Patient> patientList = new ArrayList<>();
				while(rs.next()) {
					Patient pat = new Patient(
							rs.getInt("pat_id"),
							rs.getString("pat_name"),
							rs.getString("pat_address"),
							rs.getString("pat_number"),
							rs.getString("pat_dob"),
							rs.getString("pat_gender")
							);
					patientList.add(pat);
				}
		return patientList;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Failed to get doctor please retry!!!");
		e.printStackTrace();
	}
			return null;
	}
}