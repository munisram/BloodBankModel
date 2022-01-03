<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h1> BOOKING</h1>

<form action="BloodBookingServlet" method="post" >


<div id="login" style="text-align: center;">
 <label for="address">Address:</label>&nbsp;
            <textarea id="address" name="address" maxlength="50" required ></textarea><br><br>
 <label for="BIO">BookingDate</label>            
           <input type="datetime-local" id="bookingDate" name="bookingDate" required="required"><br><br>   
<label for="unit">BloodCollectChoice</label>
           <input type="text" id="Choice" name="Choice" required ><br> <br>

    <label for="blood type">Blood Type:</label>
           <input list="blood type" id="bloodtype" name="bloodtype" required ><br><br>
           <datalist id="blood type" >
          <option value="A+">A+</option>
           <option value="A-">A-</option>
            <option value="B+">B+</option>
            <option value="B-">B-</option>
            <option value="AB+">AB+</option>
            <option value="AB-">AB-</option>
            <option value="O+">O+</option>
            <option value="O-">O-</option>
          </datalist> <br>
          </div>


<input type="submit" value="Register">


</from>





</body>
</html>