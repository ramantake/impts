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
		<title>Package Page</title>
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
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
		</li></ul>
		</div>
		</div>
	</nav>
</header>
		<div class="container-fluid">
		
		
		<!-- Start Your code from here   -->
		<hr></hr>
		<h1 class="text-center text-white">Available Packages</h1>
		<hr></hr>
			<div>
				<table class="table table-hover table-bordered text-dark table-light">
				  <thead>
				    
				      <th scope="col">Ailment</th>
				     <th scope="col">Package</th>
					   <th>Test Detail</th>
					   <th>Cost</th>
					   <th>Duration in weeks</th>
					   <th> Register</th>
				   </tr> 
				   </tr>
				   </th>
				  </thead>
				  <tbody>
				    <tr>
				<c:forEach items="${plist}" var="p">
				<tr>
				<td class="col-left"> <c:out value="${p.ailmentCategory}"/></td>
				<td class="col-right"> <c:out value="${p.packageDetail.treatmentPackageName}"/></td>
				<td class="col-right"> <c:out value="${p.packageDetail.testDetails}"/></td>
				<td class="col-right"> <c:out value="${p.packageDetail.cost}"/></td>
				<td class="col-right"> <c:out value="${p.packageDetail.treatmentDurationInWeeks}"/></td>
				<td class="col-right">
					<form method="post" action="/register">
									 <input type="hidden" id="packName" name="pName" value="${p.packageDetail.treatmentPackageName}">
									  <input type="hidden" id="ptId" name="pId" value="${pId}">
									   <input type="hidden" id="ailName" name="aName" value="${p.ailmentCategory}">
									   <input type="hidden" id="cost" name="cost" value="${p.packageDetail.cost}">
									 <button class="btn  btn-primary text-white" name="submit" type="submit" id="submit">Register Patient</button>
					</form>		
				</td>

				</tr>
				</c:forEach>
				    </tr>
				   
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