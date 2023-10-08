<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<form action="getId" method="get">
<div class="text-center">
<input type="search" placeholder="search" name="id">
<div>
<input type="submit">
</div>
<h1 class="text-center">Search by Id</h1>
		<table class="table table-bordered">
			<tbody>
				<tr>
				<th>id</th>
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
					<th>Action</th>
				</tr>
				<tr>
				<td>${dto.id}</td>
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
				<td><a href="registration.jsp" class="btn btn-sm btn-primary">update</a> <a href="delete?id=${dto.id}" class="btn btn-sm btn-danger">delete</a></td>
					
				</tr>
			</tbody>
		</table>
	</div>
	<hr>
</form>
 <%@include file="footer.jsp"%>
</body>
</html>