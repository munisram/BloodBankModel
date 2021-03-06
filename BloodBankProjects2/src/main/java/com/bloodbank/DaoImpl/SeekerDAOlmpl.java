package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bloodbank.Dao.SeekerDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.SeekerDetails;

public class SeekerDAOlmpl implements SeekerDAO {
	int n = 0;

	public int insertSeekerDetails(SeekerDetails details) {
		ConnectionUtil connection = new ConnectionUtil();
		String query = "insert into seeker_details (first_name,last_name,address,phone_number,password,patient_id,hospital_name,blood_type)"
				+ "values(?,?,?,?,?,?,?,?)";
		String commit = "commit";
		try {
			Connection con = connection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, details.getFirstName());
			pstmt.setString(2, details.getLastName());
			pstmt.setString(3, details.getAddress());
			pstmt.setLong(4, details.getPhoneNumber());
			pstmt.setString(5, details.getPassword());
			pstmt.setLong(6, details.getPatientId());
			pstmt.setString(7, details.getHospitalName());
			pstmt.setString(8, details.getBloodType());

			n = pstmt.executeUpdate();
			pstmt.executeQuery(commit);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n;
	}

	public int seekerIdFind(SeekerDetails seeker) {
		ConnectionUtil connection = new ConnectionUtil();

		int n = 0;
		try {
			Connection con = connection.getConnection();
			String query = "select ID  from seeker_details where first_name=? and last_name=? ";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, seeker.getFirstName());
			pstmt.setString(2, seeker.getLastName());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				n = rs.getInt(1);
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

	public SeekerDetails seekerObject(String password, Long phoneNumber) {
		ConnectionUtil connection = new ConnectionUtil();

		SeekerDetails seeker = null;

		try {
			Connection con = connection.getConnection();
			String query = "select FIRST_NAME,LAST_NAME,ADDRESS,PHONE_NUMBER,PASSWORD,PATIENT_ID,HOSPITAL_NAME,BLOOD_TYPE  from seeker_details where PASSWORD=? and PHONE_NUMBER=? ";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, password);
			pstmt.setLong(2, phoneNumber);
			ResultSet rs = pstmt.executeQuery();
			// System.out.println(bloodType);

			while (rs.next()) {
				seeker = new SeekerDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4),
						rs.getString(5), rs.getLong(6), rs.getString(7), rs.getString(8));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return seeker;

	}

	public SeekerDetails FindSeekerId(int seekerId) {

		SeekerDetails seeker = null;

		ConnectionUtil connection = new ConnectionUtil();
		try {
			Connection con = connection.getConnection();
			String query = "select FIRST_NAME,LAST_NAME,ADDRESS,PHONE_NUMBER,PASSWORD,PATIENT_ID,HOSPITAL_NAME,BLOOD_TYPE  from seeker_details";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				seeker = new SeekerDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4),
						rs.getString(5), rs.getLong(6), rs.getString(7), rs.getString(8));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return seeker;

	}

	public SeekerDetails FindSeekerObjectId(long phoneNumber) {

		SeekerDetails seeker = null;

		ConnectionUtil connection = new ConnectionUtil();
		try {
			Connection con = connection.getConnection();
			String query = "select FIRST_NAME,LAST_NAME,ADDRESS,PHONE_NUMBER,PASSWORD,PATIENT_ID,HOSPITAL_NAME,BLOOD_TYPE from seeker_details where PHONE_NUMBER =?";
			
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setLong(1, phoneNumber);
			ResultSet rs = pstmt.executeQuery(query);
			while (rs.next()) {
				seeker = new SeekerDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getString(6), rs.getLong(7), rs.getString(8), rs.getString(9));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return seeker;

	}

	public Long PhoneNumberValid(long phoneNumber) {

		Long number = null;

		ConnectionUtil connection = new ConnectionUtil();
		try {
			Connection con = connection.getConnection();
			String query = "select PHONE_NUMBER from seeker_details where PHONE_NUMBER ='" + phoneNumber + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				number = rs.getLong(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return number;

	}

	public int ForgotPassword(Long phoneNumber, String password) {
		int n = 0;
		ConnectionUtil connection = new ConnectionUtil();

		try {
			Connection con = connection.getConnection();
			// String commit="commit";
			String query = "update  seeker_details  set PASSWORD=?  where PHONE_NUMBER=?";

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, password);
			// System.out.println(phoneNumber);
			pstmt.setLong(2, phoneNumber);

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

}
