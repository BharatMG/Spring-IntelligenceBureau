<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" href="style.jsp">
<link rel="icon" href="https://www.javatpoint.com/fullformpages/images/ib.png" type="image/png">
<link https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>

	<nav class="navbar navbar-expand-lg bg-warning">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">IntelligenceBureau</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<a class="navbar-brand" href="index.jsp"><a href="index.jsp"><img src="https://www.x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" height="30vh"></a>
						<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav me-auto mb-2 mb-lg-0">
								<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>

								<li class="nav-item"><a class="nav-link" href="registration.jsp">Registration</a></li>

								<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>

								<li class="nav-item"><a class="nav-link" href="Findall.jsp">ReadAll</a></li>

								<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
									<ul class="dropdown-menu">
										<li><a class="dropdown-item" href="findById.jsp">findById</a></li>
										<li><a class="dropdown-item" href="findByName.jsp">findByName</a></li>
										<li><a class="dropdown-item" href="findByEmail.jsp">findByEmail</a></li>
										<li><hr class="dropdown-divider"></li>
										<li><a class="dropdown-item" href="index.jsp">Something else here</a></li>
									</ul></li>
							</ul>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">


					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>


</body>
</html>