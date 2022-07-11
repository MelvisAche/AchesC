package com.melvis.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.melvis.models.Patient;
import com.melvis.models.Doctor;
import com.melvis.utils.ConnectionUtil;
//DAO Data Access Object


public class DoctorDAO implements DoctorDAOInterface{

	@Override
	public void insertDoctor(Doctor doctor, int pat_id) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "insert into doctor(doc_name, doc_field, doc_yoe, pat_id_fk) values (?,?,?,?);";
			//Instantiate a prepared statement to fill in the variable of our sql
			PreparedStatement ps = conn.prepareStatement(sql);
			//Fill in the values of our variables using ps.
			
			ps.setString(1, doctor.getDoc_name());
			ps.setString(2, doctor.getDoc_field());
			ps.setString(3, doctor.getDoc_yoe());
			ps.setInt(4, pat_id);
			
			
			ps.executeUpdate();//this sends our sql off to the database
			
			System.out.println("Doctor " + doctor.getDoc_name() + " was completed successfully...");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Insert Doctor failed");
			e.printStackTrace();
		}
	}
	
	//This method gets all employees from the DB
    
	public ArrayList<Doctor> getDoctor() {
 
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from doctor;";
			//no variables do we don't need a preparedStatement
			//What we use is
			Statement s = conn.createStatement();
			//import statement from java.sql
			//remember to execute 
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<Doctor> doctorList = new ArrayList();
			// us rs.next()in a while loop to create diagnosis object and populate our ArrayList
			
			while(rs.next()) {
				Doctor doc = new Doctor(
						rs.getInt("doc_id"),
						rs.getString("doc_name"),
						rs.getString("doc_field"),
						rs.getString("doc_yoe"),
						null
						);
				
				int patFK = rs.getInt("pat_id_fk");
				PatientDAO pDAO = new PatientDAO();
				
				
				Patient p = pDAO.getPatientById(patFK);
				
				//use setter from our diagnosis class to set the object from our Diagnosis db
				doc.setPat(p);
				//thanks to the set we have fully initialize the diagnosis object
				doctorList.add(doc);//for every diagnosis returned we put it in the Arraylist
				
			}
			return doctorList;//once the while loop breaks 
			
		}catch(SQLException e) {
			System.out.println("Something went wrong getting doctor");
			e.printStackTrace();
		}
		return null;
	}

	public Doctor getDoctorById(int docFK) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Doctor> getdoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	

	}
