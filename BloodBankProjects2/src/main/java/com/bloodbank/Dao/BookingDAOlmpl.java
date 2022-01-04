package com.bloodbank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Interface.Dao.BookingDAO;
import com.Interface.Dao.DonorDAO;
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

public class BookingDAOlmpl implements  BookingDAO {
	
	
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
		String query="update booking set address=?,book_date=?,blood_collect_choice=? where adharcard=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1, book.getAddress());
		pstmt.setDate(2, new java.sql.Date (book.getAppdate().getTime()));
		pstmt.setLong(4,book.getDonor().getAdharcard());
		pstmt.setString(3,book.getBloodCollectChoice());
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
	 List<BookingModel>booking=new ArrayList<BookingModel>();
	 try {
		
		Connection con=connection.getConnection();
		String query="select * from booking where BLOOD_COLLECT_CHOICE ='home'";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
			DonorDAOImpl donor=new DonorDAOImpl();
			
		    Donor donor1=donor.validAdharcardNumber(rs.getLong(2));
		    //System.out.println(donor1);
			model=new BookingModel(donor1,rs.getString(3),rs.getDate(4), rs.getString(5), rs.getString(6));
			
			booking.add(model);
			
		}
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 return booking;
	 
	  
	 
	 
 }
 
 
 public Date dateCheck(Donor donor) {
	 Date date=null;
	 ConnectionUtil connection=new ConnectionUtil();
	 try {
		Connection con=connection.getConnection();
		String query="select book_date+90 from booking where adharcard=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		
		pstmt.setLong(1, donor.getAdharcard());
		//System.out.println(donor.getAdharcard());
		ResultSet rs= pstmt.executeQuery();
		while(rs.next()) {
			
			
			date= rs.getDate(1);
		}
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//System.out.println(date);
	 
	 return date;
 }
 
 public int updateDateForDonor(BookingModel book) {
	 
	 ConnectionUtil connection=new ConnectionUtil();
	 try {
		Connection con=connection.getConnection();
		String query="update booking set book_date=? where adharcard=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setDate(1, new java.sql.Date(book.getAppdate().getTime()));
		pstmt.setLong(2, book.getDonor().getAdharcard());		
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 return 0;
 }
}

