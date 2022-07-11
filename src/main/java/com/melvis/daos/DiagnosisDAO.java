package com.melvis.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.melvis.models.Diagnosis;
import com.melvis.models.Patient;
import com.melvis.models.Doctor;
import com.melvis.utils.ConnectionUtil;
//DAO Data Access Object


public class DiagnosisDAO implements DiagnosisDAOInterface{

	@Override
	public void insertDiagnosis(Diagnosis diagnosis, int pat_id, int doc_id) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()){
        String sql = "insert into diagnosis(pat_id_fk, doc_id_fk, pat_name, symptoms, diagnosis, results, prescription) values (?,?,?,?,?,?,);";
			//Instantiate a prepared statement to fill in the variable of our sql
			PreparedStatement ps = conn.prepareStatement(sql);
			//Fill in the values of our variables using ps.
			ps.setInt(1, pat_id);
			ps.setInt(2, doc_id);
			ps.setString(3, diagnosis.getPat_name());
			ps.setString(4, diagnosis.getSymptoms());
			ps.setString(5, diagnosis.getDiagnosis());
			ps.setString(6, diagnosis.getResults());
			ps.setString(7, diagnosis.getPrescription());
			
			ps.executeUpdate();//this sends our sql off to the database
			
			System.out.println("Patient " + diagnosis.getPat_name() + " diagnosis" + " was completed successfully...");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Insert Diagnosis failed");
			e.printStackTrace();
		}
	}
	
	//This method gets all employees from the DB
    
	public ArrayList<Diagnosis> getDiagnosis() {
 
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from diagnosis;";
			//no variables do we don't need a preparedStatement
			//What we use is
			Statement s = conn.createStatement();
			//import statement from java.sql
			//remember to execute 
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<Diagnosis> diagnosisList = new ArrayList();
			// us rs.next()in a while loop to create diagnosis object and populate our ArrayList
			
			while(rs.next()) {
				Diagnosis diag = new Diagnosis(
						rs.getInt("diag_id"),
						null,
						null,
						rs.getString("pat_name"),
						rs.getString("symptoms"),
						rs.getString("diagnosis"),
						rs.getString("results"),
						rs.getString("prescription")
						
						);
				//Use the patientdao method to get a patient by ID
				int patFK = rs.getInt("pat_id_fk");
				PatientDAO pDAO = new PatientDAO();
				
				//get a role object using the int that we populate
				Patient p = pDAO.getPatientById(patFK);
				
				//use setter from our diagnosis class to set the object from our Diagnosis db
				diag.setPat(p);
				//thanks to the set we have fully initialize the diagnosis object
				int docFK = rs.getInt("doc_id_fk");
				DoctorDAO dDAO = new DoctorDAO();
				
				//get a doctor object using the int that we populate
				Doctor doc = dDAO.getDoctorById(docFK);
				
				//use setter from our diagnosis class to set the object from our Diagnosis db
				diag.setDoc(doc);
				diagnosisList.add(diag);//for every diagnosis returned we put it in the Arraylist
				
			}
			return diagnosisList;//once the while loop breaks 
			
		}catch(SQLException e) {
			System.out.println("Something went wrong getting diagnosis");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Diagnosis> getdiagnosis() {
		// TODO Auto-generated method stub
		return null;
	}

	

	}
