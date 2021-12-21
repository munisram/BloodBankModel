package com.bloodbank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public int seekerIdFind(SeekerDetails seeker) {
		ConnectionUtil connection=new ConnectionUtil();
		
		
		int n=0;
		try {
			Connection con=connection.getConnection();
			String query ="select * from seeker_details where first_name=? last_name=? ";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, seeker.getFirstName());
			pstmt.setString(2, seeker.getLastName());
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				n=rs.getInt(1);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}
	
	
	
	
	
	
	public SeekerDetails seekerObject(String bloodType, String hospital) {
		ConnectionUtil connection=new ConnectionUtil();
		
		SeekerDetails seeker=null;
		
		try {
			Connection con=connection.getConnection();
			String query ="select * from seeker_details where blood_type=? hospital_name=? ";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, bloodType);
			pstmt.setString(2, hospital);
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				seeker=new SeekerDetails(rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getLong(5),rs.getLong(6),rs.getString(7),rs.getString(8),rs.getInt(9));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return seeker;
	
	}
}
