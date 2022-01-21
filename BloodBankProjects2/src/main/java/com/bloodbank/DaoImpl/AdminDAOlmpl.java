package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bloodbank.Dao.AdminDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.AdminModel;

public class AdminDAOlmpl implements AdminDAO {

	public AdminModel verificationAdmin(AdminModel aModel) {
		AdminModel model = null;

		ConnectionUtil connection = new ConnectionUtil();
		try {
			Connection con = connection.getConnection();

			String query = "select EMAIL ,PASSWORD,WALLET  from admin where email=? and password=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, aModel.getEmail());
			pstmt.setString(2, aModel.getPassword());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				model = new AdminModel(rs.getString(1), rs.getString(2), rs.getDouble(3));
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;
	}

	public AdminModel updateWallet() {

		int n = 0;

		AdminModel admin = null;
		ConnectionUtil connection = new ConnectionUtil();
		try {
			Connection con = connection.getConnection();
			String query1 = "select EMAIL ,PASSWORD,WALLET from admin";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query1);

			while (rs.next()) {
				admin = new AdminModel(rs.getString(1), rs.getString(2), rs.getDouble(3));
			}
			// System.out.println(id);
			double walletTotal = admin.getWallet() - 300;

			// System.out.println(walletTotal);
			String query = "update admin set wallet=? where email=?";
			// String commit="commit";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, walletTotal);
			pstmt.setString(2, admin.getEmail());
			n = pstmt.executeUpdate();
			// pstmt.executeQuery(commit);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;

	}

	public int seekerPayment(double totalPrice) {

		AdminDAOlmpl adminDao = new AdminDAOlmpl();
		AdminModel admin = new AdminModel();
		admin = adminDao.updateWallet();
		double total = admin.getWallet() + totalPrice;
		int n = 0;
		ConnectionUtil connection = new ConnectionUtil();
		try {
			Connection con = connection.getConnection();
			String commit = "commit";
			String query = "update admin set wallet=? where email=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, total);
			pstmt.setString(2, admin.getEmail());
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

	public Double CheckWallet() {
		double wallet = 0;
		ConnectionUtil connection = new ConnectionUtil();
		try {
			Connection con = connection.getConnection();
			String query = "select wallet from admin";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				wallet = rs.getDouble(1);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return wallet;
	}

}
