package com.bloodbank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bloodbank.model.BloodDetailsModel;
import com.bloodbank.model.Donor;

public class BloodDetailsDao {
	
	
	
	public int insertBloodDetails(BloodDetailsModel details) {
		int tempNumber=0;
		ConnectionUtil connection=new ConnectionUtil();
		try {
			Connection con=connection.getConnection();
			
		
			
			
			String query="insert into blood_details(blood_type,adharcard,unit,price) values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, details.getBloodType());
			pstmt.setLong(2, details.getDonor().getAdharcard());
			pstmt.setInt(3, details.getUnit());
			pstmt.setInt(4, details.getPrice());
			tempNumber=pstmt.executeUpdate();
			
			
			
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
