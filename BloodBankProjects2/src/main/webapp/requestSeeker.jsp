<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>



<body>


<h1 style="text-align: center;"> request</h1>
<form action="SeekerRequestServlet" method="post">
        <div id="login" style="text-align: center;">
            <label for="NAME">BLOOD COLLECTOR NAME:</label> &nbsp;
            <input type="text" id="NAME" name="NAME" required autofocus><br><br>            
             <label for="number">Aadhar card</label>
            <input type="text" id="number" name="number" required  pattern="[0-9]{12}"><br><br>
            <label for="PHONE">PHONE NUMBER</label>            
           <input type="TEXT" id="PHONE" name="PHONE" required="required" pattern="[0-9]{10}"><br><br>           
           <label for="HOSPITAL">HOSPITAL NAME</label>
           <input type="TEXT" id="HOSPITAL" name="HOSPITAL" required ><br> <br>
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
         <LABLE FOR=UNIT> BLOOD UNIT</LABLE>
          <input type="NUMBER" ID="UNIT" NAME ="UNIT" required><br><br>
            <button>Submit</button>&nbsp;&nbsp;&nbsp; &nbsp;
          
          <button type="reset">Reset</button>
           
           
        </div>

    </form>






















</body>
</html>