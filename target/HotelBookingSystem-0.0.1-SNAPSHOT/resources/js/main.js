$( document ).ready(function() {

	/*$(function() {
		var userId = $("#loggedInUser").val();
		if(userId== null || userId== ""){
			$("#getHotelBookingForm").removeAttr("href").click(function(){
				$("#login_Message").html("Please Sign In if already registered or Sign Up to proceed with booking hotel.");
				$("#login_Message").css("display","block");
				$("#login_Message").css("color","red");
			});
		}
	});

	function validateLogin(){
		var userId = $("#loggedInUser").val();
		if(userId== null || userId== ""){
			$("#login_Message").html("Please Sign In if already registered or Sign Up to proceed with booking hotel.");
			$("#login_Message").css("display","block");
			$("#login_Message").css("color","red");
			return false;
		}else{
			return true;
		}

	}
	*/

	/*$(document).on("change","#user_select",function(e) {
		//$('#hotel_select').find('option').remove().end().append('<option selected="selected" value="-1">--Select Hotel--</option>');
		//$('#hotel_select').find('option').attr("selected","selected");
		var empId = $( "#user_select option:selected" ).attr("value");
		var empName = $( "#user_select option:selected" ).html();
		var emp ={};
		emp["cityName"] = empName;
		emp["cityId"] = empId;
		if(cityId != -1){
			$.ajax({
				type : "POST",
				url : "getJobDetailsByEmp",
				data : JSON.stringify(city),
				contentType: "application/json",
				dataType: "json",
				success:function(data, textStatus, jqXHR) {
					console.log(data);
					if(data != null){
						$.each(data, function(key, value) {
//							$('#hotel_select').append($('<option>', { 
//								value: value.hotelId,
//								text : value.hotelName 
//							}));
							console.log(value.jobId);
						});
					}
				},
				error:function(jqXHR, textStatus, erroThrown){
					alert("Something went wrong, not able to fetch hotels");
				}
			});	
		}
	});
	*/

	$(function(){
		var dateToday = new Date();
		$( ".datepicker" ).datepicker({
			minDate: dateToday
		});
		$( "#format" ).change(function() {
			$( "#datepicker" ).datepicker( "option", "dateFormat", $(this).val() );
		});
	});


//	$(document).on("change","#fetchHotels",function(e) {
//		var cityId = $( "#fetchHotels option:selected" ).attr("value");
//		var cityName = $( "#fetchHotels option:selected" ).html();
//		var city ={};
//		city ["cityName"] = cityName;
//		city ["cityId"] = cityId;
//		$("#hotelDetailsTable").html("");
//		if(cityId != -1){
//			$.ajax({
//				type : "POST",
//				url : "fetchLowestPricedHotels",
//				data : JSON.stringify(city),
//				contentType: "application/json",
//				dataType: "json",
//				success:function(response, textStatus, jqXHR) {
//					console.log(response);
//					if(response != null){
//						var data = "<thead><tr><th style='width:65%;'>Hotel</th><th>Tariff Per Day</th></tr></thead><tbody>";
//						$.each(response, function(key, value) {
//							data = data + "<tr><td>" + value.hotelName + "</td><td>" + value.tariffPerDay + "</td></tr>";
//						});
//						data = data + "</tbody>"
//						$("#hotelDetailsTable").append(data);
//					}
//				},
//				error:function(jqXHR, textStatus, erroThrown){
//					alert("Something went wrong, not able to fetch hotels");
//				}
//			});	
//		}
//	});

	$(document).on("click","#save_details",function(e) {
//		var cityName = $('#city_select :selected').html();
//		var cityId = $('#city_select :selected').val();
//		var hotelId = $('#hotel_select :selected').val();
//		var checkInDate = $("#checkIn_Date").val();
//		var checkOutDate = $("#checkOut_Date").val();
//		var numberOfRooms = $("#number_Of_Rooms").val();
		//var empId = $("#loggedInUser").val();
		var empId = "123";
		var partNumber = "213141431";
		var jobDetails ={};
//		var check_in = new Date(checkInDate);
//		var check_Out = new Date(checkOutDate);
//		$("#city_err").css("display","none");
//		$("#hotel_err").css("display","none");
//		$("#checkIn_Date_err").css("display","none");
//		$("#checkOut_Date_err").css("display","none");
//		$("#number_Of_Rooms_err").css("display","none");
//		$("#bookingMsg").css("display","none");


//		var isValid = true;
//		if(cityId == -1) {
//			$("#city_err").html("Value provided for city is incomplete.");
//			$("#city_err").css("display","block");
//			isValid = false;
//		}
//		if (hotelId == -1) {
//			$("#hotel_err").html("Value provided for hotel is incomplete.");
//			$("#hotel_err").css("display","block");
//			isValid = false;
//		}
//		if (checkInDate == "") {
//			$("#checkIn_Date_err").html("Value provided for check in date is incomplete.");
//			$("#checkIn_Date_err").css("display","block");
//			isValid = false;
//		}
//		if (checkOutDate == "") {
//			$("#checkOut_Date_err").html("Value provided for check out date is incomplete.");
//			$("#checkOut_Date_err").css("display","block");
//			isValid = false;
//		}else {
//			if(check_in > check_Out ){
//				$("#checkOut_Date_err").html("Check in date is greater than check out date.");
//				$("#checkOut_Date_err").css("display","block");
//				isValid = false;
//			}
//		}
//
//		if (numberOfRooms == "") {
//			$("#number_Of_Rooms_err").html("Value provided for number of rooms is incomplete.");
//			$("#number_Of_Rooms_err").css("display","block");
//			isValid = false;
//		}else if(isNaN(numberOfRooms)){
//			$("#number_Of_Rooms_err").html("Value provided for number of rooms is incorrect.");
//			$("#number_Of_Rooms_err").css("display","block");
//			isValid = false;
//		}

		//if(isValid){
		if(true){
			jobDetails["userId"] = empId;
			jobDetails["part_number"] = partNumber;
			//jobDetails["cityName"] = cityName;
			//jobDetails["hotelId"] = hotelId;
			//jobDetails["checkInDate"] = checkInDate;
//			bookingDetails["checkOutDate"] = checkOutDate;
//			bookingDetails["numberOfRooms"] = numberOfRooms;

			$.ajax({
				type : "POST",
				url : "saveJobDetails",
				data : JSON.stringify(bookingDetails),
				contentType: "application/json; charset=utf-8",
				success:function(data, textStatus, jqXHR) {
					console.log(data);
					if(data == null || data =="") {
						var bookingMsg = "error";
							$("#savingMsg").html(bookingMsg);
					}else{
						var bookingMsg = "saved ";
						$("#savingMsg").html(bookingMsg);
					}
					
				},
				error:function(jqXHR, textStatus, erroThrown){
					alert("Something went wrong, not able to book rooms");
				}
			});	
		}
	});

});



