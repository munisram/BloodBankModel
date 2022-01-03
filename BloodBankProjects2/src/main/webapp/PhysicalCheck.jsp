<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>

<body>
<form action="CheckDonorServlet"   style="text-align: center;" method="post">
<h1>PHYSICAL CHECK</h1>
<div>
<label for="Height">Height</label>

<input type="text " id="Height" name="Height" required="required" autofocus="autofocus" pattern="[0-9]{2,}"><br><br>

<label for="weight">weight</label>
<input type="text " id="weight" name="weight" required="required" pattern="[0-9]{2,}" ><br><br>
<label for="temperature"> Temperature</label>
<input type="text " id="temperature" name="temperature" required="required" pattern="[0-9]{2,}" ><br><br>
<label for="health">To you have any health isssue</label><br><br>
<input type=radio  id="yes" name="health" required="required">yes
<input type="radio"  id="no" name="health" required="required"  >no<br><br>

<label for="weight">blood pressure</label>
<input type="text " id="pressure" name="pressure" required="required" pattern="[0-9]{2,}" ><br><br>
<label for="weight">pulse</label>
<input type="text " id="pulse" name="pulse" required="required" pattern="[0-9]{2,}" ><br><br>
<input type="submit" >&nbsp;&nbsp;&nbsp; &nbsp; 
<input type="reset">
</div>
</form>
</body>
</html>