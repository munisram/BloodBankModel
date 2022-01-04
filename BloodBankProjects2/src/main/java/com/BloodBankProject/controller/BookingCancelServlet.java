package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodbank.Dao.BookingDAOlmpl;

/**
 * Servlet implementation class BookingCancelServlet
 */
@WebServlet("/BookingCancelServlet")
public class BookingCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingCancelServlet() {
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
		
		Long aadharcard=Long.parseLong(request.getParameter("aadharcard"));
		
		BookingDAOlmpl Dao=new BookingDAOlmpl();
		
		if(Dao.deleteBooking(aadharcard)>0) {
			PrintWriter pw=response.getWriter();
			pw.write("Booking cancel");
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
