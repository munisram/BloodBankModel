package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.zone.ZoneRulesException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.DaoImpl.AdminDAOlmpl;
import com.bloodbank.DaoImpl.BloodDetailsDAOlmpl;
import com.bloodbank.DaoImpl.BloodStackDAOlmpl;
import com.bloodbank.DaoImpl.BookingDAOlmpl;
import com.bloodbank.DaoImpl.DonorDAOImpl;
import com.bloodbank.model.BloodDetailsModel;
import com.bloodbank.model.BloodStack;
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

/**
 * Servlet implementation class BloodBookingServlet
 */
@WebServlet("/BloodBookingServlet")
public class BloodBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BloodBookingServlet() {
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
		SimpleDateFormat sdf=new  SimpleDateFormat("yyyy-MM-dd");
		//PrintWriter pw=response.getWriter();
		Date date=null;
		String address=request.getParameter("address");
		 String choice =request.getParameter("Choice");  
	     BookingDAOlmpl bookingDao=new BookingDAOlmpl();
	     
		try {
			 date=sdf.parse(request.getParameter("bookingDate"));
			 
				HttpSession htp=request.getSession();
				
        		Donor donor= (Donor) htp.getAttribute("Donor");
			 			 Date date1=bookingDao.dateCheck(donor);
			 			 AdminDAOlmpl admin=new AdminDAOlmpl();
                   if(date1!=null && date.after(date1)&& admin.CheckWallet()>300) {
            	 
            	 
            	
            		PrintWriter out=response.getWriter();
            		
            		
            		
            		BookingModel booking =new BookingModel(donor, address, date,donor.getBloodType(), choice);
            		htp.setAttribute("bookingDate",booking);
            		
            		
            	
            				 
            		if(bookingDao.booking(booking)>0) {
            			
            			out.println("<script type=\"text/javascript\">");
            			out.println("alert('Booking Successfully');");
            			out.println("location='BookingProces.jsp';");
            			out.println("</script>");
            			//response.sendRedirect("");
            			
            			
            		}
            			
            			
    					
            			
            			
            		}
            		
                        else if(date1==null&& admin.CheckWallet()>300){
            		        	  
                	   BookingModel booking =new BookingModel(donor, address, date,donor.getBloodType(), choice);
               		htp.setAttribute("bookingDate",booking);          		        	  
           	 
           	 
            	 
                           if(bookingDao.booking(booking)>0) {
            			

                       		PrintWriter out=response.getWriter();

                   			out.println("<script type=\"text/javascript\">");
                   			out.println("alert('Booking Successfully');");
                   			out.println("location='BookingProces.jsp';");
                   			out.println("</script>");
                        	   
                       		
           					
            			
            		}
            		
            	 
            	 
             }else {
            	 
            	 
            	 PrintWriter out=response.getWriter();  
            	 
            	 out.println("<script type=\"text/javascript\">");
					out.println("alert('your previous donated date is with in 90 days,so please donate after 90 days ');");
					out.println("location='index.jsp';");
					out.println("</script>");
            	          	 
            	
            	 
             }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
