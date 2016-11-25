<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="favicon-square.ico">

<title>Signin</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/signin.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/theme.css"
	rel="stylesheet">	

<style type="text/css">
.form-control {
	width: 38%;
	margin-top: 10px;
}
</style>
</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="myFont-text navbar-brand" href="/HotelBookingSystem"
				style="margin-left: -30px;color: blue;">Hotel Booking System</a>
		</div>
	</div>
</nav>
	<div>
		<form:form method="post" action="user/login" modelAttribute="user">

			<div class="container">
			<div style="margin-left: -30px;margin-top: -14px;">
				<h3  class="myFont-text form-signin-heading">&nbsp;&nbsp;&nbsp;LOGIN</h3></div>
				<h5 style="color:red">${param.loginMsg}</h5>
				<div style="margin-left: -11px;">
				<form:label path="email" class="sr-only">Email</form:label>
				<form:input type="email" path="email" class="form-control"
					placeholder="Email address" required="true" />
				<form:label path="password" class="sr-only">Password</form:label>
				<form:password showPassword="true" path="password"
					class="form-control" placeholder="Password" required="true" />
                
				<div class="row" style="margin-top: 10px;">
					<div class="btn-left col-xs-2">
						<button id="signIn" class="btn btn-lg btn-primary " style="padding-top: 5px;" type="submit">Sign
							in &raquo;</button>
					</div>
					<div class="btn-left">
						<a id="signUp" href="register" style="padding-top: 5px;" class="btn btn-lg btn-success">Sign
							up</a>
					</div>
				</div>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
