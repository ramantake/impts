<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
		
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
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
		<li class="nav-item"><a class="nav-link px-3 " href="#">Admin</a></li>
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
		</li></ul>
		</div>
		</div>
	</nav>
</header>

<br>
<br>

<div class="container">
<div class="row"> 
<div class="col"><div class="col mb-3" >
	<a href="/ViewAllPackages">
	<div class="card" >
		<div class="card-body">
		<img class="card-img-top" height=220px src="https://assets-global.website-files.com/5a690960b80baa0001e05b0f/5b34f02317fc5f1c458959de_Project-communication-plan.jpg">
        <div class="card-title text-center"><h6><b>View Treatment Plans</b></h6></div>
        </div></div>
        </a>
	</div> </div> 
<div class="col"><div class="col mb-3" >
	<a href="/specialist">
	<div class="card" >
		<div class="card-body">
		<img class="card-img-top" 
	height=220px  src="data:image/jpeg;base64,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">
        <div class="card-title text-center"><h6><b>View Specialists</b></h6></div>
        </div>
	</div>
	</a>
	</div> </div> 
<div class="col">
	<div class="col mb-3">
	<a href="/registerPatient">
	<div class="card" >
		<div class="card-body">
		<img class="card-img-top" height=220px src="https://png.pngtree.com/thumb_back/fw800/back_our/20190621/ourmid/pngtree-flat-cartoon-medical-blue-banner-poster-background-image_184409.jpg">
        <div class="card-title text-center"><h6><b>New Patient Registration</b></h6></div>
        </div>
	</div>
	</a>
	</div></div></div> 
</div>


<div class="container">
<div class="row"> 
<div class="col">	<div class="col mb-3">
	<a href="/getOnGoingTreatmentPlanList">
	<div class="card" >
		<div class="card-body">
		<img class="card-img-top" src="https://thumbs.dreamstime.com/b/patient-examination-consultation-doctor-clinic-disabled-injured-men-women-hospital-therapists-check-health-211797779.jpg">
        <div class="card-title text-center"><h6><b>View Ongoing Treatments</b></h6></div>
        </div>
	</div>
	</a>
	</div> </div> 
<div class="col"><div class="col mb-3">
	<a href="/viewAllInsurer">
	<div class="card" >
		<div class="card-body">
		<img class="card-img-top" height=220px src="https://cdn0.iconfinder.com/data/icons/insurance-icons-set-cartoon-style/512/a521-512.png">
        <div class="card-title text-center"><h6><b>View Insurance Providers</b></h6></div>
        </div>
	</div>
	</a>
	</div> </div> 
<div class="col">
	<div class="col mb-3">
	<a href="/patients">
	<div class="card" >
		<div class="card-body">
		<img class="card-img-top" height=220px src="https://images.all-free-download.com/images/graphiclarge/hospital_drawing_doctor_patient_icons_colored_cartoon_characters_6835467.jpg">
        <div class="card-title text-center"><h6><b>View Patients</b></h6></div>
        </div>
	</div>
	</a>
	</div></div></div> 
</div>


</div>	
	
	
	</div>

</div>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<div> </div>
<p></p> 
<div> </div>
<footer > 
<p >Copyrights.&#169; IPTMS  Contact us : Iptms@gmail.com
</p>

</footer>
<style> 
body {
  
  background-image:url("https://image.freepik.com/free-vector/clean-medical-background_53876-97927.jpg") ;
  background-repeat: no-repeat;
  background-size: cover;
}
footer {

  left: 0;
  bottom: 0;
  width: 100%;

  color: blue;
  text-align: center;
}

</style>

</body>
</html>