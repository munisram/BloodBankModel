package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bloodbank.Dao.BookingDAO;
import com.bloodbank.Dao.DonorDAO;
import com.bloodbank.Util.ConnectionUtil;
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
		String query="insert into booking (aadharcard,address,book_date,blood_type,blood_collect_choice) values(?,?,?,?,?)";
		try {
			Connection con=connection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(query);
			System.out.println("priya"+book.getAddress());
			//String commit="commit";
			//System.out.println(book.getDonor().getAadharcard());
			
			pstmt.setLong(1,book.getDonor().getAadharcard());
			pstmt.setString(2, book.getAddress());
			pstmt.setDate(3, java.sql.Date.valueOf(book.getAppdate() ));
			pstmt.setString(4, book.getBloodType());
			pstmt.setString(5, book.getBloodCollectChoice());
			
			tempNumber=pstmt.executeUpdate();
			
			//pstmt.executeQuery(commit);
			//System.out.println("insert"+tempNumber);
	     //fg System.out.println("DONE...!!!");
			
		
			
			
			
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
		String query="update booking set address=?,book_date=?,blood_collect_choice=? where aadharcard=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		String commit="commit";
		pstmt.setString(1, book.getAddress());
		pstmt.setDate(2, java.sql.Date.valueOf( (book.getAppdate())));
		pstmt.setLong(4,book.getDonor().getAadharcard());
		pstmt.setString(3,book.getBloodCollectChoice());
		tempNumber=pstmt.executeUpdate();
		pstmt.executeQuery(commit);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	 
	 
	 return tempNumber;
	 
 }
 public int deleteBooking(Long aadharcard) {
	 ConnectionUtil connection=new ConnectionUtil();
	 //System.out.println(aadharcard+"dfvgbhnjm");
	 int tempNumber=0;
			 try {
				Connection con=connection.getConnection();
				String commit="commit";
				String query="delete from booking where aadharcard=?";
				PreparedStatement pstmt=con.prepareStatement(query);
				
				pstmt.setLong(1, aadharcard);
				
				
			tempNumber=pstmt.executeUpdate();
			pstmt.executeQuery(commit);
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
			
		    Donor donor1=donor.validAadharcardNumber(rs.getLong(2));
		    //System.out.println(donor1);
			model=new BookingModel(donor1,rs.getString(3),rs.getDate(4).toLocalDate(), rs.getString(5), rs.getString(6));
			
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
 
 
 public LocalDate dateCheck(Donor donor) {
	LocalDate date=null;
	 ConnectionUtil connection=new ConnectionUtil();
	 try {
		Connection con=connection.getConnection();
		String query="select book_date+90 from booking where aadharcard=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		//System.out.println(donor.getAadharcard()+"dfcvgbhnjmk,l");
		pstmt.setLong(1, donor.getAadharcard());
		//System.out.println(donor.getAdharcard());
		ResultSet rs= pstmt.executeQuery();
		System.out.println("date");
		while(rs.next()) {
			
			
			date= rs.getDate(1).toLocalDate();
			//System.out.println("date "+ rs.(1));
			//System.out.println("Date"+date);
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
		String commit="commit";
		String query="update booking set book_date=? where aadharcard=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setDate(1, java.sql.Date.valueOf(book.getAppdate()));
		pstmt.setLong(2, book.getDonor().getAadharcard());	
		pstmt.executeQuery(query);
		pstmt.executeQuery(commit);
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 return 0;
 }

 public List<BookingModel> ShowBookingDonor(Donor donor){
	 BookingModel model=null;
	 ConnectionUtil connection =new ConnectionUtil();
	 List<BookingModel>booking=new ArrayList<BookingModel>();
	 try {
		
		Connection con=connection.getConnection();
		String query="select * from booking where aadharcard="+donor.getAadharcard();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
		    //System.out.println(donor1);
			model=new BookingModel(donor,rs.getString(3),rs.getDate(4).toLocalDate(), rs.getString(5), rs.getString(6));
			
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
 
 
 

 public List<BookingModel> ShowBookingAdmin(){
	 BookingModel model=null;
	 ConnectionUtil connection =new ConnectionUtil();
	 List<BookingModel>booking=new ArrayList<BookingModel>();
	 try {
		
		Connection con=connection.getConnection();
		String query="select * from booking ";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
			DonorDAOImpl donor=new DonorDAOImpl();
			
		    Donor donor1=donor.validAadharcardNumber(rs.getLong(2));
		    //System.out.println(donor1);
			model=new BookingModel(donor1,rs.getString(3),rs.getDate(4).toLocalDate(), rs.getString(5), rs.getString(6));
			
			booking.add(model);
			
		}
		//System.out.println(rs.getString(3));
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 return booking;
	 
 
 
 }

}
