<%@page import="java.util.List"%>
<%@page import="com.bloodbank.Dao.BillingDAOlmpl"%>
<%@page import="com.bloodbank.model.BillingModel"%>
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
<th><strong>BLOODTYPE</strong></th>
<th><strong>SEEKER NAME</strong></th>
<th><strong>SEEKER PHONENUMBER</strong></th>
<th><strong>QUANTITY</strong></th>
<th><strong>PRICE</strong></th>
</tr>
<%

HttpSession htp=request.getSession();
BillingModel  billingModel=null;
    billingModel  =(BillingModel)htp.getAttribute("biilingProces");

BillingDAOlmpl Dao=new BillingDAOlmpl();

List<BillingModel> billingList= Dao.biilingShow(billingModel);

for(int i=0;i<billingList.size();i++){
	
	billingModel=billingList.get(i);
	
	%>
	
	<tr>
	<td> <%=billingModel.getBloodType()%></td> 
	<td> <%=billingModel.getSeeker().getFirstName()%></td>
	<td> <%=billingModel.getSeeker().getPhoneNumber()%></td>
	<td> <%=billingModel.getUnit()%></td>
	<td> <%=billingModel.getTotalprice()%></td>
<%} %>



<a href="SeekerLogoutServlet">logout</a>






</table>





</body>
</html>