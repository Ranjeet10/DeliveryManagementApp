<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hotel Booking</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/signin.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/theme.css"
	rel="stylesheet">

</head>
<body role="document">

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="myFont-text navbar-brand" href="/HotelBookingSystem"
				style="margin-left: -30px; color: blue;">Hotel Booking System</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${loggedInUser == null}">
					<li><a href="login" style="color: red;"><span
							class="glyphicon glyphicon-menu-right"></span>&nbsp;&nbsp;Sign in</a></li>
					<li><a href="register" style="color: red;"><span
							class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;Sign up</a></li>
				</c:if>
				<c:if test="${loggedInUser != null}">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;${loggedInUser.firstName } &nbsp;${loggedInUser.lastName }&nbsp;</a></li>
					<li><a href="logout"><span
							class="glyphicon glyphicon-log-out"></span>&nbsp;&nbsp;&nbsp;Sign
							Out</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	</nav>

	<div>
			<div class="row" style="margin-left: 96px;">
				<div style="float: left; margin-top: -15px;">
					<h3>View Lowest Priced Hotels</h3>
				</div>
				<div
					style="float: left; padding-bottom: 40px; margin-top: -4px; margin-left: 25px;">
					<button type="button"
						onclick="window.location.href='/HotelBookingSystem'"
						class="btn btn-lg btn-success btn-block"
						style="font-size: 16px; height: 40px; width: 95%">Cancel</button>
				</div>
			</div>
			<div class="row" style="margin-left: 100px;">
				<div style="float: left; margin-top: -30px">
					<h4>City</h4>
				</div>
				<div style="float: left; margin-left: 21px; margin-top: -21px">
					<select id="fetchHotels" style="width: 200px;">
						<option value="-1">--Select City--</option>
						<c:forEach items="${cities}" var="city">
							<option value="${city.cityId}">${city.cityName}</option>
						</c:forEach>
					</select>
				</div>
				<div style="margin-top: 33px;">
					<table id = "hotelDetailsTable">
					</table>

				</div>
			</div>


		</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery-3.1.0.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
</body>
</html>
