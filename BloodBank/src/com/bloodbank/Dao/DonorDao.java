package com.bloodbank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bloodbank.model.Donor;

public class DonorDao {
	public void insertDonor(Donor donor) {
		ConnectionUtil connection =new ConnectionUtil();
		int tempNumber=0;
		try {
			
			Connection con=connection.getConnection();
			String query="insert into donor_details values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, donor.getFirstName());
			pstmt.setString(2, donor.getLastName());
			pstmt.setString(3, donor.getAddress());
			pstmt.setLong(4, donor.getAdharcard());
			pstmt.setLong(5, donor.getNumber());
			pstmt.setInt(6, donor.getAge());
			pstmt.setString(7, donor.getBloodType());
			tempNumber=pstmt.executeUpdate();
			if(tempNumber>0) {
				System.out.println("register completed");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public Donor validAdharcardNumber(Long adharcard) {
		Donor donor=null;
		ConnectionUtil connection=new ConnectionUtil();
				try {
					Connection con =connection.getConnection();
					String query="select * from donor_details where adharcard='"+adharcard+"'";
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(query);
					while(rs.next()) {
						donor=new Donor(rs.getString(1),rs.getString(2), rs.getString(3),rs.getLong(4),rs.getLong(5),rs.getInt(6), rs.getString(7));
					}
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return donor ;
	}
	public int updateDonor(Donor donor) {
		ConnectionUtil connection=new ConnectionUtil();
         int n=0;
		try {
			Connection con =connection.getConnection();
			String query="update donor_details set address=?,age=?,phone=? where adharcard=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1,donor.getAddress());
			pstmt.setInt(2, donor.getAge());
			pstmt.setLong(3, donor.getNumber());
			pstmt.setLong(4, donor.getAdharcard());
			n=pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n ;
	}
	public List<Donor> showDonor() {
		List<Donor> donorList=null;
		ConnectionUtil connection=new ConnectionUtil();
		donorList=new ArrayList<Donor>();
		try {
			Connection con =connection.getConnection();
			String query="select * from donor_details";
			
			PreparedStatement pstmt=con.prepareStatement(query);
			
			ResultSet rs=pstmt.executeQuery(query);
			while(rs.next()) {
			
			 Donor donor=new Donor(rs.getString(1),rs.getString(2), rs.getString(3),rs.getLong(4),rs.getLong(5),rs.getInt(6), rs.getString(7));
			 donorList.add(donor);
				//donorList=rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getLong(5),rs.getLong(6),rs.getInt(7), rs.getString(8);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	}
		return donorList;
	
	}
}
