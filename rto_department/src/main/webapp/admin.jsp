<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h6 style='color: red'>${pass}</h6>
		<form action="adminlogin" method="post">
			<div class="form-floating mb-3">
				<input type="email" class="form-control" name="emailId" id="floatingInput" placeholder="name@example.com"> <label for="floatingInput">Email address</label>
			</div>
			
			
			<input type="submit" value="send Otp">
		</form>

		<form action="verifyotp" method="post">
			<div class="form-floating mb-3">
				<input type="email" class="form-control" name="emailId" value="${emailId}"> <label>Email address</label>
			</div>
			<div class="form-floating mb-3">
				<input type="text" class="form-control" name="rtoOtp" id="floatingInput" placeholder="Enter otp"> <label for="floatingInput">Enter otp</label>
			</div>
			<div>
				<input type="submit" class="btn btn-success" value="login"> <input type="reset" class="btn btn-dark">
			</div>
		</form>
	</div>
	<!-- <button class="text-center"><a href=sendOtp?id=${dto.id}>send Otp</a></button> -->
<!-- 	<button></button> -->

	<!-- <div class="text-center">
			<input   type="submit" class="btn btn-success" value="send OTP"></div> -->
	<!-- </div><div class="form-floating mb-3">
				<input type="text" class="form-control" name="rtoOtp" id="floatingInput" placeholder="Enter otp"> <label for="floatingInput">Enter otp</label>
			</div> -->

	<%@include file="footer.jsp"%>
</body>
</html>