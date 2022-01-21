package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bloodbank.Dao.BloodDetailsDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.BloodDetailsModel;
import com.bloodbank.model.Donor;

public class BloodDetailsDAOlmpl implements BloodDetailsDAO {

	public int insertBloodDetails(BloodDetailsModel details) {
		int tempNumber = 0;
		ConnectionUtil connection = new ConnectionUtil();
		try {
			Connection con = connection.getConnection();

			String query = "insert into blood_details(blood_type,aadharcard,unit,price) values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			String commit = "commit";
			pstmt.setString(1, details.getBloodType());
			pstmt.setLong(2, details.getDonor().getAadharcard());
			pstmt.setInt(3, details.getUnit());
			pstmt.setInt(4, details.getPrice());
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

	public List<BloodDetailsModel> ShowBloodDetails(Donor donor) {
		BloodDetailsModel details = null;

		List<BloodDetailsModel> showList = new ArrayList<BloodDetailsModel>();

		ConnectionUtil connection = new ConnectionUtil();

		try {
			Connection con = connection.getConnection();
			String query = "select BLOOD_TYPE,AADHARCARD,UNIT,PRICE from blood_details where aadharcard=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setLong(1, donor.getAadharcard());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				details = new BloodDetailsModel(donor, rs.getInt(3), rs.getString(1), rs.getInt(4));

				showList.add(details);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return showList;

	}

}
