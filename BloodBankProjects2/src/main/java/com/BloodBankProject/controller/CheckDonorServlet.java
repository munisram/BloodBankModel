package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.Dao.AdminDAOlmpl;
import com.bloodbank.Dao.BloodDetailsDAOlmpl;
import com.bloodbank.Dao.BloodStackDAOlmpl;
import com.bloodbank.model.BloodDetailsModel;
import com.bloodbank.model.BloodStack;
import com.bloodbank.model.Donor;

/**
 * Servlet implementation class CheckDonorServlet
 */
@WebServlet("/CheckDonorServlet")
public class CheckDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckDonorServlet() {
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
		int height=Integer.parseInt(request.getParameter("Height"));
		int weight =Integer.parseInt(request.getParameter("weight"));
		int temp=Integer.parseInt(request.getParameter("temperature"));
		String yes=request.getParameter("health");
		int pressure=Integer.parseInt(request.getParameter("pressure"));
		int pluse=Integer.parseInt(request.getParameter("pulse"));
		PrintWriter pw=response.getWriter();
		
		//pw.write(yes+pluse);
		
		
		if(temp<=100) {
			
			if(pressure<=180 && pressure>=90) {
				
				if(pluse<=100 && pluse>=50) {
					int unit=1;
					int price=300;
					HttpSession htp=request.getSession();
					Donor donor= (Donor) htp.getAttribute("currentDonor");	
					BloodDetailsModel model=new BloodDetailsModel(donor, unit, donor.getBloodType(),price );
					 BloodDetailsDAOlmpl Dao=new BloodDetailsDAOlmpl();
					int n= Dao.insertBloodDetails(model);
					
					 pw.write(model.getBloodType()+"successs");
					 if(n>0) {
						 
						 BloodStackDAOlmpl bloodStock=new BloodStackDAOlmpl();
						 
						 BloodStack stack=new BloodStack(model.getUnit(), model.getBloodType(), 0);
						 
						int num= bloodStock.updateStack(stack);
						
						 pw.write(num+"successs");
						 if(num>0) {
							 
						 AdminDAOlmpl admin=new AdminDAOlmpl();
						 admin.updateWallet();
						 
						 pw.write("successs");
						
						 
						 
					 }
					 }
					
					
				}
				
			}
			
		}else {
			
		}
		
	}
}
		
		
		
		
