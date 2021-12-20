package com.bloodbank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

public class BookingDao {
	
	
	public int  booking(BookingModel book) {
		int tempNumber
		=0;
		ConnectionUtil connection=new ConnectionUtil();
		String query="insert into booking (adharcard,address,book_date,blood_type) values(?,?,?,?)";
		try {
			Connection con=connection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setLong(1,book.getAdharcard() );
			pstmt.setString(2, book.getAddress());
			pstmt.setDate(3, new java.sql.Date(book.getAppdate().getTime()));
			pstmt.setString(4, book.getBloodType());
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
 public int updateBooking(BookingModel book) {
	 int tempNumber=0;
	 ConnectionUtil connection=new ConnectionUtil();
	 try {
		Connection con =connection.getConnection();
		String query="update booking set address=?,book_date=? where adharcard=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1, book.getAddress());
		pstmt.setDate(2, new java.sql.Date (book.getAppdate().getTime()));
		pstmt.setLong(3, book.getAdharcard());
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
 public int deleteBooking(BookingModel book) {
	 ConnectionUtil connection=new ConnectionUtil();
	 int tempNumber=0;
			 try {
				Connection con=connection.getConnection();
				String query="delete from booking where adharcard ='"+book.getAdharcard()+"'";
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