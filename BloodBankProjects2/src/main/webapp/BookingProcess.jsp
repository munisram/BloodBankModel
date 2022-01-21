<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Process</title>



<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

.problem {
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

nav.header {
	background: #160101;
	width: 100%;
}

body {
	background-image: url("Images//002.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

.bookinner a, input {
	background: black;
	text-decoration: none;
	padding: 10px 20px;
	color: white;
	font-weight: bold;
	border-radius: 3px;
}

nav {
	margin-right: 20%;
}

.submitBtn {
	position: relative;
	bottom: 16px;
	width: 177px;
	height: 42px;
	padding: 5px;
}
</style>
</head>
<body>

	<nav class="header seakerindex">
		<h1 style="text-align: left;">BLOOD BANK</h1>
		<ul>
			
			<li><a href="SeekerIndex.jsp">Seeker</a></li>
			<li><a href="LogoutDonor.jsp">Logout</a></li>
		</ul>
	</nav>
	<div class="problem">
		<nav>
			<div class="bookinner">
				<form action=" ConfirmServlet" method="post">


					<input class="submitBtn" type="submit" value="confirm">

				</form>

				<a class="BookingChange" href="BookingCancel.jsp">BOOKING CANCEL</a>

			</div>
		</nav>
	</div>

</body>
</html>