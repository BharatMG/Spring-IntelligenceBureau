<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
<%@include file="nav.jsp"%>
<h1>Reading All Data</h1>
<form action="read" method="get">
<input type="submit">
<div style="text-align: center;">
		<h1 class="text-center">Registration form</h1>
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th>officerName</th>
					<th>designation</th>
					<th>gender</th>
					<th>email</th>
					<th>mobileNumber</th>
					<th>isMarried</th>
					<th>permanentAddress</th>
					<th>workingAddress</th>
					<th>basicPayScale</th>
				</tr>
				<c:forEach items="${dtos}" var="dto">
				<tr>
					<td>${dto.officerName}</td>
				 	<td>${dto.designation}</td>
					<td>${dto.gender}</td>
					<td>${dto.email}</td>
					<td>${dto.mobileNumber}</td>
					<td>${dto.isMarried}</td>
					<td>${dto.permanentAddress}</td>
					<td>${dto.workingAddress}</td>
					<td>${dto.basicPayScale}</td> 
				</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
</form>
 <%@include file="footer.jsp"%>
</body>
</html>