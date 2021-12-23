package com.bloodbank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

public class BookingDao {
	
	
	public int  booking(BookingModel book) {
		int tempNumber=0;
//		`book.getDonor().
//		
//		DonorDao donorDao=new DonorDao();
//		
//		Long adharcard=donorDao.adharcardNumber(book.getDonor());
//		
//		Donor donor=donorDao.validAdharcardNumber(adharcard);
		
		//System.out.println(donor.getAge());
		
		ConnectionUtil connection=new ConnectionUtil();
		String query="insert into booking (adharcard,address,book_date,blood_type,blood_collect_choice) values(?,?,?,?,?)";
		try {
			Connection con=connection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(query);
			
			
			pstmt.setLong(1,book.getDonor().getAdharcard());
			pstmt.setString(2, book.getAddress());
			pstmt.setDate(3, new java.sql.Date(book.getAppdate().getTime()));
			pstmt.setString(4, book.getBloodType());
			pstmt.setString(5, book.getBloodCollectChoice());
			
	     //fg System.out.println("DONE...!!!");
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
		pstmt.setLong(3,book.getDonor().getAdharcard());
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
 public int deleteBooking(Long adharcard) {
	 ConnectionUtil connection=new ConnectionUtil();
	 int tempNumber=0;
			 try {
				Connection con=connection.getConnection();
				
				String query="delete from booking where adharcard=?";
				PreparedStatement pstmt=con.prepareStatement(query);
				
				pstmt.setLong(1, adharcard);
				
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
 
 public List<BookingModel> HomeCollection(){
	 BookingModel model=null;
	 ConnectionUtil connection =new ConnectionUtil();
	 try {
		Connection con=connection.getConnection();
		String query="select * from booking where BLOOD_COLLECT_CHOICE =?";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
			
			//model=new BookingModel(rs.getObject(2), rs.getString(3),rs.getDate(4), rs.getString(5), rs.getString(6));
			
			
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 return null;
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 }
 
}
