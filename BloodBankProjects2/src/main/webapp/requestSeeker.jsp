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
         <label for="Date">Date</label>            
           <input type="date" id="Date" name="Date" required="required"><br><br>  
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
         <LABLE FOR=UNIT> BLOOD UNIT</LABLE>
          <input type="NUMBER" ID="UNIT" NAME ="UNIT" required><br><br>
            <button type="submit">Submit</button>&nbsp;&nbsp;&nbsp; &nbsp;
          
          <button type="reset">Reset</button>
           
           
        </div>

    </form>
</body>


<script type="text/javascript">
today();
function today(){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();
    var max = today.setMonth( today.getMonth() + 1 );
maxdate = today.getFullYear() + '-' + 0+(today.getMonth() + 1) + '-'+ 0+today.getDate()  ;
mindate =yyyy + '-' + mm + '-'+ dd  ;
document.getElementById("Date").setAttribute("max",maxdate);
console.log(maxdate);
console.log(mindate);
document.getElementById("Date").setAttribute("min",mindate);
} 
</script>

</html>