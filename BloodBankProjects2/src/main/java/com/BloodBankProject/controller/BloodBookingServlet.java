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
import javax.servlet.http.HttpSession;

import com.bloodbank.Dao.BookingDAOlmpl;
import com.bloodbank.Dao.DonorDAOImpl;
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

/**
 * Servlet implementation class BloodBookingServlet
 */
@WebServlet("/BloodBookingServlet")
public class BloodBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BloodBookingServlet() {
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
		String address=request.getParameter("address");
		String bloodType =request.getParameter("bloodtype");
	     String choice =request.getParameter("Choice");     
		try {
			 date=sdf.parse(request.getParameter("bookingDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession htp=request.getSession();
		Donor donor= (Donor) htp.getAttribute("currentDonor");
		PrintWriter pw=response.getWriter();
		
		
		
		BookingModel booking =new BookingModel(donor, address, date, bloodType, choice);
		BookingDAOlmpl bookingDao=new BookingDAOlmpl();
		pw.write(donor.getAddress());
	int n=	bookingDao.booking(booking);
				 
		if(n>0) {
			response.sendRedirect("PhysicalCheck.jsp");
		}
		
		
	}

}
