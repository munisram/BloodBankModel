package com.bloodbank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.Interface.Dao.RequestDAO;
import com.bloodbank.model.RequestModel;
import com.bloodbank.model.SeekerDetails;

public class RequestDAOlmpl  implements RequestDAO{

	
	public int insertRequest(RequestModel request) {
		int n=0;
		ConnectionUtil connection=new ConnectionUtil();
		String query ="insert into request_details (hospital_name,blood_type,unit,blood_collector_name,phone_number,aadharcard_number,request_date) values(?,?,?,?,?,?,?)";
				try {
					Connection con=connection.getConnection();
					
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1, request.getHospitalName());
				pstmt.setString(2, request.getBloodType());
				pstmt.setInt(3,request.getUnit());
				pstmt.setString(4, request.getBloodCollectorName());
				pstmt.setLong(5, request.getPhoneNumber());
				pstmt.setLong(6, request.getAdharcard());
				pstmt.setDate(7, new java.sql.Date( request.getRequestDate().getTime()));
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
	
	public int deleteRequest(Long aadharcard) {
		ConnectionUtil connection=new ConnectionUtil();
		int tempNumber=0;
		
		try {
			Connection con=connection.getConnection();
			String query="delete from request_details where aadharcard_number ='"+aadharcard+"'";
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
	
//	public int updateRequest(int unit,Long phoneNumber,Long Aadharcard,String bloodtype,Date date) {
//		int n=0;
//		ConnectionUtil connection=new ConnectionUtil();
//		try {
//			Connection con=connection.getConnection();
//			String query="update request_details set UNIT=?,PHONE_NUMBER=?,REQUEST_DATE =?,BLOOD_TYPE ? where AADHARCARD_NUMBER =? ";
//			
//			PreparedStatement pstmt=con.prepareStatement(query);
//			pstmt.setInt(1, unit);
//			pstmt.setLong(2, phoneNumber);
//			pstmt.setLong(3, Aadharcard);
//			pstmt.setDate(4,new java.sql.Date(date.getTime()) );
//			pstmt.setLong(5, Aadharcard);
//		n=	pstmt.executeUpdate();
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		return n;
//	}
	
	
	
	
	
}
