<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="SeekerLoginServlet" method="post" style="text-align: center;">
<div>




                  <label for="PASSWORD">PHONE NUMBER</label>

      <input type="text" id="number" name="number" required  pattern="[0-9]{10}"><br><br>
            
             <label for="PASSWORD">PASSWORD</label>
             
            <input type="password" id="PASSWORD" name="PASSWORD" required ><br><br>


  <button>Submit</button>&nbsp;&nbsp;&nbsp; &nbsp;
          
          <button ><a href="Seeker.jsp">Register</a></button>



</div>





</form>

</body>
</html>