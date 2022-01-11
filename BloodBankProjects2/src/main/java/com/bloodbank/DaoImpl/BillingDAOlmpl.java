package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bloodbank.Dao.BillingDAO;
import com.bloodbank.model.BillingModel;
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.RequestModel;
import com.bloodbank.model.SeekerDetails;

public class BillingDAOlmpl  implements BillingDAO{
	
	public int insertBilling(BillingModel bill ){
		int n=0;
		
		ConnectionUtil connection =new  ConnectionUtil();
		try {
			RequestDAOlmpl requestDao=new  RequestDAOlmpl();
		  RequestModel model= requestDao.RequestObject(bill.getSeeker().getPhoneNumber());
			
			Connection con=connection.getConnection();
			String query="insert into billing (blood_type,seeker_id,quantity,price) values(?,?,?,?)";
			SeekerDAOlmpl seeker=new SeekerDAOlmpl();
			int seekerId=seeker.seekerIdFind(bill.getSeeker());
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, bill.getBloodType());
			pstmt.setInt(2,seekerId );
			pstmt.setInt(3, bill.getUnit());
			pstmt.setDouble(4,bill.getTotalprice() );
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
	public List<BillingModel> biilingShow( BillingModel bill){
		
		List<BillingModel>billingList=new ArrayList<BillingModel>();
		
		
		ConnectionUtil connection=new ConnectionUtil();
		SeekerDAOlmpl seekerDao=new SeekerDAOlmpl();
		int seekerId=seekerDao.seekerIdFind(bill.getSeeker());
		try {
			Connection con=connection.getConnection();
			String query="select * from billing where SEEKER_ID=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			 pstmt.setInt(1,seekerId);
			 ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				
				 
				SeekerDetails seeker=null;
				seeker= seekerDao.FindSeekerId(rs.getInt(5));
				  
				RequestDAOlmpl requestDao=new  RequestDAOlmpl();
				  RequestModel model= requestDao.RequestObject(bill.getSeeker().getPhoneNumber());
						
				BillingModel billing=new BillingModel(rs.getString(2),seeker,rs.getInt(4),rs.getInt(5),rs.getDate(6).toLocalDate());
				billingList.add(billing);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		return billingList;
	}
	
	
public List<BillingModel> biilingShowAdmin(){
		
		List<BillingModel>billingList=new ArrayList<BillingModel>();
		
		
		ConnectionUtil connection=new ConnectionUtil();
		SeekerDAOlmpl seekerDao=new SeekerDAOlmpl();
		
		try {
			Connection con=connection.getConnection();
			String query="select * from billing ";
			Statement stmt=con.createStatement();
			
			 ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				
				 
				SeekerDetails seeker=null;
				seeker= seekerDao.FindSeekerId(rs.getInt(5));
				RequestDAOlmpl requestDao=new  RequestDAOlmpl();
				  RequestModel model= requestDao.RequestObject(seeker.getPhoneNumber());
				
						
				BillingModel billing=new BillingModel(rs.getString(2),seeker,rs.getInt(4),rs.getInt(5),rs.getDate(6).toLocalDate());
				billingList.add(billing);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		return billingList;
	}

public List<BillingModel> biilingShowAdminDate(Date date){
	
	List<BillingModel>billingList=new ArrayList<BillingModel>();
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyy");
	ConnectionUtil connection=new ConnectionUtil();
	SeekerDAOlmpl seekerDao=new SeekerDAOlmpl();
	System.out.println(date);
	try {
		Connection con=connection.getConnection();
		//String query="select * from billing where TO_CHAR(billing_date=?,'YYYY-MM-DD') between TO_CHAR(SYSDATE,'YYYY-MM-DD')";
		String query="select * from billing where ?<=billing_date";
		PreparedStatement pstmt=con.prepareStatement(query);
		
		pstmt.setString(1, sdf.format(date));
		 ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			
			 
			SeekerDetails seeker=null;
			seeker= seekerDao.FindSeekerId(rs.getInt(5));
			RequestDAOlmpl requestDao=new  RequestDAOlmpl();
			  RequestModel model= requestDao.RequestObject(seeker.getPhoneNumber());
			
					
			BillingModel billing=new BillingModel(rs.getString(2),seeker,rs.getInt(4),rs.getInt(5),rs.getDate(6).toLocalDate());
			billingList.add(billing);
		}
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	
	return billingList;
}
}
