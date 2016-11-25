package com.ranjeet.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ranjeet.dao.JobDetailDao;
import com.ranjeet.model.Employee;
import com.ranjeet.model.JobDetails;

@Service
public class DeliveryManagementService {
	
	private static Logger LOG = Logger.getLogger(DeliveryManagementService.class);

	@Autowired
	private JobDetailDao jobDetailsDao;
	
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> cities = null;
		try {
			cities =jobDetailsDao.getAllEmployees();
		}catch (Exception e){
			LOG.error("Error in fetching cities" + e);
			throw new Exception(e);
		}
		return cities;
	}
	
	
	public void saveJobDetails(JobDetails jobDetails) throws Exception {
		try {
			//employee = jobDetailsDao.getEmployeeDetails(jobDetails.getEmployee().getEmployeeId());	
			//jobDetails.setEmployee(employee);
			jobDetailsDao.saveJobDetails(jobDetails);

		}catch (Exception e){
			LOG.error("Error in fetching hotels" + e);
			throw new Exception(e);
		}
	}
	
	public Employee getEmployee(int employeeId) throws Exception {
		
		Employee employee = new Employee();
		
		employee = jobDetailsDao.getEmployeeDetails(employeeId);
		
		return employee;
		
	}
	
public List<Employee> getEmployeeDetailsFromActualEmployeeId(int employeeId) throws Exception {
		
		List<Employee> employees = null;
		
		employees = jobDetailsDao.getEmployeeDetailsFromActualEmployeeId(employeeId);
		
		return employees;

	}


public Employee findEmployeeByEmployeeId(int employeeId) {
	
	Employee employee = null;
	
	employee = jobDetailsDao.findEmployeeByEmployeeId(employeeId);
	
	return employee;
	
}


public List<JobDetails> findJobDetailsById(int empId) throws Exception {

	List<JobDetails> fetchedJobDetails = null;
	
	fetchedJobDetails = jobDetailsDao.findJobDetailsById(empId);
	
	return fetchedJobDetails;
}


public void saveEmployeeDetails(Employee employee) throws Exception {

	try {

		jobDetailsDao.saveEmployeeDetails(employee);

	}catch (Exception e){
		LOG.error("Error in fetching hotels" + e);
		throw new Exception(e);
	}
	
	
}


public List<JobDetails> filterJobDetailsByDate(Employee employee, Date fromDate, Date toDate) throws Exception {

	List<JobDetails> filteredJobDetails = null;
	
	filteredJobDetails = jobDetailsDao.findJobDetailsById(employee,fromDate, toDate);
	
	return filteredJobDetails;
}

}
