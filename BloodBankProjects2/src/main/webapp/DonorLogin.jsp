<%@page import="com.bloodbank.DaoImpl.DonorDAOImpl"%>
<%@page import="com.bloodbank.model.Donor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donor Login</title>

<style>
a{
	text-decoration:none
}
p {
    margin-bottom: 0px;
}
.loginForm form h1 {
    margin: 0px 0px 20px;
    color: white;
}
.loginForm form {
    text-align: center;
    padding: 25px;
}
    label{
        width: 130px;
        display: inline-block;
    }
    body {
    background-image: url(Images/background.jpg);
    background-repeat: no-repeat;
    background-size: cover;
    background-position: bottom;
    margin:0px;
}
    .loginForm form {
    text-align: center;
}
    .loginForm {
    width: 50%;
    padding: 0px;
    margin: auto;
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: end;
}
.formcontrol input {
    border: none;
    padding: 10px;
    background: #ffffff;
    border-radius: 3px;
    color: black;
    font-weight: bold;
    box-shadow: 0px 0px 8px 0px #d1d1d1;
}
.formbtn button, .formbtn input {
    border: none;
    padding: 10px;
    text-decoration: none;
}
.formbtn button a {
    color: white;
}
.formbtn button, .formbtn input {
    border: none;
    padding: 10px;
    text-decoration: none;
    background: black;
    color: white;
    border-radius: 3px;
    padding: 10px 20px;
    font-weight: bold;
    box-shadow: 0px 0px 3px 0px #606060;
}
.formbtn {
    display: flex;
    justify-content: center;
}

.formcard {
    display: flex;
    background: linear-gradient(
41deg
, #ffffff 50%, #000000 48%);
    padding: 15px;
    border-radius: 9px;
}

.cardimg {
    width: 50%;
}
.cardimg img {
    width: 100%;
}
.cardContent {
    background: linear-gradient(
141deg
, black 50%, white 50%);
    padding: 30px;
    border-radius: 6px;
}
</style>
</head>
<body>
<div class="loginForm">

<div class="cardContent">
	<form action="login" method="post">
<h1 >login</h1>
  <div class="formcontrol" >
  <input type="text" id="aadharcard" name="aadharcard"  autofocus required="required" pattern="[0-9]{12}" placeholder="Aadharcard Number" title="enter the valid Aadharcard number"><br><br>
  
</div> 

<div  class="formbtn">
	<input type="submit" value="login">
	
 </div>
    <%
    
 String error=(String) session.getAttribute("DonorError");
    
    if(error!=null){%>
    	
    	<p class="text-primary"> <%= error%></p>
    	<%session.setAttribute("DonorError", null); %>
    	
   <%}%>
</form>
</div>
</div>

</body>
</html>