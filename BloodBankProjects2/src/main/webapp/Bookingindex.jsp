<%@page import="com.bloodbank.model.Donor"%>
<%@page import="org.eclipse.jdt.internal.compiler.codegen.Label"%>
<%@page import="com.bloodbank.model.SeekerDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking index</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<style type="text/css">
*{
padding: 0;
margin: 0;
}


body{
 background-image: url("Images//002.jpg");
background-repeat: no-repeat;
background-size: cover;
height: 100vh;
display:flex;
justify-content: center;
    align-items: center;
}
.bookinner a {
    background: black;
    text-decoration: none;
    padding: 10px 20px;
    color: white;
    font-weight: bold;
        border-radius: 3px;
}
nav {
    margin-right: 20%;
}


</style>
</head>
<body>
<nav>
<div class="bookinner">
   <h1 class="text-center">BOOKING</h1>
<a href="Booking.jsp">BOOK</a>
<a href="ShowBooking.jsp">SHOW BOOKED</a>
</div>
</nav>


</body>
</html>