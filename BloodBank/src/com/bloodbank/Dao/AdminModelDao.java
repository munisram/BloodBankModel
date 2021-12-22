package com.bloodbank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bloodbank.model.AdminModel;

public class AdminModelDao {
	
	public  AdminModel  verificationAdmin(AdminModel aModel) {
		AdminModel model=null;
		
		ConnectionUtil connection=new ConnectionUtil();
		try {
			Connection con=connection.getConnection();
			
			String query="select * from admin where email=? and password=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, aModel.getEmail());
			pstmt.setString(2, aModel.getPassword());
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				model=new AdminModel(rs.getString(2),rs.getString(3));
			}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		return model;
		}	
	
	


}
