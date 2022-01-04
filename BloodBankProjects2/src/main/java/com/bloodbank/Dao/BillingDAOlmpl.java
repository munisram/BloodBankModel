package com.bloodbank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Interface.Dao.BillingDAO;
import com.bloodbank.model.BillingModel;
import com.bloodbank.model.SeekerDetails;

public class BillingDAOlmpl  implements BillingDAO{
	
	public int insertBilling(BillingModel bill ){
		int n=0;
		
		ConnectionUtil connection =new  ConnectionUtil();
		try {
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
	public List<BillingModel> biilingShow(){
		List<BillingModel>billingList=new ArrayList<BillingModel>();
		
		
		ConnectionUtil connection=new ConnectionUtil();
		try {
			Connection con=connection.getConnection();
			String query="select * from billing";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				SeekerDAOlmpl seekerDao=new SeekerDAOlmpl();
				SeekerDetails seeker=null;
				seeker= seekerDao.SeekerFindId(rs.getInt(5));
				  
				
						
				BillingModel bill=new BillingModel(rs.getString(2),seeker,rs.getInt(4),rs.getInt(5));
				billingList.add(bill);
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