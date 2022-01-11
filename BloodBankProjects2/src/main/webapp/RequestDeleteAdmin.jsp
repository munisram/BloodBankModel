<%@page import="com.bloodbank.DaoImpl.RequestDAOlmpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><%


Long aadharcard=Long.parseLong(request.getParameter("Aadharcard"));

RequestDAOlmpl dao=new RequestDAOlmpl();
if(dao.deleteRequest(aadharcard)>0) {
				
	response.sendRedirect("RequestShowAndDeleteAdmin.jsp");


}

%>
</body>
</html>