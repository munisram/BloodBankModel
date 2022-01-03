<%@page import="com.bloodbank.Dao.DonorDAOImpl"%>
<%@page import="com.bloodbank.model.Donor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>welcome</h1>


<body>
<style>
    label{
        width: 130px;
        display: inline-block;
    }

</style>
</head>

<h1 style="text-align: center;">login</h1>
<form action="Login" method="post">

  <div style="text-align: center;">
  <label for="adharcard">ADHARCARD</label>
  <input type="text" id="adharcard" name="adharcard"  autofocus required="required" pattern="[0-9]{12}" ><br><br>
    <button>login</button>&nbsp; &nbsp;  
    
   
    
      <button ><a href="DonorRegister.jsp">Register</a></button>

</div>
</form>

</body>
</html>