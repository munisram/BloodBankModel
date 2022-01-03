package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.Dao.RequestDAOlmpl;
import com.bloodbank.model.Donor;
import com.bloodbank.model.RequestModel;
import com.bloodbank.model.SeekerDetails;

/**
 * Servlet implementation class SeekerRequestServlet
 */
@WebServlet("/SeekerRequestServlet")
public class SeekerRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeekerRequestServlet() {
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
		
		String collectorName=request.getParameter("NAME");
		Long aadharcard=Long.parseLong(request.getParameter("number"));
		Long phoneNumber=Long.parseLong(request.getParameter("PHONE"));
		String hospitalName=request.getParameter("HOSPITAL");
		String bloodtype=request.getParameter("bloodtype");
		int unit=Integer.parseInt(request.getParameter("UNIT"));
	
		
		HttpSession htp=request.getSession();
		SeekerDetails seeker= (SeekerDetails) htp.getAttribute("currentSeeker");
		PrintWriter pw=response.getWriter();
		
	RequestModel model =new RequestModel(hospitalName, bloodtype,unit , collectorName, phoneNumber, aadharcard);
			RequestDAOlmpl Dao=new RequestDAOlmpl();
		int n=Dao.insertRequest(model);
		if(n>0) {
			
		      RequestDispatcher rd=request.getRequestDispatcher("BillingSeekerServlet");
		      rd.forward(request, response);
			              
		
			
			
			
		}
		
		
		
		
		
		
		
	}

}
