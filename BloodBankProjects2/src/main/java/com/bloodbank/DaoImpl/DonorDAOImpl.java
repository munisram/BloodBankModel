package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bloodbank.Dao.DonorDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.Donor;

public class DonorDAOImpl implements DonorDAO {
	public int insertDonor(Donor donor) {
		ConnectionUtil connection = new ConnectionUtil();
		int tempNumber = 0;
		try {

			Connection con = connection.getConnection();
			String query = "insert into donor_details values(?,?,?,?,?,?,?)";
			String commit = "commit";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, donor.getFirstName());
			pstmt.setString(2, donor.getLastName());
			pstmt.setString(3, donor.getAddress());
			pstmt.setLong(4, donor.getAadharcard());
			pstmt.setLong(5, donor.getNumber());
			pstmt.setDate(6, new java.sql.Date(donor.getDonorDate().getTime()));
			pstmt.setString(7, donor.getBloodType());
			tempNumber = pstmt.executeUpdate();
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

	public Donor validAadharcardNumber(Long aadharcard) {
		Donor donor = null;
		ConnectionUtil connection = new ConnectionUtil();
		try {

			Connection con = connection.getConnection();
			String query = "select FIRST_NAME,LAST_NAME,ADDRESS,AADHARCARD,PHONE,DONOR_DATE,BLOOD_TYPE from donor_details where aadharcard=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setLong(1, aadharcard);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				donor = new Donor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getLong(5),
						rs.getDate(6), rs.getString(7));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return donor;
	}

	public int updateDonor(Donor donor) {
		ConnectionUtil connection = new ConnectionUtil();
		int n = 0;
		try {
			Connection con = connection.getConnection();
			String commit = "commit";
			String query = "update donor_details set address=?,age=?,phone=? where aadharcard=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, donor.getAddress());
			pstmt.setDate(2, new java.sql.Date(donor.getDonorDate().getTime()));
			pstmt.setLong(3, donor.getNumber());
			pstmt.setLong(4, donor.getAadharcard());
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

	public List<Donor> showDonor() {
		List<Donor> donorList = null;
		ConnectionUtil connection = new ConnectionUtil();
		donorList = new ArrayList<Donor>();
		try {
			Connection con = connection.getConnection();
			String query = "select FIRST_NAME,LAST_NAME,ADDRESS,AADHARCARD,PHONE,DONOR_DATE,BLOOD_TYPE from donor_details";

			PreparedStatement pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				Donor donor = new Donor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getLong(5),
						rs.getDate(6), rs.getString(7));
				donorList.add(donor);
				// donorList=rs.getInt(1),rs.getString(2),rs.getString(3),
				// rs.getString(4),rs.getLong(5),rs.getLong(6),rs.getInt(7), rs.getString(8);
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

	public Long aadharcardNumber(Donor donor) {
		Long aadharcardNumber = null;
		ConnectionUtil connection = new ConnectionUtil();
		try {
			Connection con = connection.getConnection();
			String query = "select AADHARCARD from donor_details where PHONE=? and FIRST_NAME=? and LAST_NAME=?";
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setLong(1, donor.getNumber());
			pstmt.setString(2, donor.getFirstName());
			pstmt.setString(3, donor.getLastName());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				aadharcardNumber = rs.getLong(4);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aadharcardNumber;
	}

	public Donor validNumber(Long number) {
		Donor donor1 = null;
		ConnectionUtil connection = new ConnectionUtil();
		try {
			Connection con = connection.getConnection();
			String query = "select FIRST_NAME,LAST_NAME,ADDRESS,AADHARCARD,PHONE,DONOR_DATE,BLOOD_TYPE from donor_details where aadharcard=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setLong(1, number);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				donor1 = new Donor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getLong(5),
						rs.getDate(6), rs.getString(7));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return donor1;
	}

}
