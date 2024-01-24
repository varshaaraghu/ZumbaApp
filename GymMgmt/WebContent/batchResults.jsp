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

	<jsp:include page="addBatchInfo.jsp" />
	<%
	PrintWriter pw = response.getWriter();

	int result = (int) session.getAttribute("result");

	pw.println("<script type=\"text/javascript\">");
	if (result == 1) {
		pw.println("alert('Batch details stored.');");
	} else if (result == 2) {
		pw.println("alert('Batch Time and Id exists.');");
	} else if (result == 3) {
		pw.println("alert('Batch Time already exists');");
	} else if(result == 4){
		pw.println("alert('Batch Id already exists');");
	}else{
		pw.println("alert('Failed to store the batch details.Try later...');");
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