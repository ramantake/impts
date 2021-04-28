<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
		</li></ul>
		</div>
		</div>
	</nav>
</header>


	<div class="container-fluid " >

		<div class="row">
			<div class="offset-md-4 col-md-4 offset-lg-4 col-lg-4 text-center bg-light">
				<form id="contact" action="/registerSubmit" model="patient"  method="post">
				<p></p>
					<h3>Patient Registration Form</h3>
					<h4>(Register to get the treatment schedule)</h4>
					<fieldset>
						<div class="form-group">
						<input class="form-control" pattern="[A-Za-z ]+" placeholder="Your name" name="name" type="text" tabindex="1" required
							>
							</div>
					</fieldset>
					<p></p>
					<fieldset>
						<div class="form-group">
						<input class="form-control" min="0" max="150"  name="age" placeholder="Age" type="number" tabindex="2"
							required>
						</div>
					</fieldset>
					<fieldset>
						<p></p>
						<div class="form-row">
							<div class="col">
								
								<label for="treatmentPackageName">Package Name</label>
							</div>
							<p> </p>
							<div class="col">
								<div class="form-group">
								<input class="form-control" placeholder="Your name" value="${ pack }" name="treatmentPackageName" type="text" tabindex="1" required="true" readonly>
								</div>
							</div>
						</div>
						<p></p>
					</fieldset>
					<fieldset>
					<p></p>
						<div class="form-row">
							<div class="col">
								<label for="treatmentPackageName">Ailment</label>
							</div>
							<p></p>
							<div class="col">
								<div class="form-group">
						
								<input class="form-control" placeholder="Your name" value="${ ailment }" name="ailment" type="text" tabindex="1" required="true" readonly>
								 </div>
							</div>
						</div>
						
					</fieldset>
					<p></p>
					<div class="form-row">
						<div class="col">
								<label for="treatmentPackageName">Cost</label>
						</div>
					
						<div class="col">
							<div class="form-group">
						 		<input class="form control" type="text" id="cost" name="cost" value="${cost}" readonly>
						 	</div>
						 </div>
					 </div>
					<p></p>
					<fieldset>
						<button class="btn btn-primary" name="submit" type="submit" id="contact-submit"
							data-submit="...Sending" >Submit</button>
							<p></p>
					</fieldset>
					
				</form>
			</div>
		</div>
	</div>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

<footer > 
<p >Copyrights.&#169; IPTMS 

Contact us : Iptms@gmail.com</P>
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