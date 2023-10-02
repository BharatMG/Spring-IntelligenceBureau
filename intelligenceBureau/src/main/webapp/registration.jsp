<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width-device-width,initial-scale=1">
<title>Intelligence-Bureau</title>
<link rel="icon"
	href="https://www.javatpoint.com/fullformpages/images/ib.png"
	type="image/png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/fontawesome.min.css">
<!--  
 <div
	class="p-3 text-primary-emphasis bg-primary-subtle border border-primary-subtle rounded-3">
 -->
<style type="text/css">
.r {
	background-color: #00100;
	text-align: center;
	class: container;
}
</style>
</head>

<%@include file="nav.jsp"%>

<body class="r">
	<h1 style="text-align: center;">Registration-form</h1>

	<div class="container p-4">
		<div class="col-md-6 offset-md-3 card card-body">
			<div text-align:center; background-color:grey; color:
				#0054ff; class="container">
				<form action="save" method="post">
					<div class="mb-3">
						<label></label><br> <span><input type="number"
							name="id" placeholder="enter Id" required="required"></span>
					</div>
					<div class="mb-3">
						<label></label><br> <input type="text"
							name="officerName" placeholder="enter officerName"
							required="required">
					</div>
					<div class="mb-3">
						<label></label><br> <input type="text"
							name="designation" placeholder="enter designation"
							required="required">
					</div>

					<div class="mb-3">
						<label></label><br> <select name="gender"
							required="required">
							<option Selected>Select Gender</option>
							<option value="text">Male</option>
							<option value="text">Female</option>
							<option value="text">Others</option>
						</select>
					</div>


					<div class="mb-3" color="blue">
						<label></label><br> <input type="email" name="email"
							placeholder="enter email" required="required">
					</div>
					<div class="mb-3">
						<label></label><br> <input type="tel"
							name="mobileNumber" maxlength="10"
							placeholder="enter mobileNumber" required="required">
					</div>
					<div class="mb-3">
						<label></label><br> <input type="text"
							name="isMarried" placeholder="enter isMarried"
							required="required">
					</div>
					<div class="mb-3">
						<label></label><br> <input type="text"
							name="permanentrAddress" placeholder="enter permanentrAddress"
							required="required">
					</div>
					<div class="mb-3">
						<label></label><br> <input type="text"
							name="workingAddress" placeholder="enter workingAddress"
							required="required">
					</div>
					<div class="mb-3">
						<label></label><br> <input type="number"
							name="basicPayScale" placeholder="enter basicPayScale"
							required="required">
					</div>


					<input type="submit" class="btn btn-success"> 
					<input type="reset" class="btn btn-dark" href="registration.jsp">
					<!-- <input type="" class="btn btn-primary" href="index.jsp"> -->
					<input <a class="nav-link" input type="button" href="index.jsp">cancel</a>>

				</form>
			</div>
		</div>
	</div>
	<div style="text-align: center">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>