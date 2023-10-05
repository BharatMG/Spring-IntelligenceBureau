<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="nav.jsp"%>

<form action="getByName" method="get">
<div class="text-center">
<input type="search" placeholder="search" name="officerName">
<div>
<input type="submit">
</div>


<h1 class="text-center">Search by Name</h1>
		<table class="table table-bordered">
			<tbody>
				<tr>
				<th>id</th>
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
				<c:forEach items="${dto}" var="dto">
				<tr>
				<td>${dto.id}</td>
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
	<hr>
</form>
 <%@include file="footer.jsp"%>



</body>
</html>