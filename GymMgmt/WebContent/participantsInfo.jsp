<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.gymmgmt.bean.Participants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	display: flex;
	align-items: center;
	justify-content: center;
	font-family: Arial, sans-serif;
	line-height: 1.8;
	background: #ffffff;
	flex-direction: column;
	color: white;
}

.backimage {
	margin-top: -30px;
	height: 740px;
	width: 100%;
	background-size: cover;
	background-image:
		url(  
    "https://images.pexels.com/photos/841130/pexels-photo-841130.jpeg?cs=srgb&dl=pexels-victor-freitas-841130.jpg&fm=jpg");
}

h1 {
	text-align: center;
	color: white;
}

.sidenav {
	height: 90.5%;
	position: fixed;
	width: 0;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	transition: 0.5s;
	padding-top: 60px;
	margin-top: 0px;
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
	margin-top: 20px;
	margin-left: 10px; 
	padding: 0px;
	cursor: pointer;
	color: white;
	font-size: 30px;
}

.option {
	width: 50px;
}

.table {
	margin-left: 430px;
	width: 700px;
	text-align: center;
	table-layout: auto;
	border: medium;
	background-color: black;
}

.action {
	width: 5px;
}

.backlink {
	padding-left: 730px;
	color: white;
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
	<div class="backimage">
		<div id="mySidenav" class="sidenav">
			<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			<a href="addBatchInfo.jsp">Add Batch</a> <a
				href="addParticipantInfo.jsp">Add Participants</a> <a
				href="BatchController">View Batch info </a> <a
				href="ViewParticipantController">View Participant Info</a>
		</div>

		<div class="sidepane" onclick="openNav()">&#9776;</div>
		<h1>Participant Details</h1>
		<table border="1" class="table table-stripped">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>Phone</th>
				<th>Batch ID</th>
				<th colspan="2">Action</th>
			</tr>

			<%
			Object obj = session.getAttribute("listParticipants");
			List<Participants> list = (List<Participants>) obj;
			Iterator<Participants> li = list.iterator();
			while (li.hasNext()) {
				Participants participant = li.next();
			%>
			<tr>
				<td><%=participant.getParticipantId()%></td>
				<td><%=participant.getParticipantName()%></td>
				<td><%=participant.getParticipantId()%></td>
				<td><%=participant.getPhoneNumber()%></td>
				<td><%=participant.getBatchid()%></td>
				<td><a
					href="EditParticipantController?id=<%=participant.getParticipantId()%>"><button>Edit</button></a>
					| <a
					href="DeleteParticipantController?id=<%=participant.getParticipantId()%>"><button>Delete</button></a></td>

			</tr>
			<%
			}
			%>
		</table>
		<br /> <a class="backlink" href="index.html">Back</a>
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