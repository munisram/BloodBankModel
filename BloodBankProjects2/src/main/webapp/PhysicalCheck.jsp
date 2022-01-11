<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

a{
	text-decoration:none
}
.loginForm form h1 {
    margin: 0px 0px 20px;
    color: white;
}
.loginForm form {
    text-align: center;
    padding: 25px;
}
    label{
        width: 130px;
        display: inline-block;
    }
    body {
    background-image: url(Images/background.jpg);
    background-repeat: no-repeat;
    background-size: cover;
    background-position: bottom;
    margin:0px;
}
    .loginForm form {
    text-align: center;
}
    .loginForm {
    width: 58%;
    padding: 0px;
    margin: auto;
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: end;
}
.formcontrol input {
    border: none;
    width:90%;
    padding: 10px;
    background: #ffffff;
    border-radius: 3px;
    color: black;
    font-weight: bold;
    box-shadow: 0px 0px 8px 0px #d1d1d1;
    margin-bottom: 10px;
}
.formbtn button, .formbtn input {
    border: none;
    padding: 10px;
    text-decoration: none;
}
.formbtn button a {
    color: white;
}
.formbtn button, .formbtn input {
    border: none;
    padding: 10px;
    text-decoration: none;
    background: black;
    color: white;
    border-radius: 3px;
        margin-right: 5px;
    padding: 10px 20px;
    font-weight: bold;
    box-shadow: 0px 0px 3px 0px #606060;
}
.formbtn {
    display: flex;
    justify-content: space-between;
}
p {
    margin-bottom: 0px;
}
.formcard {
    display: flex;
    background: linear-gradient(
41deg
, #ffffff 50%, #000000 48%);
    padding: 15px;
    border-radius: 9px;
}

.cardimg {
    width: 50%;
}
.cardimg img {
    width: 100%;
}
.cardContent {
    background: linear-gradient( 
141deg
 , black 50%, white 50%);
    padding: 11Spx;
    border-radius: 6px;
    width: 50%;
}



</style>
</head>

<body>
<div class="loginForm">
<div class="cardContent">

<form action="CheckDonorServlet"  style="text-align: center;" method="post">


<h1>PHYSICAL CHECK</h1>
<div class="formcontrol" >
<input type="text " id="Height" name="Height" required="required" autofocus="autofocus" pattern="[0-9]{2,}" placeholder="Height" title="it should be in number"><br><br>
 </div><div class="formcontrol" >

<input type="text " id="weight" name="weight" required="required" pattern="[0-9]{2,}" placeholder="weight" title="it should be in number"><br><br>
<div class="formcontrol" >
<input type="text " id="temperature" name="temperature" required="required" pattern="[0-9]{2,}" placeholder="Temperature" title="it should be in number"><br><br>
 </div><div class="formcontrol" >
<!-- <label for="health">To you have any health isssue</label><br><br>
<input type=radio  value="yes" name="health" required="required">yes
<input type="radio"   value="no" name="health" required="required"  >no<br><br> -->

 </div><div class="formcontrol" >
<input type="text " id="pressure" name="pressure" required="required" pattern="[0-9]{2,}" placeholder="blood pressure" title="it should be in number"><br><br>
 </div><div class="formcontrol" >
<input type="text " id="pulse" name="pulse" required="required" pattern="[0-9]{2,}" placeholder="pulse" title="it should be in number"><br><br>
 
  </div>
  <div  class="formbtn">
  <input id="submit"type="submit" >&nbsp;&nbsp;&nbsp; &nbsp; 


<input id="reset"type="reset">
</div>
</form>
</div>
</div>
</body>
</html>