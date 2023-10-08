<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width-device-width,initial-scale=1">
<title>Inteligence-Bureau</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<style>
table, th, td {
	text-align: center;
}
</style>
</head>
<body style="text-align: center;">
<%@include file="nav.jsp"%>
	<div style="text-align: center;">
		<h1 class="text-center">Registration form</h1>
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th>officerName</th>
					<th>designation</th>
					<th>gender</th>
					<th>joiningDate</th>
					<th>email</th>
					<th>mobileNumber</th>
					<th>isMarried</th>
					<th>permanentAddress</th>
					<th>workingAddress</th>
					<th>basicPayScale</th>
				</tr>
				<tr>
					<td>${dto.officerName}</td>
					<td>${dto.designation}</td>
					<td>${dto.gender}</td>
					<td>${dto.joiningDate}</td>
					<td>${dto.email}</td>
					<td>${dto.mobileNumber}</td>
					<td>${dto.isMarried}</td>
					<td>${dto.permanentAddress}</td>
					<td>${dto.workingAddress}</td>
					<td>${dto.basicPayScale}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<hr>
	<%@include file="footer.jsp"%>
</body>
</html>