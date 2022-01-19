package com.BloodBankProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LocalDate date = null;
		String address = request.getParameter("address");
		
		String choice = request.getParameter("Choice");
		
		BookingDAOlmpl bookingDao = new BookingDAOlmpl();

		try {
			date = LocalDate.parse(request.getParameter("bookingDate"));
			

			HttpSession htp = request.getSession();

			Donor donor = (Donor) htp.getAttribute("Donor");
			
			
			AdminDAOlmpl admin = new AdminDAOlmpl();
			
			
			LocalDate date1 = bookingDao.dateCheck(donor);
			
		System.out.println(date1+"gowtham");
			
			if (date1 != null && date.isAfter(date1) && admin.CheckWallet() > 300) {
				// System.out.println("Hello Peter");
System.out.println("kaviya");
				PrintWriter out = response.getWriter();
				if(address!=null) {

				BookingModel booking = new BookingModel(donor, address, date, donor.getBloodType(), choice);
				htp.setAttribute("bookingDate", booking);
				int i = bookingDao.booking(booking);

				if (i > 0) {

					out.println("<script type=\"text/javascript\">");
					out.println("alert('Booking Successfully');");
					out.println("location='BookingProcess.jsp';");
					out.println("</script>");
					// response.sendRedirect("");
					//System.out.println("Hello Peter");
					//response.sendRedirect("BookingProcess.jsp");

				}

				
				}
				
				else {
					
                             System.out.println("kaviya 2"); 
					
					String address1=donor.getAddress();
					BookingModel booking = new BookingModel(donor, address1, date, donor.getBloodType(), choice);
					htp.setAttribute("bookingDate", booking);
					int i = bookingDao.booking(booking);

					if (i > 0) {

						out.println("<script type=\"text/javascript\">");
						out.println("alert('Booking Successfully');");
						out.println("location='BookingProcess.jsp';");
						out.println("</script>");
						// response.sendRedirect("");
						System.out.println("Hello Peter");
						response.sendRedirect("BookingProcess.jsp");

					}
					
					
				}
			}
			// }
			else if (date1 == null && admin.CheckWallet() > 300) {

				
				if(address!=null) {
					
					
				
				BookingModel booking = new BookingModel(donor, address, date, donor.getBloodType(), choice);
				htp.setAttribute("bookingDate", booking);

				if (bookingDao.booking(booking) > 0) {

					PrintWriter out = response.getWriter();

					out.println("<script type=\"text/javascript\">");
					out.println("alert('Booking Successfully');");
					 out.println("location='BookingProcess.jsp';");
					out.println("</script>");
					System.out.println("Hello Peter");
					
					//response.sendRedirect("BookingProcess.jsp");

				}
				
				
				
				}else {
					
					
					String address2=donor.getAddress();
					
					BookingModel booking = new BookingModel(donor,address2, date, donor.getBloodType(), choice);
					htp.setAttribute("bookingDate", booking);
					int i = bookingDao.booking(booking);

					if (bookingDao.booking(booking) > 0) {

						PrintWriter out = response.getWriter();

						out.println("<script type=\"text/javascript\">");
						out.println("alert('Booking Successfully');");
						out.println("location='BookingProcess.jsp';");
						out.println("</script>");
						System.out.println("Hello Peter 2");
						//response.sendRedirect("BookingProcess.jsp");

					}
					
					
				}

			} else {

				PrintWriter out = response.getWriter();

				out.println("<script type=\"text/javascript\">");
				out.println("alert('your previous donated date is with in 90 days,so please donate after 90 days ');");
				out.println("location='index.jsp';");
				out.println("</script>");
				System.out.println("Joh Wick");
				//response.sendRedirect("BookingProcess.jsp");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
