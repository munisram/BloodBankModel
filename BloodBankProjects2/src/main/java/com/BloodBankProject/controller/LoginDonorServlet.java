package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Interface.Dao.DonorDAO;
import com.bloodbank.Dao.DonorDAOImpl;
import com.bloodbank.model.Donor;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDonorServlet() {
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
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		
		Long adharcard=Long.parseLong(request.getParameter("adharcard"));
		Donor donor =new Donor();
		DonorDAOImpl donorDao=new DonorDAOImpl();
		
	    donor= donorDao.validAdharcardNumber(adharcard);
	 
	    
		if(donor!=null) {
			   HttpSession htp=request.getSession() ;
			    htp.setAttribute("currentDonor", donor);
			    
			response.sendRedirect("Bookingindex.jsp");
		
		}else {
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Not a registered User'):");
			pw.println("</script>");
			RequestDispatcher rd=request.getRequestDispatcher("DonorLogin.jsp");
			rd.include(request, response);
		}
		
	}

}
