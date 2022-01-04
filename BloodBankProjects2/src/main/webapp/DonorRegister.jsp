<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
    label{
        width: 130px;
        display: inline-block;
    }
</style>

<body>
<h1 style="text-align: center;">Register</h1>

<form action="Register" method="post">
        <div id="login" style="text-align: center;">
            <label for="name">First Name:</label> &nbsp;
            <input type="text" id="name" name="firstname" required autofocus><br><br>
            <label for="lastName"> lastName:</label>
            <input type="text" id="lastName" name="lastName" required><br><br>
            <label for="email">Email:</label>&nbsp;&nbsp;
            <input type="email" id="email" name="email" required><br><br>
            <label for="address">Address:</label>&nbsp;
            <textarea id="address" name="address" maxlength="50" required ></textarea><br><br>
            <label for="number">PhoneNumber</label>
            <input type="text" id="number" name="number" required  pattern="[0-9]{10}"><br><br>
            <label for="BIO">BIO</label>            
           <input type="date" id="bio" name="bio"><br><br>           
           <label for="password">ADHARCARD</label>
           <input type="text" id="ADHARCARD" name="ADHARCARD" required pattern="[0-9]{12}" ><br> <br>
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
document.getElementById("bio").setAttribute("max",maxdate);
console.log(maxdate);
console.log(mindate);
document.getElementById("bio").setAttribute("min",mindate);
} 
</script>
</html>