<!DOCTYPE html>
<html>

<head>
	<title>Page Title</title>
	<style>
.backimage {
	height: 713px;
	margin-top:-30px;
	width: 100%;
	background-size: cover;
	background-image:
		url(  
    "https://images.pexels.com/photos/841130/pexels-photo-841130.jpeg?cs=srgb&dl=pexels-victor-freitas-841130.jpg&fm=jpg");
}

body {
	display: flex;
	align-items: center;
	justify-content: center;
	font-family: Arial, sans-serif;
	line-height: 1.8;
	min-height: 100vh;
	background: #ffffff;
	flex-direction: column;
}

/* Main container styling */
.main {
	margin-left: 420px;
	margin-top: 150px;
	background-color: #fff;
	border-radius: 15px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
	padding: 20px;
	transition: transform 0.2s;
	width: 600px;
}

form {
	align-content: center;
	justify-content: center;
	text-align: center;
}

h1 {
	text-align: center;
	color: green;
}

input {
	padding: 10px;
	width: 70px;
}

label {
	text-align: left;
	padding-left: 5px;
}

a {
	padding-left: 280px;
}

select {
	width: 70px;
}

.sidenav {
	height: 700px;
	width: 0;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	transition: 0.5s;
	padding-top: 60px;
}

.sidenav a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 20px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

.sidenav a:hover {
	color: #f1f1f1;
}

.sidenav .closebtn {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 36px;
	margin-left: 50px;
}

.sidepane {
	margin: 0px;
	font-size: 30px;
	padding: 0px;
	cursor: pointer;
	color: white;
}

.option {
	width: 50px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}
</style>
</head>

<body>

<%
int id = (int) session.getAttribute("batchid");
%>
<div class="backimage">
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="addBatchInfo.jsp">Add Batch</a>
  <a href="addParticipantInfo.jsp">Add Participants</a>
  <a href="BatchController">View Batch info </a>
  <a href="ViewParticipantController">View Participant Info</a>
</div>

<div class="sidepane" onclick="openNav()">&#9776;</div>
	<div class="main">
		<h1>Edit Batch Details</h1>

		
<form action="EditBatchController" method="post">
<label>BatchId</label>&nbsp;&nbsp;&nbsp;
<input type="number" name="batchid" min=1 value = <%=id %>><br/><br>
<label>Batch type</label>
<input type="radio" name="typeofbatch" value="AM" required="required">Morning
<input type="radio" name="typeofbatch" value="PM" required="required">Evening<br/><br>
<label>Time</label>
<select name="time" required="required">
   <option></option>
	<option value="7am">7am</option>
	<option value="8am">8am</option>
	<option value="9am">9am</option>
	<option value="7pm">7pm</option>
	<option value="8pm">8pm</option>
	<option value="9pm">9pm</option>
</select><br/><br>
<input type="submit" value="Submit"/>&nbsp;&nbsp;&nbsp;
<input type="reset" value="Reset"/>
</form>
<br/>
<a href="index.html">Back</a>

	</div>
	</div>
	
	<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}


</script>
</body>

</html>
