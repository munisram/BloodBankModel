package com.bloodbank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bloodbank.model.AdminModel;

public class AdminModelDao {
	
	public int verificationAdmin(AdminModel aModel) {
		int n=0;
		
		ConnectionUtil connection=new ConnectionUtil();
		try {
			Connection con=connection.getConnection();
			
			String query="select password from admin where email=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, aModel.getEmail());
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