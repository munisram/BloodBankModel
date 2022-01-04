package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.bloodbank.Dao.BloodStackDAOlmpl;
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
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
		String collectorName=request.getParameter("NAME");
		Long aadharcard=Long.parseLong(request.getParameter("number"));
		String hospitalName=request.getParameter("HOSPITAL");
		String bloodtype=request.getParameter("bloodtype");
		
		int unit=Integer.parseInt(request.getParameter("UNIT"));
		Date date=null;
		try {
			date = sdf.parse(request.getParameter("Date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		HttpSession htp=request.getSession();
		SeekerDetails seeker= (SeekerDetails) 
	     htp.getAttribute("currentSeeker");	
		
		
	RequestModel model =new RequestModel(hospitalName, bloodtype,unit , collectorName, seeker.getPhoneNumber(), aadharcard,date);
	
	htp.setAttribute("requestModel", model);
	
			RequestDAOlmpl Dao=new RequestDAOlmpl();
			
				
		int n=Dao.insertRequest(model);
	
		
		
		
		
		if(n>0) {
			BloodStackDAOlmpl stockDao=new BloodStackDAOlmpl();
			//System.out.println("request insert");
		if(stockDao.checkOfQuantity(model.getBloodType())>unit) {
			//System.out.println("unit check");
		      RequestDispatcher rd=request.getRequestDispatcher("BillingSeekerServlet");
		      rd.forward(request, response);

		}
		else {
			
			response.sendRedirect("index.jsp");
			
		}
		
		
		}
		
		
		
		
		
		
		
	}

}
