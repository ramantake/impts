<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<li class="nav-item"><a class="nav-link px-3 " href="/getOnGoingTreatmentPlanList">Ongoing Treatments</a></li>
		<li class="nav-item"><a class="nav-link px-3 " href="/registerPatient">Register Patient</a></li>
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
		</li></ul>
		</div>
		</div>
	</nav>
</header>
	<div class="container-fluid">
		<hr/>
		<h1 class="text-center text-white">Summary</h1>
		<hr/>
	
    
    <div class="row">
        <div class="col-md-12">
            <div class="card ">
                <div class="card-header">
                    <h3 class="text-xs-center"><strong>Order summary</strong></h3>
                </div>
                <div class="card-block">
                    <div class="table-responsive">
                        <table class="table table-sm">
                            <thead>
                                <tr>
                                    <td></td>
                                    <td class="text-xs-center"><strong>Pricing</strong></td>
                                   
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td >Total Cost</td>
                              
                                    <td class="text-xs-center">$${total}</td>
      
                                </tr>
                                <tr>
                                    <td>Insurance</td>
                                   
                                    <td class="text-xs-right">$${InsurAmt }</td>
                                </tr>
                                
                                <tr>
                                
                                    <td class="highrow">To be Paid</td>
                                    <td class="highrow text-xs-right">$${Outstanding}</td> -->
                                </tr>
                               
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
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

footer{
position:fixed;
color:white;
 left: 0;
  bottom: 0;
  width: 100%;
text-align: center;}
body {
  
  background-image:url("https://gcn.com/articles/2019/06/28/-/media/GIG/GCN/Redesign/Articles/2019/June/heartbeat.png") ;
  background-repeat: no-repeat;
  background-size: cover;
}
</style>


<style>
.height {
    min-height: 200px;
}

.icon {
    font-size: 47px;
    color: #5CB85C;
}

.iconbig {
    font-size: 77px;
    color: #5CB85C;
}

.table > tbody > tr > .emptyrow {
    border-top: none;
}

.table > thead > tr > .emptyrow {
    border-bottom: none;
}

.table > tbody > tr > .highrow {
    border-top: 3px solid;
}
</style>
		</div>
	</body>
</html>