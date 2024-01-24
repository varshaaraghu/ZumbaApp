
<%@page import="java.util.Iterator"%>
<%@page import="com.gymmgmt.bean.Batch"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<title>Page Title</title>
	<style>
	
	.backimage {  
	margin-top:-30px;
    height: 713px; 
    width: 100%; 
    background-size: cover;  
    background-image: url(  
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
				margin-left:420px;
				margin-top:100px;
		
			background-color: #fff;
			border-radius: 15px;
			box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
			padding: 0px;
			transition: transform 0.2s;
			width: 700px;
			
		}

		form{
		align-content :center;
		justify-content: center;
		text-align: center;
		}
		h1 {
			text-align: center;
			color: green;
			padding-top: 15px;
		}

		input {
			padding: 10px;
			width: 70px;
			margin-top: 20px;
		}
		
		label{
			text-align: left;
			padding-left: 5px;
			margin-left: 20px;
			padding-top:10px;
		}
		
		a{
		padding-left: 325px;
		}
		
		select {
		width: 70px;
		}
		
		
		
		.sidenav {
  height: 100%;
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
		
		.sidepane{
 	margin:0px;
  	font-size: 30px;
	padding: 0px; 
	cursor: pointer;
	color: white;
}

.option{
width: 50px;
}
@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
	</style>
</head>

<body>
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
<h1>Add Participant Details</h1>
<form action="ParticipantsController" method="post"  class="form-group">
<input type="hidden" name="operation" value="add"><br/>
<label>Participant Name</label> &nbsp;&nbsp;&nbsp;
<input type="text" name="pname" class="form=control" required="required"><br/>
<label>Age</label> &nbsp;&nbsp;&nbsp;
<input type="number" name="age" min=15 class="form=control" required="required"><br/>
<label>PhoneNumber</label> &nbsp;&nbsp;&nbsp;
<input type="tel" id="phone" name="phonenumber" class="form=control" pattern="[0-9]{4}[0-9]{2}[0-9]{3}" required="required"><br/><br>
<select name="batchid" required="required">
<option>-- Batch --</option>
<%
Object obj = session.getAttribute("listOfBatch");
List<Batch> listOfBatch = (List<Batch>)obj;
Iterator<Batch> li = listOfBatch.iterator();
while(li.hasNext()){
	Batch bb = li.next();
	%>
	<option value="<%=bb.getBatchid()%>"><%=bb.getBatchid() %>(<%=bb.getTime()%>)</option>
	<%
}
%>
</select><br/><br>
<input type="submit" value="Submit" class="btn btn-success"/> &nbsp;&nbsp;&nbsp;
<input type="reset" value="Reset" class="btn btn-info"/>
</form>
<br>
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
