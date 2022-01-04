<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.bloodbank.model.BookingModel"%>
<%@page import="com.bloodbank.model.Donor"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.Dao.BloodDetailsDAOlmpl"%>
<%@page import="com.bloodbank.model.BloodDetailsModel"%>
<%@page import="com.bloodbank.Dao.BloodStackDAOlmpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table style="text-align: center;">
<tr>
<th><strong>Aadharcard</strong></th>
<th><strong> BLOODTYPE</strong></th>
  <th><strong> UNIT</strong></th>
  <th><strong>PRICE</strong></th>
   <th><strong>Date</strong></th>
  </tr>
  <%
  DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
  
  HttpSession htp=request.getSession();
 Donor donor=(Donor) htp.getAttribute("currentDonor");
       BookingModel book=(BookingModel) htp.getAttribute("bookingDate");
 
       
 BloodDetailsDAOlmpl Dao=new BloodDetailsDAOlmpl();
 
 List<BloodDetailsModel>  DetailsList=Dao.ShowBloodDetails(donor);
        

 for(int i=0;i<DetailsList.size();i++){
	
	 BloodDetailsModel details = DetailsList.get(i);
	 
	 %> 


   <tr>
   
   <td> <%= details.getDonor().getAdharcard() %></td>
    <td> <%= details.getDonor().getBloodType() %></td>
    <td> <%= details.getUnit()%></td>
     <td> <%= details.getPrice()%></td>
     <td> <%=book.getAppdate()%></td>
   
    
   </tr> 
   
   <% }%>
  

  
</table>
<a href="DonorLogoutServlet">logout</a>

</body>
</html>