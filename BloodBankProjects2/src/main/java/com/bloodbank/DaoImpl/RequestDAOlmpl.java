package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bloodbank.Dao.RequestDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.RequestModel;
import com.bloodbank.model.SeekerDetails;

public class RequestDAOlmpl implements RequestDAO {

	public int insertRequest(RequestModel request) {
		int n = 0;
		ConnectionUtil connection = new ConnectionUtil();
		String query = "insert into request_details (hospital_name,blood_type,unit,blood_collector_name,phone_number,aadharcard_number,request_date,status) values(?,?,?,?,?,?,?,?)";
		// String commit="commit";

		try {
			Connection con = connection.getConnection();
			// System.out.println( new java.sql.Date( request.getRequestDate().getTime()));
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, request.getHospitalName());
			pstmt.setString(2, request.getBloodType());
			pstmt.setInt(3, request.getUnit());
			pstmt.setString(4, request.getBloodCollectorName());
			pstmt.setLong(5, request.getPhoneNumber());
			pstmt.setLong(6, request.getAadharcard());
			pstmt.setDate(7, new java.sql.Date(request.getRequestDate().getTime()));
			pstmt.setString(8, request.getStatus());
			n = pstmt.executeUpdate();
			// pstmt.executeQuery(commit);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n;

	}

	public int deleteRequest(Long aadharcard) {
		ConnectionUtil connection = new ConnectionUtil();
		int tempNumber = 0;
		// System.out.println(aadharcard);
		try {
			Connection con = connection.getConnection();
			String commit = "commit";
			
			String query = "delete from request_details where aadharcard_number =" + aadharcard;
			Statement stmt = con.createStatement();
			tempNumber = stmt.executeUpdate(query);
			stmt.executeQuery(commit);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tempNumber;

	}

	public String StatusCheck(Long aadharcard) {
		ConnectionUtil connection = new ConnectionUtil();
		String status = null;

		try {
			Connection con = connection.getConnection();
			// String commit="commit";
			String query = "select status from  request_details where aadharcard_number =" + aadharcard;
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// stmt.executeQuery(commit);
			while (rs.next()) {

				status = rs.getString(1);
			}

           
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;

	}

	public List<RequestModel> ShowRequest() {
		List<RequestModel> requestList = new ArrayList<RequestModel>();
		ConnectionUtil connection = new ConnectionUtil();
		try {
			Connection con = connection.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS	 from request_details order by request_id desc";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				RequestModel request = new RequestModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getLong(5), rs.getLong(6), rs.getDate(7), rs.getString(8));
				requestList.add(request);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return requestList;
	}

	public List<RequestModel> ShowRequestSeeker(Long phoneNumber) {
		List<RequestModel> requestList = new ArrayList<RequestModel>();
		ConnectionUtil connection = new ConnectionUtil();
		try {
			Connection con = connection.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS from request_details where PHONE_NUMBER =?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setLong(1, phoneNumber);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				RequestModel request = new RequestModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getLong(5), rs.getLong(6), rs.getDate(7), rs.getString(8));
				requestList.add(request);


				

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return requestList;
	}

	public RequestModel RequestObject(Long phoneNumber) {
		RequestModel request = null;
		ConnectionUtil connection = new ConnectionUtil();
		try {
			Connection con = connection.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS from request_details where PHONE_NUMBER =?" ;
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setLong(1, phoneNumber);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				request = new RequestModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getLong(5), rs.getLong(6), rs.getDate(7), rs.getString(8));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return request;
	}

	public Long AadharcardValid(Long aadharcard) {
		ConnectionUtil connection = new ConnectionUtil();
		Long tempNumber = null;

		try {
			Connection con = connection.getConnection();
			// String commit="commit";
			String query = "select AADHARCARD_NUMBER from request_details where aadharcard_number =?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setLong(1, aadharcard);
			ResultSet rs = pstmt.executeQuery();

			// stmt.executeQuery(commit);
			while (rs.next()) {

				tempNumber = rs.getLong(1);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tempNumber;

	}

	public List<RequestModel> RequestUpdateAndDelete() {
		List<RequestModel> requestList = new ArrayList<RequestModel>();
		ConnectionUtil connection = new ConnectionUtil();
		try {
			Connection con = connection.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS from request_details where status='pending' order by request_id desc";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				RequestModel request = new RequestModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getLong(5), rs.getLong(6), rs.getDate(7), rs.getString(8));
				requestList.add(request);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return requestList;
	}

}
