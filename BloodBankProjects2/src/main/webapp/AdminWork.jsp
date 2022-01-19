<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminWork</title>

<style>
body {
    height: 100vh;
    margin: 0px;
    display: flex;
    justify-content: center;
    align-items: center;
}
.adminCard {
    padding: 25px;
    background: linear-gradient( 
40deg
 , #e90a0a 41%, white 9%);
    box-shadow: 0px 0px 6px 0px black;
    color: white;
    margin: 50px;
    display: flex;
        width: 100%;
}
.adminCard a {
    text-decoration: none;
    color: black;
    font-weight: bold;
    background: white;
    padding: 10px 20px;
}
.adminImage img {
    width: 100%;
}
.adminImage {
    width: 75%;
}

.content {
    width: 25%;
    box-shadow: -3px 3px 8px 0px #d9d9d9;
    border-radius: 4px;
}
.content h1 {
    margin: 0px;
    color: white;
    text-align: center;
    font-weight: bold;
    background: #e90a0a;
    padding: 10px;
    border-radius: 4px;
}
.content a {
    display: block;
    margin: 27px 10px;
    color: black;
    font-weight: bold;
    font-size: 16px;
    /* border-bottom: 2px solid; */
    border-radius: 19px;
    box-shadow: 0px 0px 12px 0px #ededed;
}
.backBtn a {
        text-decoration: none;
    color: white;
    background: black;
    padding: 5px 10px;
    border-radius: 3px
}

.backBtn {
    float: right;
       margin-top: 440px;
    font-size: 15px;
    
    padding: 5px 0px;
}
</style>
</head>
<body>

<div class="adminCard">
<div class="adminImage">
	<img src="Images/004.png">
</div>
<div class="content">

<h1 style="text-align: center;">Admin Work</h1>
	<a href="ShowStock.jsp"> ShowStock</a>
	<a href="ShowbillingAdmin.jsp"> ShowBilling</a>
	<a href="ShowRequest.jsp"> ShowRequest </a>
	<a href="AdminShowBooking.jsp">Booking</a>
</div>
<div class="backBtn">
<a href="AdminLogin.jsp">back</a>
</div>
</div>

</body>
</html>