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
<title>Delivery Management System</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/signin.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/theme.css"
	rel="stylesheet">
	
<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery-3.1.0.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/main.js"></script>

</head>
<body>

	<!-- <div class="container">
		<div class="navbar-header">
			<a class="myFont-text navbar-brand" href="/DeliveryManagement"
				style="color: blue;">Delivery Management System</a>
		</div>
	</div> -->

	<div>
		<div class="container">
			<div class="row">
				<div></div><a class="myFont-text navbar-brand" href="/DeliveryManagement"
				style="color: blue;">Delivery Management System</a></div>
				<div><h3 style="margin-top: 0px;">Job Detail Information</h3></div>
					<table>
						<tr>
						<td>Today is:</td>
						<td id="today_date"></td>
						</tr>
						<tr>
						<td>Enter your Employee Id:</td>
						<td><input id="empId_add_job" name="empId" /></td>
						</tr>
						<tr><td>Part Number:</td><td><input id="partNumber" name="partNumber"/></td></tr>
						<tr><td>Planned Quantity:</td><td><input id="plannedQauntity" name="plannedQauntity"/></td></tr>
						<tr><td>Launched Quantity:</td><td><input id="launchedQuantity" name="launchedQuantity"/></td></tr>
						<tr><td>Delivered Quantity:</td><td><input id="deliveredQuantity" name="deliveredQuantity"/></td></tr>
						<tr>
						    <td style="padding: 10px 0px 0px 0px;"><input type="submit" class="btn btn-xs btn-primary pull-left" id="save_details"value="Save Details"></td>
							<td style="padding: 10px 0px 0px 0px;">
							<button type="button" class="btn btn-xs btn-success btn-block pull-right" style="width: 77px;" onclick="window.location.href='/DeliveryManagement'">Cancel</button></td>
						</tr>
					</table>
			</div>
			<span id="msg"></span>

		</div>
	</div>
</body>
</html>
