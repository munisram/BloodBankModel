package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bloodbank.Dao.BloodStackDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.BloodStack;
import com.bloodbank.model.RequestModel;

public class BloodStackDAOlmpl implements BloodStackDAO {

	public int updateStack(BloodStack stack) {
		ConnectionUtil connection = new ConnectionUtil();
		int n = 0;
		try {
			Connection con = connection.getConnection();

			int quantity = checkOfQuantity(stack.getBloodType().toLowerCase());

			// System.out.println(stack.getBloodType()+""+quantity);

			String query = "update blood_stack set quantity=? where blood_type=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			String commit = "commit";
			pstmt.setInt(1, quantity + stack.getQuantity());
			pstmt.setString(2, stack.getBloodType());
			n = pstmt.executeUpdate();
			pstmt.executeQuery(commit);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return n;
	}

	public List<BloodStack> showStack() {
		ConnectionUtil connection = new ConnectionUtil();
		BloodStack stack1 = null;
		List<BloodStack> stockDetails = new ArrayList<BloodStack>();
		try {
			Connection con = connection.getConnection();
			String query = "select BLOOD_TYPE,QUANTITY,UNIT_PRICE from blood_stack";
			PreparedStatement pstmt = con.prepareStatement(query);
			// pstmt.setString(1, stack.getBloodType());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				stack1 = new BloodStack(rs.getInt(2), rs.getString(1), rs.getInt(3));
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
		ConnectionUtil connection = new ConnectionUtil();
		int n = 0;
		try {

			Connection con = connection.getConnection();
			String query = "select QUANTITY from  blood_stack where blood_type=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, bloodtype);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				n = rs.getInt(1);

			}

			System.out.println(n);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(n+"QUANTITY"+bloodtype);
		return n;
	}

	public int updateStackReduce(String bloodType, int unit) {
		ConnectionUtil connection = new ConnectionUtil();
		int n = 0;
		try {
			Connection con = connection.getConnection();

			String query = "update blood_stack set quantity=? where blood_type=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			String commit = "commit";
			int totalUnit = checkOfQuantity(bloodType) - unit;
			pstmt.setInt(1, totalUnit);
			pstmt.setString(2, bloodType);
			n = pstmt.executeUpdate();
			pstmt.executeQuery(commit);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return n;
	}

	public double findPrice(String bloodType) {
		double n = 0;
		ConnectionUtil connectin = new ConnectionUtil();
		try {
			Connection con = connectin.getConnection();
			String query = "select UNIT_PRICE from blood_stack where blood_type=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			//System.out.println(bloodType);
			pstmt.setString(1, bloodType);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				n = rs.getDouble(1);

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

//	public List<BloodStack> HomeCollection(){
//		
//		List<BloodStack>bloodList=new ArrayList<BloodStack>();
//		ConnectionUtil connection=new ConnectionUtil();
//		BloodStack stack=null;
//		String query="select donor_details.first_name,booking.address from donor_details inner join booking on donor_details.adharcard=booking.adharcard\r\n"
//				+ "where BLOOD_COLLECT_CHOICE='home'";
//		try {
//			Connection con=connection.getConnection();
//			
//			Statement stmt=con.createStatement();
//		ResultSet rs= stmt.executeQuery(query);
//		while(rs.next()) {
//			
//			
//			
//		}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//		return bloodList;
//		
//	}

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
