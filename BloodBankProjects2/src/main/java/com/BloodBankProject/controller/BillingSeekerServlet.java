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

import com.bloodbank.Dao.AdminDAOlmpl;
import com.bloodbank.Dao.BillingDAOlmpl;
import com.bloodbank.Dao.BloodStackDAOlmpl;
import com.bloodbank.model.BillingModel;
import com.bloodbank.model.BloodStack;
import com.bloodbank.model.RequestModel;
import com.bloodbank.model.SeekerDetails;

/**
 * Servlet implementation class BillingSeekerServlet
 */
@WebServlet("/BillingSeekerServlet")
public class BillingSeekerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillingSeekerServlet() {
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
		
		   PrintWriter pw=response.getWriter();
		 SeekerDetails seeker=null;
		 
		  
		   
		HttpSession hp=request.getSession();
	RequestModel requestModel= (RequestModel) hp.getAttribute("requestModel");
		       seeker=  (SeekerDetails) hp.getAttribute("currentSeeker");
		
		   
		  BloodStackDAOlmpl stack=new BloodStackDAOlmpl();
		  double unitPrice= stack.findPrice(requestModel.getBloodType());
		 
		  pw.write(""+ unitPrice);
		  
		 BillingModel  BillingModel=new  BillingModel(requestModel.getBloodType(), seeker, requestModel.getUnit(), unitPrice);
		 
		 BillingDAOlmpl biiling=new  BillingDAOlmpl();
		 
	int n= biiling.insertBilling(BillingModel);
	
	
		
	if(n>0) {
		
	int num=	stack.updateStackReduce(requestModel.getBloodType(), requestModel.getUnit());
	
	
	System.out.println(num);
		if(num>0) {
			
			AdminDAOlmpl admin=new AdminDAOlmpl();
		if(admin.seekerPayment(unitPrice)>0) {
			
			
			
			
		}
			
			
		}
		
		
	}

		
	}

}