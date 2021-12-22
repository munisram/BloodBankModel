package com.bloodbank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.bloodbank.model.RequestModel;

public class RequestDao {

	
	public int insertRequest(RequestModel request) {
		int n=0;
		ConnectionUtil connection=new ConnectionUtil();
		String query ="insert into request_details (hospital_name,blood_type,unit,blood_collector_name,phone_number,adharcard_number) values(?,?,?,?,?,?)";
				try {
					Connection con=connection.getConnection();
					
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1, request.getHospitalName());
				pstmt.setString(2, request.getBloodType());
				pstmt.setInt(3,request.getUnit());
				pstmt.setString(4, request.getBloodCollectorName());
				pstmt.setLong(5, request.getPhoneNumber());
				pstmt.setLong(6, request.getAdharcard());
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
	
	public int deleteRequest(Long adharcard) {
		ConnectionUtil connection=new ConnectionUtil();
		int tempNumber=0;
		
		try {
			Connection con=connection.getConnection();
			String query="delete from booking where adharcard ='"+adharcard+"'";
			Statement stmt=con.createStatement();
			tempNumber=stmt.executeUpdate(query);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
		
		
		
		return tempNumber;
		
	}
	
	
	
	
	
	
	
}
