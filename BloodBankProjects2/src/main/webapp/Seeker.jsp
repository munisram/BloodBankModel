<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#Rigester{
border: 1px solid black;
width: 400px;
position: absolute;
left: 35%;
top:9%;
background-color: teal;
color:white;
padding:20px;
}
textarea {
   resize:none;
   border-radius: 5px;
	width: 200px;
	height: 40px;
}
</style>
</head>
<body>


<div id="Rigester">

<h1 style="text-align: center;">RIGESTER</h1>
<form action="SeekerRigester" method="post">

        <div id="login" style="text-align: center;">
           
            <input type="text" id="name" name="firstname" required autofocus placeholder="First Name" pattern="[A-Za-z]{3,}" title="mininum 3 character"><br><br>
        
            <input type="text" id="lastName" name="lastName" required  placeholder="lastName" pattern="[A-Za-z]{3,}"title="mininum 3 character"><br><br>
         
            <textarea id="address" name="address" maxlength="50" required placeholder="Address"></textarea><br><br>
            
            <input type="text" id="number" name="number" required  pattern="[0-9]{10}" placeholder="PhoneNumber" title=" mininum 10characters"><br><br>
            
                         
            <input type="password" id="PASSWORD" name="PASSWORD" required placeholder="PASSWORD"  pattern="[0-9A-Za-Z@#$%&*_?/]{8,15}" title=" mininum 8characters may includes @#$%&*_?/ "><br><br>
            
                       
           <input type="TEXT" id="PATIENT" name="PATIENT" placeholder="PATIENT ID"pattern="[0-9A-Za-z]{5,}" ><br><br>   
                   
           
           <input type="TEXT" id="HOSPITAL" name="HOSPITAL" required placeholder="HOSPITAL NAME" pattern="[A-Za-z]{5,}"title="mininum 3 character"><br> <br>
           
            
           <input list="blood type" id="bloodtype" name="bloodtype" required placeholder="Blood Type" ><br><br>
           <datalist id="blood type" >
          <option value="a+">a+</option>
           <option value="a-">a-</option>
            <option value="b+">b+</option>
            <option value="b-">b-</option>
            <option value="ab+">ab+</option>
            <option value="ab-">ab-</option>
            <option value="o+">o+</option>
            <option value="o-">o-</option>
          </datalist> <br>
          
          <button>Submit</button>&nbsp;&nbsp;&nbsp; &nbsp;
          
          <button type="reset">Reset</button>
           <div>
           <%
           String error=(String) session.getAttribute("phoneNumber");
           if(error!=null){
           
           %>
          
           <p class="text-primary"> <%= error%></p>
           <%session.setAttribute("phoneNumber", null); %>
           <%} %>
          
           </div>
           
        </div>

    </form>
</div>

</body>
</html>