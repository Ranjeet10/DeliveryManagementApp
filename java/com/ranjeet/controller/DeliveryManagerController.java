package com.ranjeet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.log4j.Logger;
import com.ranjeet.model.Employee;
import com.ranjeet.model.JobDetails;
import com.ranjeet.service.DeliveryManagementService;

@Controller
public class DeliveryManagerController {
	
	private static Logger LOG = Logger.getLogger(DeliveryManagerController.class); 

	@Autowired
	private DeliveryManagementService deliveryManagementService;


	@RequestMapping("/")
	public String home(Model model) {
		return "index";
	}
	
	@RequestMapping("/getDetailsForm")
	public String getJobForm(Model model){
		try{
			List<Employee> employees = deliveryManagementService.getAllEmployees();
			model.addAttribute("employees", employees);
			model.addAttribute("jobForm", new JobDetails());
		}catch(Exception e){
			LOG.error("Not able to fetch cities" , e);
		}
		return "hotelBooking";
	}
	
	
	@RequestMapping(value = "/saveJobDetails", method = RequestMethod.POST)    
	@ResponseBody
	public void saveBookingDetails(@RequestBody String jobDetails){
		JobDetails details = new JobDetails();
		Employee employee = new Employee();
		try{
			employee = deliveryManagementService.getEmployee("12");
			details.setJobId(1);
			details.setPartNumber(1234555);
			details.setEmployee(employee);

			deliveryManagementService.saveJobDetails(details);
			
		}catch(Exception e){
			LOG.error("Not able to book Hotel" , e);
		}
		
	}
	

}
