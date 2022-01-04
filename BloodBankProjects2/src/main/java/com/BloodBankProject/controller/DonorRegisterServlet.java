package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodbank.Dao.DonorDAOImpl;
import com.bloodbank.model.Donor;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class DonorRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf=new  SimpleDateFormat("dd-MM-YYYY");
		Date date=null;
		String firstName =request.getParameter("firstname");
		String lastName =request.getParameter("lastName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		Long phoneNumber =Long.parseLong(request.getParameter("number"));
		Long adharcard=Long.parseLong(request.getParameter("ADHARCARD"));
		String bloodType =request.getParameter("bloodtype");
		
	
		
		try {
			 date=sdf.parse(request.getParameter("bio"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	Donor donor=new Donor(firstName, lastName, address, adharcard, phoneNumber, date, bloodType);
		
		DonorDAOImpl donorDao=new DonorDAOImpl();
		    
	   int check= donorDao.insertDonor(donor);
		if(check>0) {
		response.sendRedirect("DonorLogin.jsp");
		}else {
			System.out.println("not insert");
		}
	
	
		
		
		
		
		doGet(request, response);
	}

}
