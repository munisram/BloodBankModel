<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BookingChangeServlet" method="post" >


<div id="login" style="text-align: center;">
 <label for="address">Address:</label>&nbsp;
            <textarea id="address" name="address" maxlength="50" required ></textarea><br><br>
 <label for="BIO">BookingDate</label>            
           <input type="date" id="bookingDate" name="bookingDate" required="required"><br><br>   
<label for="unit">BloodCollecterChoice</label>
           <input type="text" id="Choice" name="Choice" required ><br> <br>
     <input type="submit" value="submit">


</from>
<script type="text/javascript">
today();
function today(){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); 
    var yyyy = today.getFullYear();
    var max = today.setMonth( today.getMonth() + 1 );
maxdate = today.getFullYear() + '-' + 0+(today.getMonth() + 1) + '-'+ 0+today.getDate()  ;
mindate =yyyy + '-' + mm + '-'+ dd  ;
document.getElementById("bookingDate").setAttribute("max",maxdate);
console.log(maxdate);
console.log(mindate);
document.getElementById("bookingDate").setAttribute("min",mindate);
} 
</script>
</body>
</html>