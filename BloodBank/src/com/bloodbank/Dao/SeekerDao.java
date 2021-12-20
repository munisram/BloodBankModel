package com.bloodbank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bloodbank.model.SeekerDetails;

public class SeekerDao {
	int n=0;
	public int insertSeekerDetails( SeekerDetails details) {
		ConnectionUtil connection=new ConnectionUtil();
		String query="insert into seeker_details (first_name,last_name,address,phone_number,patient_id,hospital_name,blood_type,unit)"
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			Connection con=connection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, details.getFirstName());
			pstmt.setString(2, details.getLastName());
			pstmt.setString(3, details.getAddress());
			pstmt.setLong(4, details.getPhoneNumber());
			pstmt.setLong(5, details.getPatientId());
			pstmt.setString(6, details.getHospitalName());
			pstmt.setString(7, details.getBloodType());
			pstmt.setInt(8, details.getUnit());
			n=pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

}
