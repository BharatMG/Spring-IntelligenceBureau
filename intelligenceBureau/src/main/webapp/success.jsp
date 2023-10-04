<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width-device-width,initial-scale=1">
<title>Inteligence-Bureau</title>
<style>
table, th, td {
	text-align: center;
}
</style>
</head>
<body style="text-align: center;">
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
			</tbody>
		</table>
	</div>
	<hr>
</body>
</html>