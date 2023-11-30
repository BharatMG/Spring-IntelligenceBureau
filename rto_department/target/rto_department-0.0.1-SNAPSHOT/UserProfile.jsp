<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="styles.jsp"%>
</head>
<body>
	<%@include file="Navbar.jsp"%>

	<%-- <h1>${d}</h1> --%>

	<h1 class="text-center">User Status-form</h1>
	<table class="table table-bordered">
		<tbody>
			<tr><th>id</th><td>${d.id}</td><th>firstName</th><td>${d.firstName}</td></tr><tr>
				<tr><th>applicationNumber</th><td>${d.applicationNumber}</td><th>middleName</th><td>${d.middleName}</td></tr>
				<tr><th>dob</th><td>${d.dob}</td><th>lastName</th><td>${d.lastName}</td></tr>
				<tr><th>rtoOffice</th><td>${d.rtoOffice}</td><th>gender</th><td>${d.gender}</td></tr>
				<tr><th>email</th><td>${d.email}</td><th>state</th><td>${d.state}</td></tr>
				<tr><th>contactNumber</th><td>${d.contactNumber}</td><th>country</th><td>${d.country}</td></tr>
				<tr><th>userRegistereDateTime</th><td>${d.userRegistereDateTime}</td></tr>
				<tr><th>status</th><td><font color="blue">${d.status}</font></td></tr>
				<%-- 
				<a href="updateStatus?id=${dto.applicationNumber}" class="btn btn-sm btn-primary">Approve</a> --%>
				<%-- <tr><th>dob</th><td>${d.dob}</td></tr> --%>
				<!-- <th>age</th>
				<th>bloodGroup</th>
				<th>qualification</th>
				<th>placeOfBirth</th> -->
				
				<!-- <th>aadharNumber</th>
				<th>presentAddress</th>
				<th>permanentAddress</th>
				<th>presentPincode</th>
				<th>permanentPincode</th>
				<th>organDonation</th> -->		
			</tr>
			<tr>
			<%-- 	<td>${d.age}</td>
				<td>${d.bloodGroup}</td>
				<td>${d.qualification}</td>
				<td>${d.placeOfBirth}</td> --%>
				<%-- <td>${d.aadharNumber}</td>
				<td>${d.presentAddress}</td>
				<td>${d.permanentAddress}</td>
				<td>${d.presentPincode}</td>
				<td>${d.permanentPincode}</td> --%>
				<%-- <td>${d.organDonation}</td> --%>
				<td> 
				<%-- <a href="delete?id=${dto.id}" class="btn btn-sm btn-danger">delete</a> --%></td>
			</tr>

		</tbody>

	</table>

	<%@include file="footer.jsp"%>
</body>
</html>