<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<h1 style="text-align: center;"></h1>
<form action="SeekerRigester" method="post">
        <div id="login" style="text-align: center;">
            <label for="name">First Name:</label> &nbsp;
            <input type="text" id="name" name="firstname" required autofocus><br><br>
            <label for="secondName"> lastName:</label>
            <input type="text" id="lastName" name="lastName" required><br><br>
              <label for="address">Address:</label>&nbsp;
            <textarea id="address" name="address" maxlength="50" required ></textarea><br><br>
            <label for="number">PhoneNumber</label>
            <input type="text" id="number" name="number" required  pattern="[0-9]{10}"><br><br>
            
             <label for="PASSWORD">PASSWORD</label>
             
            <input type="password" id="PASSWORD" name="PASSWORD" required ><br><br>
            <label for="BIO">PATIENT ID</label>            
           <input type="TEXT" id="PATIENT" name="PATIENT"><br><br>           
           <label for="HOSPITAL">HOSPITAL NAME</label>
           <input type="TEXT" id="HOSPITAL" name="HOSPITAL" required ><br> <br>
           
            <label for="blood type">Blood Type:</label>
           <input list="blood type" id="bloodtype" name="bloodtype" required ><br><br>
           <datalist id="blood type" >
          <option value="a+">A+</option>
           <option value="a-">A-</option>
            <option value="b+">B+</option>
            <option value="b-">B-</option>
            <option value="ab+">AB+</option>
            <option value="ab-">AB-</option>
            <option value="o+">O+</option>
            <option value="o-">O-</option>
          </datalist> <br>
          
          <button>Submit</button>&nbsp;&nbsp;&nbsp; &nbsp;
          
          <button type="reset">Reset</button>
           
           
        </div>

    </form>


</body>
</html>