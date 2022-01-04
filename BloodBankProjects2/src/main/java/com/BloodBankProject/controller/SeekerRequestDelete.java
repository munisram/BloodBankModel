package com.BloodBankProject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.Dao.RequestDAOlmpl;

/**
 * Servlet implementation class SeekerRequestDelete
 */
@WebServlet("/SeekerRequestDelete")
public class SeekerRequestDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeekerRequestDelete() {
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
		Long aadharcard=Long.parseLong(request.getParameter("Aadharcard"));
		
		RequestDAOlmpl dao=new RequestDAOlmpl();
		if(dao.deleteRequest(aadharcard)>0) {
			
			HttpSession htp=request.getSession();
			htp.setAttribute("currentSeeker",null );
			
			response.sendRedirect("index.jsp");
		}
		
		
		
		
	}

}
