<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin</title>
<%@ include file="styles.jsp"%>
</head>
<body>
<%@include file="Navbar.jsp"%>

	<div class="container p-4 mt-3 w-50 border border-dark-subtle">
		<h1>Admin-Login</h1>
		<form action="adminlogin" method="get">
			<div class="form-floating mb-3">
				<input type="email" class="form-control" name="emailId" id="floatingInput" placeholder="name@example.com"> <label for="floatingInput">Email address</label>
			</div>
<h6 style='color:red'>${pass}</h6>
			<div class="form-floating mb-3">
				<input type="password" class="form-control" name="password" id="floatingInput" placeholder="Enter password"> <label for="floatingInput">Enter password</label>
			</div>
			<div>
				<input type="submit" class="btn btn-success"> <input type="reset" class="btn btn-dark">
			</div>
		</form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>