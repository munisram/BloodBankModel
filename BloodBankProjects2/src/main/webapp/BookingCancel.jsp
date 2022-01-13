<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking cancel</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<style type="text/css">





.book{

    height: 100vh;
    justify-content: center;

}
.book form h2 {
    margin: 0px 0px 10px;
    color: white;
}
.book form {
    text-align: center;
    padding: 25px;
}
.inputtype input{


 border: none;
    padding: 10px;
    background: #ffffff;
    border-radius: 3px;
    color: black;
    font-weight: bold;
    box-shadow: 0px 0px 8px 0px #d1d1d1;
    margin-bottom: 10px;
}

.submit button, .submit input {
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
   



   .bookinner {
  background: linear-gradient( 
160deg
 , black 50%, white 50%);
    padding: 11Spx;
    border-radius: 6px;
}
body {
    background-image: url(Images/background.jpg);
    background-repeat: no-repeat;
    background-size: cover;
    background-position: bottom;
    margin:0px;
}
</style>
</head>
<body>
<div class="d-flex book align-items-center">
<div class="col-sm-4"></div>
<div class="bookinner col-sm-4">

<form action="BookingCancelServlet" method="post" >


<h2 >BOOKING CANCEL</h2>
<div class="inputtype">
<input type="text" id="aadharcard" name="aadharcard" required="required" placeholder="Aadharcard">
</div>
 <div class="submit">
<input type="submit" value="cancel">
</div>
</form>




</div>

</div>
</body>
</html>