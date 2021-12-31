<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
    label{
        width: 130px;
        display: inline-block;
    }
</style>
</head>
<body>
<h1 style="text-align: center;">Register</h1>

<form action="Register" method="post">
        <div id="login" style="text-align: center;">
            <label for="name">First Name:</label> &nbsp;
            <input type="text" id="name" name="firstname" required autofocus><br><br>
            <label for="secondName"> lastName:</label>
            <input type="text" id="lastName" name="lastName" required><br><br>
            <label for="email">Email:</label>&nbsp;&nbsp;
            <input type="email" id="email" name="email" required><br><br>
            <label for="address">Address:</label>&nbsp;
            <textarea id="address" name="address" maxlength="50" required ></textarea><br><br>
            <label for="number">PhoneNumber</label>
            <input type="text" id="number" name="number" required  pattern="[0-9]{10}"><br><br>
            <label for="age">age</label>            
           <input type="datetime-local" id="bio" name="bio"><br><br>           
           <label for="password">ADHARCARD</label>
           <input type="password" id="password" name="password" required ><br> <br>
            <label for="blood type">Blood Type:</label>
           <input list="blood type" id="bloodtype" name="blood type" required ><br><br>
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
          <button>Submit</button>&nbsp;&nbsp;&nbsp; &nbsp;
          <button type="reset">Reset</button>
           
           
        </div>

    </form>

</body>
</html>