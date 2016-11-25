<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

 <link
	href="${pageContext.request.contextPath}/resources/css/theme.css"
	rel="stylesheet">
    
    <style type="text/css">
    	.form-control {
    		width:38%;
    		margin-top: 10px;
    	}
    </style>
</head>
<body style="background-color: #eee;">
	<div class="container">
	
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="myFont-text navbar-brand" href="/HotelBookingSystem"
				style="margin-left: -30px;color: blue;">Hotel Booking System</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${loggedInUser == null}">
					<li><a href="login" style="color: red;"><span
							class="glyphicon glyphicon-menu-right"></span>&nbsp;&nbsp;Sign in</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	</nav>
	</div>
	<div style="margin-left:96px;">
	<form:form method="post" class="form-signup" action="user/register" modelAttribute="user">
	 <h3 class="myFont-text form-signin-heading">Sign Up</h3>
	 <h5 style="color:red">${msg}</h5>
		<form:input path="firstName" class="form-top form-control" placeholder="First Name" required="true"/>
		<form:input path="lastName" class="form-mid form-control" placeholder="Last Name" required="true"/>
		<form:input type="email" path="email"  class="form-mid form-control" placeholder="Email" required="true"/>
		<form:password showPassword="true" class="form-bottom form-control"  path="password"  placeholder="PassWord" required="true"/>
		
		<div class="row" style="margin-top: 10px;">
		  <div class="btn-left col-xs-2"><button class="btn btn-lg btn-primary btn-block" style="padding-top: 5px; width:70%" type="submit">Sign up &raquo;</button></div>
		  <div class="btn-right col-xs-2"><a href="/HotelBookingSystem" style="padding-top: 5px;width:70%" class="btn btn-lg btn-success btn-block" >Cancel</a></div>
		</div>
	</form:form>
	</div>
</body>
</html>