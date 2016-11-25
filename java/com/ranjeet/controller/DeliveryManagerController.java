package com.ranjeet.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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

	private static Logger LOG = Logger
			.getLogger(DeliveryManagerController.class);

	@Autowired
	private DeliveryManagementService deliveryManagementService;

	@RequestMapping("/")
	public String home(Model model) {
		return "index";
	}

	@RequestMapping("/addEmployeeDetails")
	public String addEmployeeDetails(Model model) {
		return "home";
	}

	@RequestMapping(value = "/saveEmployeeDetails", method = RequestMethod.POST)
	@ResponseBody
	public String saveEmployeeDetails(@RequestBody String employeeDetails) {

		Employee employee = null;
		JSONObject json = new JSONObject();
		String firstName = null;
		String lastName = null;
		String empId = null;

		try {
			json = (JSONObject) (new JSONParser().parse(employeeDetails));
			if (json.containsKey("empId")) {
				empId = (String) json.get("empId");
			}
			if (json.containsKey("firstName")) {
				firstName = (String) json.get("firstName");
			}
			if (json.containsKey("lastName")) {
				lastName = (String) json.get("lastName");
			}

			employee = new Employee();
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setEmployeeId(Integer.parseInt(empId));
			deliveryManagementService.saveEmployeeDetails(employee);

		} catch (Exception e) {
			LOG.error("Not able to book Hotel", e);
		}
		return "book";
	}

	@RequestMapping("/getDetailsForm")
	public String getJobDetailsForm(Model model) {
		// Employee employee = null;
		// Employee employees1 = null;
		try {
			List<Employee> employees = deliveryManagementService
					.getAllEmployees();
			model.addAttribute("employees", employees);
			model.addAttribute("jobForm", new JobDetails());
			// employee = deliveryManagementService.getEmployee(1);
			// System.out.println(employee.getFirstName());
			// employees1 =
			// deliveryManagementService.findEmployeeByEmployeeId(12);
			// System.out.println(employees1);

		} catch (Exception e) {
			LOG.error("Not able to fetch cities", e);
		}
		return "hotelBooking";
	}

	@RequestMapping("/addJobDetails")
	public String getJobForm(Model model) {
		try {
			model.addAttribute("jobForm", new JobDetails());

		} catch (Exception e) {
			LOG.error("Not able to fetch cities", e);
		}
		return "addJobDetails";
	}

	/*
	 * @RequestMapping(value = "/saveJobDetails", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public void saveBookingDetails(@RequestBody String
	 * jobDetails){ JobDetails details = new JobDetails(); Employee employee =
	 * new Employee(); try{ employee =
	 * deliveryManagementService.getEmployee("12"); details.setJobId(1);
	 * details.setPartNumber(1234555); details.setEmployee(employee);
	 * 
	 * deliveryManagementService.saveJobDetails(details);
	 * 
	 * }catch(Exception e){ LOG.error("Not able to book Hotel" , e); }
	 * 
	 * }
	 */

	@RequestMapping(value = "/saveJobDetails", method = RequestMethod.POST)
	@ResponseBody
	public void saveJobDetails(@RequestBody String jobDetails) {
		JobDetails details = null;
		JSONObject json = new JSONObject();
		String empId = null;
		String partNumber = null;
		String plannedQuantity = null;
		String launchedQuantity = null;
		String deliveredQuantity = null;
		String savedDate = null;

		try {

			json = (JSONObject) (new JSONParser().parse(jobDetails));
			if (json.containsKey("empId")) {
				empId = (String) json.get("empId");
			}
			// if(json.containsKey("empName")){
			// empName = (String) json.get("empName");
			// }
			if (json.containsKey("partNumber")) {
				partNumber = (String) json.get("partNumber");
			}
			if (json.containsKey("plannedQuantity")) {
				plannedQuantity = (String) json.get("plannedQuantity");
			}
			if (json.containsKey("launchedQuantity")) {
				launchedQuantity = (String) json.get("launchedQuantity");
			}
			if (json.containsKey("deliveredQuantity")) {
				deliveredQuantity = (String) json.get("deliveredQuantity");
			}
			if (json.containsKey("savedDate")) {
				savedDate = (String) json.get("savedDate");
			}

			details = new JobDetails();
			Employee fetchedemployee = new Employee();
			// emp.setId(Integer.parseInt(empId));
			fetchedemployee = deliveryManagementService
					.findEmployeeByEmployeeId(Integer.parseInt(empId));
			// emp.setFirstName(empName);
			// emp.setLastName(empName);
			// emp.setEmployeeId(12);
			System.out.println(fetchedemployee);

			details.setEmployee(fetchedemployee);
			details.setPartNumber(partNumber);
			details.setPlannedQuantity(plannedQuantity);
			details.setLaunchedQuantity(launchedQuantity);
			details.setDeliveredQuantity(deliveredQuantity);
			System.out.println(savedDate);
			java.sql.Date sqlDate = new java.sql.Date((new SimpleDateFormat(
					"YYYY-MM-DD").parse(savedDate)).getTime());
			System.out.println(sqlDate);
			details.setSavedDate(java.sql.Date.valueOf(savedDate));
			deliveryManagementService.saveJobDetails(details);

		} catch (Exception e) {
			LOG.error("Not able to book Hotel", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getEmployeeDetails", method = RequestMethod.POST)
	public Employee getEmployeeDetails(@RequestBody String employee)
			throws Exception {

		Employee fetchedEmployee = null;
		JSONObject json = new JSONObject();
		String empId = null;

		try {
			json = (JSONObject) (new JSONParser().parse(employee));
			if (json.containsKey("empId")) {
				empId = (String) json.get("empId");
			}
			fetchedEmployee = deliveryManagementService
					.findEmployeeByEmployeeId(Integer.parseInt(empId));
			System.out.println(fetchedEmployee.getId());

		} catch (Exception e) {
			LOG.error("Not able to get Details", e);
		}

		return fetchedEmployee;
	}

	@ResponseBody
	@RequestMapping(value = "/getJobDetails", method = RequestMethod.POST)
	public List<JobDetails> getJobDetails(@RequestBody String employee)
			throws Exception {

		List<JobDetails> fetchedJobDetails = null;
		JSONObject json = new JSONObject();
		String empId = null;

		try {
			json = (JSONObject) (new JSONParser().parse(employee));
			if (json.containsKey("id")) {
				empId = (String) json.get("id");
			}
			fetchedJobDetails = deliveryManagementService
					.findJobDetailsById(Integer.parseInt(empId));
			System.out.println(fetchedJobDetails.get(0).getPartNumber());

		} catch (Exception e) {
			LOG.error("Not able to get Details", e);
		}

		return fetchedJobDetails;
	}

	@ResponseBody
	@RequestMapping(value = "/getFilteredJobDetails", method = RequestMethod.POST)
	public List<JobDetails> getFilteredJobDetailsByDate(
			@RequestBody String filteringDetails) throws Exception {

		List<JobDetails> filteredJobDetails = null;
		JSONObject json = new JSONObject();
		String empId = null;
		String fromDate = null;
		String toDate = null;
		Date fromDateAsDate = null;
		Date toDateAsDate = null;

		try {
			json = (JSONObject) (new JSONParser().parse(filteringDetails));
			if (json.containsKey("id")) {
				empId = (String) json.get("id");
			}
			if (json.containsKey("fromDate")) {
				fromDate = (String) json.get("fromDate");
			}
			if (json.containsKey("toDate")) {
				toDate = (String) json.get("toDate");
			}
			
			Employee fetchedemployee = new Employee();
			// emp.setId(Integer.parseInt(empId));
			fetchedemployee = deliveryManagementService
					.findEmployeeByEmployeeId(Integer.parseInt(empId));
			// emp.setFirstName(empName);
			// emp.setLastName(empName);
			// emp.setEmployeeId(12);
			System.out.println(fetchedemployee);

			System.out.println(fromDate);
			System.out.println(toDate);

			fromDateAsDate = new SimpleDateFormat("MM/dd/yyyy").parse(fromDate);
			toDateAsDate = new SimpleDateFormat("MM/dd/yyyy").parse(toDate);
			
			
			String fromDateAsString = new SimpleDateFormat("yyyy-MM-dd").format(fromDateAsDate);
			String toDateAsString = new SimpleDateFormat("yyyy-MM-dd").format(toDateAsDate);

			System.out.println(fromDateAsString);
			System.out.println(toDateAsString);

			filteredJobDetails = deliveryManagementService
					.filterJobDetailsByDate(fetchedemployee,
							java.sql.Date.valueOf(fromDateAsString),
							java.sql.Date.valueOf(toDateAsString));

		} catch (Exception e) {
			LOG.error("Not able to get Details", e);
		}

		return filteredJobDetails;
	}

}
