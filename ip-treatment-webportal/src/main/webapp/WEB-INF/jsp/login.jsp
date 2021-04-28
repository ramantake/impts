<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device=width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">

<title>Internatinal patients treatment management system</title>
</head>
<body>
<div style="background-color:#002080;color:#ffffff;">
<h1 style="text-align: center;font-family:serif;"><b>International Patient Treatment Management System</b></h1>
</div>
<header>
	<nav class="px-5 mb-5 mb-5  navbar navbar-expand-md navbar-light bg-light">
	 <div class="container-fluid">
  <a class="navbar-brand" href="/adminDashboard">&nbsp;&nbsp;<i class="fa fa-hospital-o" style="font-size:48px;color:red"></i><br><b><font color="Red">IPTMS</font></b></a>

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navBarCollapse">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div  class="collapse navbar-collapse" id="navBarCollapse">
		<ul  class="navbar-nav">
		
		</li></ul>
		</div>
		</div>
	</nav>
</header>

	<div class="container mt-5 w-50">
		<div class="h2">
			Login
		</div>
		<div class="alert-danger">
			${invalid}
		</div>
		
		<form:form action="/loginValidate" modelAttribute="user">
			Username
			<form:input class="form-control" path="username" />
			Password
			<form:input type="password" class="form-control" path="password" />
			
			<input class="btn btn-success mt-2" type="submit" value="Submit" />
		</form:form>
	</div>
</body>