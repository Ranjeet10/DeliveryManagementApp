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


</head>
<body>

	<div class="container">
		<div class="navbar-header">
			<a class="myFont-text navbar-brand" href="/HotelBookingSystem"
				style="margin-left: -30px;color: blue;">Delivery Management System</a>
		</div>
	</div>

	<div>
		<div class="container">
			<div class="row">

					<h3>Job Detail Information</h3>
					<span id="bookingMsg" style="display:none; color:red,margin-left:13px"></span>
					<table>
						<tr>
							<th style="padding: 12px;">Employee</th>
							<td ><select id="city_select" style="width:100%;">
									<option value="-1">--Select Employee--</option>
									<c:forEach items="${employees}" var="employee">
										<option value="${employee.employeeId}">${employee.firstName}</option>
									</c:forEach>
							</select></td>
							<td><span id="city_err" style="color:red;margin-left: 10px;"></span></td>
						</tr>
						<tr><td>Part Number:</td><td><input name="partNumber"/></td></tr>
						<tr><td>Planned Quantity:</td><td><input name="plannedQauntity"/></td></tr>
						<tr><td>Launched Quantity:</td><td><input name="launchedQuantity"/></td></tr>
						<tr><td>Delivered Quantity:</td><td><input name="deliveredQuantity"/></td></tr>
						<tr><td><a href="saveJobDetails">Save Job</a></td></tr>
					</table>
			</div>

		</div>
	</div>
</body>
</html>
