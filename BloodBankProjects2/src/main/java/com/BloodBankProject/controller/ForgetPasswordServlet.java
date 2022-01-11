package com.BloodBankProject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.SeekerDAOlmpl;
import com.bloodbank.exception.ExeceptionHandle;

/**
 * Servlet implementation class ForgetPasswordServlet
 */
@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String password1=request.getParameter("CONFIRMPASSWORD") ;
		String password2=request.getParameter("PASSWORD") ;
		HttpSession session=request.getSession();
		try {
		if(password1.equals(password2)) {
			
		Long phoneNumber= (Long) request.getAttribute("SeekerPhoneNumber");
			SeekerDAOlmpl Dao=new SeekerDAOlmpl();
			Dao.ForgetPassword(phoneNumber, password2);	
			
			response.sendRedirect("SeekerLogin.jsp");
			
		}else {
			throw new ExeceptionHandle();
			
			
			
		}
		}catch (ExeceptionHandle e) {
			
			session.setAttribute("PasswordError", e.ForgetPassword());
			
			response.sendRedirect("ForgetPassword.jsp");
			
		}
		
	}

}
