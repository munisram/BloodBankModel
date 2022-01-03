package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.Dao.SeekerDAOlmpl;
import com.bloodbank.model.SeekerDetails;

/**
 * Servlet implementation class SeekerRigester
 */
@WebServlet("/SeekerRigester")
public class SeekerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeekerRegisterServlet() {
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
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastName");
		String address=request.getParameter("address");
		Long phoneNumber=Long.parseLong(request.getParameter("number"));
		Long PATIENT=Long.parseLong(request.getParameter("PATIENT")); 
		String HOSPITAL=request.getParameter("HOSPITAL");		
		String bloodtype=request.getParameter("bloodtype");
	String password=request.getParameter("PASSWORD");
		
		SeekerDetails seeker=new SeekerDetails(firstname, lastname, address, phoneNumber,password, PATIENT, HOSPITAL, bloodtype);
		SeekerDAOlmpl Dao=new SeekerDAOlmpl();
	int n=	Dao.insertSeekerDetails(seeker);
		PrintWriter pw =response.getWriter();
		
		if(n>0)
		{
		
			
			
			    
			    response.sendRedirect("SeekerLogin.jsp");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
