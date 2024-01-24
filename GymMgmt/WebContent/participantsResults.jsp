<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import=" java.io.PrintWriter"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="addParticipantInfo.jsp" />
	<%
	PrintWriter pw = response.getWriter();

	int result = (int) session.getAttribute("result");

	pw.println("<script type=\"text/javascript\">");
	if (result == 1) {
		pw.println("alert('Participants details stored successfully.');");
	} else if (result == 2) {
		pw.println("alert('Participant with same info already exists in the batch.');");
	} else if (result == 3) {
		pw.println("alert('Total number of students in a batch exceeded.');");
	} else if(result == 4){
		pw.println("alert('Participants details updated successfully.');");
	}else if(result == 5){
		pw.println("alert('Failed to update Participant details.Try later...');");
	}else {
		pw.println("alert('Failed to store Participant details.Try later...');");
	}
	pw.println("</script>");
	%>

	<script>
		function alertFunction() {
			alert("Stored Successfully");
		}
	</script>
</body>
</html>