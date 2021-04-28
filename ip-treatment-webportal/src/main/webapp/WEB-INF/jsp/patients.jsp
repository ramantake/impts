<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!doctype html>
<html lang="en">
	<head>
		<title></title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
		<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
	</head>
	<body>
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
		<li class="nav-item"><a class="nav-link px-3 " href="#">Admin</a></li>
		<li class="nav-item"><a class="nav-link px-3 " href="/getOnGoingTreatmentPlanList">Ongoing Treatments</a></li>
		<li class="nav-item"><a class="nav-link px-3 " href="/registerPatient">Register Patient</a></li>
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
		
		</li></ul>
		</div>
		</div>
	</nav>
</header>
	<div class="container-fluid">
				<hr></hr>
		<h1 class="text-center text-white">All Patients</h1>
		<hr></hr>
			<div>
				<c:set var="count" value="0" scope="page" />
				
				<table class="table table-hover table-bordered text-dark table-light">
				  <thead>
				    <tr>
				      <th scope="col">S.No.</th>
				      <th scope="col">Name</th>
				      <th scope="col">Test Details</th>
				      <th scope="col">Package</th>
				       <th scope="col">Specialist</th>
				      <th scope="col">Cost</th>
				      <th scope="col">Start date</th>
				      <th scope="col">End date</th>
				       <th scope="col">Status</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach items="${tlist}" var="plan">
				  <c:set var="count" value="${count + 1}" scope="page" />				
				  
				    <tr>
				      <th scope="row">${count}</th>
				      <td>${plan.ptDetail.name}</td>
				      <td>${plan.testDetails}</td>
				      <td>${plan.packageName}</td>
				      <td>${plan.specialist}</td>
				      <td>${plan.cost}</td>
				      <td>${plan.treatmentCommencementDate}</td>
				      <td>${plan.treatmentEndDate}</td>
				      <td>${plan.status}</td>
				    </tr>
				   </c:forEach>
				
				  </tbody>
				</table>
			</div>
	</div>
	<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

<footer > 
<p >Copyrights.&#169; IPTMS 
</p>
<P>Contact us : Iptms@gmail.com</P>
</footer>
<style> 
body {
  
  background-image:url("https://gcn.com/articles/2019/06/28/-/media/GIG/GCN/Redesign/Articles/2019/June/heartbeat.png") ;
  background-repeat: no-repeat;
  background-size: cover;
}
footer{
position:fixed;
color:white;
 left: 0;
  bottom: 0;
  width: 100%;
text-align: center;}
</style>
	
	</body>
</html>