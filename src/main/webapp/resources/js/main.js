$(document)
		.ready(
				function() {

					/*
					 * $(function() { var userId = $("#loggedInUser").val();
					 * if(userId== null || userId== ""){
					 * $("#getHotelBookingForm").removeAttr("href").click(function(){
					 * $("#login_Message").html("Please Sign In if already
					 * registered or Sign Up to proceed with booking hotel.");
					 * $("#login_Message").css("display","block");
					 * $("#login_Message").css("color","red"); }); } });
					 * 
					 * function validateLogin(){ var userId =
					 * $("#loggedInUser").val(); if(userId== null || userId==
					 * ""){ $("#login_Message").html("Please Sign In if already
					 * registered or Sign Up to proceed with booking hotel.");
					 * $("#login_Message").css("display","block");
					 * $("#login_Message").css("color","red"); return false;
					 * }else{ return true; } }
					 */

					/*
					 * $(document).on("change","#user_select",function(e) {
					 * //$('#hotel_select').find('option').remove().end().append('<option
					 * selected="selected" value="-1">--Select Hotel--</option>');
					 * //$('#hotel_select').find('option').attr("selected","selected");
					 * var empId = $( "#user_select option:selected"
					 * ).attr("value"); var empName = $( "#user_select
					 * option:selected" ).html(); var emp ={}; emp["cityName"] =
					 * empName; emp["cityId"] = empId; if(cityId != -1){
					 * $.ajax({ type : "POST", url : "getJobDetailsByEmp", data :
					 * JSON.stringify(city), contentType: "application/json",
					 * dataType: "json", success:function(data, textStatus,
					 * jqXHR) { console.log(data); if(data != null){
					 * $.each(data, function(key, value) { //
					 * $('#hotel_select').append($('<option>', { // value:
					 * value.hotelId, // text : value.hotelName // }));
					 * console.log(value.jobId); }); } }, error:function(jqXHR,
					 * textStatus, erroThrown){ alert("Something went wrong, not
					 * able to fetch hotels"); } }); } });
					 */

					$(function() {

						$('#filter_action').hide();
						var d = new Date();
						var curr_date = d.getDate();
						var curr_month = d.getMonth() + 1; // Months are zero
						// based
						var curr_year = d.getFullYear();
						var today_date = (curr_year + "-" + curr_month + "-" + curr_date);

						$("#today_date").html(today_date);

						$(".datepicker").datepicker({});
						$("#format").change(
								function() {
									$("#datepicker").datepicker("option",
											"dateFormat", $(this).val());
								});
					});

					// $(document).on("change","#fetchHotels",function(e) {
					// var cityId = $( "#fetchHotels option:selected"
					// ).attr("value");
					// var cityName = $( "#fetchHotels option:selected"
					// ).html();
					// var city ={};
					// city ["cityName"] = cityName;
					// city ["cityId"] = cityId;
					// $("#hotelDetailsTable").html("");
					// if(cityId != -1){
					// $.ajax({
					// type : "POST",
					// url : "fetchLowestPricedHotels",
					// data : JSON.stringify(city),
					// contentType: "application/json",
					// dataType: "json",
					// success:function(response, textStatus, jqXHR) {
					// console.log(response);
					// if(response != null){
					// var data = "<thead><tr><th
					// style='width:65%;'>Hotel</th><th>Tariff Per
					// Day</th></tr></thead><tbody>";
					// $.each(response, function(key, value) {
					// data = data + "<tr><td>" + value.hotelName + "</td><td>"
					// + value.tariffPerDay + "</td></tr>";
					// });
					// data = data + "</tbody>"
					// $("#hotelDetailsTable").append(data);
					// }
					// },
					// error:function(jqXHR, textStatus, erroThrown){
					// alert("Something went wrong, not able to fetch hotels");
					// }
					// });
					// }
					// });

					$(document)
							.on(
									"click",
									"#get_emp_details",
									function(e) {

										var employee = {};
										var empId = $('#empId_info').val();
										employee["empId"] = empId;

										if (true) {

											$
													.ajax({
														type : "POST",
														url : "getEmployeeDetails",
														data : JSON
																.stringify(employee),
														contentType : "application/json; charset=utf-8",
														dataType : "json",
														success : function(
																response,
																textStatus,
																jqXHR) {
															if (response != null) {
																console
																		.log(response);
																$("#empDetails")
																		.html(
																				"");
																var data = "<b>Hello, </b>";
																data = data
																		+ "<i>"
																		+ response.firstName
																		+ " "
																		+ response.lastName
																		+ "</i>";
																$("#empDetails")
																		.append(
																				data);

																getJobDetailsAsPerEmployee(response.id);
															}
														},
														error : function(jqXHR,
																textStatus,
																erroThrown) {
															alert("Snot able to fetch employee details");
														}
													});
										}
									});

					function getJobDetailsAsPerEmployee(id) {

						var employee = {};
						employee["id"] = String(id);

						$
								.ajax({
									type : "POST",
									url : "getJobDetails",
									data : JSON.stringify(employee),
									contentType : "application/json; charset=utf-8",
									dataType : "json",
									success : function(response, textStatus,
											jqXHR) {
										if (response != null) {
											console.log(response);
											$('#filter_action').show();
											var data = "<div style='padding: 10px 0px 5px 0px;'><b>Job Details</b></div>";
											data = data
													+ "<table border='1'><thead><tr><th style='text-align: center;padding: 5px;'>Part Number</th><th style='text-align: center;padding: 5px;'>Planned Quantity</th><th style='text-align: center;padding: 5px;'>Launched Quantity</th><th style='text-align: center;padding: 5px;'>Delivered Quantity</th><th style='text-align: center;padding: 5px;'>Delivered Date</th></tr></thead><tbody>";
											$
													.each(
															response,
															function(key, value) {
																data = data
																		+ "<tr><td style='text-align: center;padding: 5px;'>"
																		+ value.partNumber
																		+ "</td>"
																		+ "<td style='text-align: center;padding: 5px;'>"
																		+ value.plannedQuantity
																		+ "</td>"
																		+ "<td style='text-align: center;padding: 5px;'>"
																		+ value.launchedQuantity
																		+ "</td>"
																		+ "<td style='text-align: center;padding: 5px;'>"
																		+ value.deliveredQuantity
																		+ "</td>"
																		+ "<td style='text-align: center;padding: 5px;'>"
																		+ value.savedDate
																		+ "</td>"
																		+ "</tr>";
															});
											data = data + "</tbody></table>";
											$("#empDetails").append(data);
										}
									},
									error : function(jqXHR, textStatus,
											erroThrown) {
										alert("Snot able to fetch employee details");
									}
								});

					}

					$(document)
							.on(
									"click",
									"#add_emp_details",
									function(e) {
										var empId = $('#add_emp_id').val();
										var firstName = $('#add_emp_first_name')
												.val();
										var lastName = $('#add_emp_last_name')
												.val();
										var employeeDetails = {};
										if (true) {
											employeeDetails["empId"] = empId;
											employeeDetails["firstName"] = firstName;
											employeeDetails["lastName"] = lastName;

											$
													.ajax({
														type : "POST",
														url : "saveEmployeeDetails",
														data : JSON
																.stringify(employeeDetails),
														contentType : "application/json; charset=utf-8",
														success : function(
																data,
																textStatus,
																jqXHR) {
															if (data == null
																	|| data == "") {
																var savingMsg = "error";
																$("#msg")
																		.html(
																				savingMsg);
															} else {
																var savingMsg = "saved ";
																$("#msg")
																		.html(
																				savingMsg);
															}

														},
														error : function(jqXHR,
																textStatus,
																erroThrown) {
															alert("Something went wrong, not able to book rooms");
														}
													});
										}
									});

					$(document)
							.on(
									"click",
									"#save_details",
									function(e) {
										// var cityName = $('#city_select
										// :selected').html();
										// var cityId = $('#city_select
										// :selected').val();
										// var hotelId = $('#hotel_select
										// :selected').val();
										// var checkInDate =
										// $("#checkIn_Date").val();
										// var checkOutDate =
										// $("#checkOut_Date").val();
										// var numberOfRooms =
										// $("#number_Of_Rooms").val();
										// var empId = $("#loggedInUser").val();
										var empId = $('#empId_add_job').val();
										var partNumber = $('#partNumber').val();
										var plannedQauntity = $(
												'#plannedQauntity').val();
										var launchedQuantity = $(
												'#launchedQuantity').val();
										var deliveredQuantity = $(
												'#deliveredQuantity').val();
										var savedDate = $("#today_date").html();
										// var partNumber = "213141431";
										var jobDetails = {};
										// var check_in = new Date(checkInDate);
										// var check_Out = new
										// Date(checkOutDate);
										// $("#city_err").css("display","none");
										// $("#hotel_err").css("display","none");
										// $("#checkIn_Date_err").css("display","none");
										// $("#checkOut_Date_err").css("display","none");
										// $("#number_Of_Rooms_err").css("display","none");
										// $("#bookingMsg").css("display","none");

										// var isValid = true;
										// if(cityId == -1) {
										// $("#city_err").html("Value provided
										// for city is incomplete.");
										// $("#city_err").css("display","block");
										// isValid = false;
										// }
										// if (hotelId == -1) {
										// $("#hotel_err").html("Value provided
										// for hotel is incomplete.");
										// $("#hotel_err").css("display","block");
										// isValid = false;
										// }
										// if (checkInDate == "") {
										// $("#checkIn_Date_err").html("Value
										// provided for check in date is
										// incomplete.");
										// $("#checkIn_Date_err").css("display","block");
										// isValid = false;
										// }
										// if (checkOutDate == "") {
										// $("#checkOut_Date_err").html("Value
										// provided for check out date is
										// incomplete.");
										// $("#checkOut_Date_err").css("display","block");
										// isValid = false;
										// }else {
										// if(check_in > check_Out ){
										// $("#checkOut_Date_err").html("Check
										// in date is greater than check out
										// date.");
										// $("#checkOut_Date_err").css("display","block");
										// isValid = false;
										// }
										// }
										//
										// if (numberOfRooms == "") {
										// $("#number_Of_Rooms_err").html("Value
										// provided for number of rooms is
										// incomplete.");
										// $("#number_Of_Rooms_err").css("display","block");
										// isValid = false;
										// }else if(isNaN(numberOfRooms)){
										// $("#number_Of_Rooms_err").html("Value
										// provided for number of rooms is
										// incorrect.");
										// $("#number_Of_Rooms_err").css("display","block");
										// isValid = false;
										// }

										// if(isValid){
										if (true) {

											jobDetails["empId"] = empId;
											jobDetails["partNumber"] = partNumber;
											jobDetails["plannedQauntity"] = plannedQauntity;
											jobDetails["launchedQuantity"] = launchedQuantity;
											jobDetails["deliveredQuantity"] = deliveredQuantity;
											jobDetails["savedDate"] = savedDate;
											// jobDetails["cityName"] =
											// cityName;
											// jobDetails["hotelId"] = hotelId;
											// jobDetails["checkInDate"] =
											// checkInDate;
											// bookingDetails["checkOutDate"] =
											// checkOutDate;
											// bookingDetails["numberOfRooms"] =
											// numberOfRooms;

											$
													.ajax({
														type : "POST",
														url : "saveJobDetails",
														data : JSON
																.stringify(jobDetails),
														contentType : "application/json; charset=utf-8",
														success : function(
																data,
																textStatus,
																jqXHR) {
															if (data == null
																	|| data == "") {
																var bookingMsg = "error";
																$("#msg")
																		.html(
																				bookingMsg);
															} else {
																var bookingMsg = "saved ";
																$("#msg")
																		.html(
																				bookingMsg);
															}

														},
														error : function(jqXHR,
																textStatus,
																erroThrown) {
															alert("Something went wrong, not able to book rooms");
														}
													});
										}
									});

					$(document).on("click", "#filterJobDetails", function(e) {
						getFilteredJobDetailsByDate();
					});

					function getFilteredJobDetailsByDate() {

						var filteringDetails = {};
						var empId = $('#empId_info').val();
						var fromDate = $('#from_date').val();
						var toDate = $('#to_date').val();
						filteringDetails["id"] = String(empId);
						filteringDetails["fromDate"] = String(fromDate);
						filteringDetails["toDate"] = String(toDate);

						$
								.ajax({
									type : "POST",
									url : "getFilteredJobDetails",
									data : JSON.stringify(filteringDetails),
									contentType : "application/json; charset=utf-8",
									dataType : "json",
									success : function(response, textStatus,
											jqXHR) {
										if (response != null) {
											console.log(response);
											$('#filter_action').show();
											var data = "<div style='padding: 10px 0px 5px 0px;'><b>Job Details</b></div>";
											data = data
													+ "<table border='1'><thead><tr><th style='text-align: center;padding: 5px;'>Part Number</th><th style='text-align: center;padding: 5px;'>Planned Quantity</th><th style='text-align: center;padding: 5px;'>Launched Quantity</th><th style='text-align: center;padding: 5px;'>Delivered Quantity</th><th style='text-align: center;padding: 5px;'>Delivered Date</th></tr></thead><tbody>";
											$
													.each(
															response,
															function(key, value) {
																data = data
																		+ "<tr><td style='text-align: center;padding: 5px;'>"
																		+ value.partNumber
																		+ "</td>"
																		+ "<td style='text-align: center;padding: 5px;'>"
																		+ value.plannedQuantity
																		+ "</td>"
																		+ "<td style='text-align: center;padding: 5px;'>"
																		+ value.launchedQuantity
																		+ "</td>"
																		+ "<td style='text-align: center;padding: 5px;'>"
																		+ value.deliveredQuantity
																		+ "</td>"
																		+ "<td style='text-align: center;padding: 5px;'>"
																		+ value.savedDate
																		+ "</td>"
																		+ "</tr>";
															});
											data = data + "</tbody></table>";
											$("#empDetails").append(data);
										}
									},
									error : function(jqXHR, textStatus,
											erroThrown) {
										alert("Snot able to fetch employee details");
									}
								});

					}

				});
