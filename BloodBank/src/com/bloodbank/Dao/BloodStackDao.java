package com.bloodbank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bloodbank.model.BloodStack;

public class BloodStackDao {
	
	
	public int insertStack(BloodStack stack) {
		ConnectionUtil connection=new ConnectionUtil();
		int n=0;
		try {
			Connection con=connection.getConnection();
			String query="insert into blood_stack (quantity,blood_type)values(?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, stack.getQuantity());
			pstmt.setString(2, stack.getBloodType());
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