<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width-device-width,initial-scale=1">
<title>Inteligence-Bureau</title>
<style>
table,th,td{
    text-align:center;
}
</style>
</head>
<body style="text-align:center;">
<div style="text-align:center;">
	<table border="5">
		<tbody>
		<h1 style="text-align:center;">Registration form</h1>
			<tr>
				<th>Id</th>
				<th>officerName</th>
				<th>designation</th>
				<th>gender</th>
				<th>email</th>
				<th>mobileNumber</th>
				<th>isMarried</th>
				<th>permanentrAddress</th>
				<th>workingAddress</th>
				<th>basicPayScale</th>
			</tr>
			<tr>
				<td><h1>${dto.id}</h1></td>
				<td>${dto.officerName}</td>
				<td>${dto.designation}</td>
				<td>${dto.gender}</td>
				<td>${dto.email}</td>
				<td>${dto.mobileNumber}</td>
				<td>${dto.isMarried}</td>
				<td>${dto.permanentrAddress}</td>
				<td>${dto.workingAddress}</td>
				<td>${dto.basicPayScale}</td>
			</tr>
		</tbody>
	</table>
	</div>
	<hr>
	<a href="index.jsp" color:red>Back</a>
</body>
</html>