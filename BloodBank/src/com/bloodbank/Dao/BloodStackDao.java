package com.bloodbank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bloodbank.model.BloodStack;
import com.bloodbank.model.RequestModel;

public class BloodStackDao {
	
	
	public int updateStack(BloodStack stack) {
		ConnectionUtil connection=new ConnectionUtil();
		int n=0;
		try {
			Connection con=connection.getConnection();
			
			
			String query="update blood_stack set quantity=? where blood_type=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, stack.getQuantity()+1);
			pstmt.setString(2, stack.getBloodType());
			n=pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return n;
	}
	public List<BloodStack> showStack() {
		ConnectionUtil connection=new ConnectionUtil();
		BloodStack stack1=null;
		List<BloodStack> stockDetails=new ArrayList<BloodStack>();
		try {
			Connection con=connection.getConnection();
			String query="select * from blood_stack";
			PreparedStatement pstmt=con.prepareStatement(query);
			//pstmt.setString(1, stack.getBloodType());
			ResultSet rs =pstmt.executeQuery();
			
		while(rs.next()) {
						
			stack1=new BloodStack(rs.getInt(1), rs.getString(2));
			stockDetails.add(stack1);
			
		}
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stockDetails;
	}
	
	public int checkOfQuantity(String bloodtype) {
		ConnectionUtil connection=new ConnectionUtil();
		int n=0;
		try {
			Connection con=connection.getConnection();
			String query="select quantity from  blood_stack where blood_type=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1,bloodtype);
			ResultSet rs= pstmt.executeQuery();
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
	
	
	public int updateStackReduce(String bloodType,int unit) {
		ConnectionUtil connection=new ConnectionUtil();
		int n=0;
		try {
			Connection con=connection.getConnection();
			
			
			String query="update blood_stack set quantity=? where blood_type=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, checkOfQuantity(bloodType)-unit);
			pstmt.setString(2, bloodType);
			n=pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return n;
	}
	
	public int findPrice(String bloodType) {
		int n=0;
		ConnectionUtil connectin=new  ConnectionUtil();
		try {
			Connection con=connectin.getConnection();
			String query="select price from where blood_type=? ";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, bloodType);
		ResultSet rs =pstmt.executeQuery();
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//public BloodStack FindBlood(String type) {
//	
//	ConnectionUtil connection=new ConnectionUtil();
//	try {
//		Connection con=connection.getConnection();
//		String query="select * from blood_stack where blood_type=?";
//		PreparedStatement pstmt=con.prepareStatement(query);
//		pstmt.setString(1,type );
//		ResultSet rs=.executeQuery();
//		
//		
//	} catch (ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
	
	
	
	
	
	
//	return null;
//	
//}




}
