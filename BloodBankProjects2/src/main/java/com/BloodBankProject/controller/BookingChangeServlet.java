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
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

/**
 * Servlet implementation class BookingChangeServlet
 */
@WebServlet("/BookingChangeServlet")
public class BookingChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingChangeServlet() {
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
		Date BookingDate=null;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
		String address=request.getParameter("address");
		String choice=request.getParameter("Choice");
		
		try {
			 BookingDate=sdf.parse(request.getParameter("bookingDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw=response.getWriter();
		HttpSession htp=request.getSession();
		Donor donor= (Donor) htp.getAttribute("currentDonor");
		
		 BookingModel model=new BookingModel(donor, address, BookingDate, donor.getBloodType(), choice);
		BookingDAOlmpl Dao=new BookingDAOlmpl();
		if(Dao.updateBooking(model)>0) {
			response.sendRedirect("PhysicalCheck.jsp");
		}
		
		
		
		
		
	}

}