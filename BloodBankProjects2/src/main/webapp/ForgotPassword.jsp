<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
</head>

<style>
a{
	text-decoration:none
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
    width: 65%;
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
    margin-bottom: 10px;
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
     margin-left: 107px;
    padding: 10px 20px;
    font-weight: bold;
    box-shadow: 0px 0px 3px 0px #606060;
}
.formbtn {
    display: flex;
    justify-content: space-between;
}
p {
    margin-bottom: 0px;
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
    padding: 11Spx;
    border-radius: 6px;
}
</style>
<body>
<div class="loginForm">
<div class="cardContent">





<form action="ForgetPasswordServlet" method="post">
<h1>FORGET PASSWORD</h1>

<div class="formcontrol" >
  <input type="password" id="PASSWORD" name="PASSWORD" required placeholder="PASSWORD" pattern="[0-9A-Za-Z@#$%&*_?/]{8,15}" title=" mininum 8characters may includes @#$%&*_?/ " >
     </div><div class="formcontrol" >
  <input type="password" id="PASSWORD" name="CONFIRMPASSWORD" required placeholder="CONFIRM PASSWORD" pattern="[0-9A-Za-Z@#$%&*_?/]{8,15}" title=" mininum 8characters may includes @#$%&*_?/ " >
     <%
         String error=(String)session.getAttribute("PasswordError");
     if(error!=null){
    	  %>
    	 <p><%=error  %></p>
    	 
    	 <%session.setAttribute("PasswordError", null) ;%>
     <%} %>
     </div>
    <div  class="formbtn">
  <button type="submit">submit</button>
</div>
</form>
</div>
</div>
</body>
</html>