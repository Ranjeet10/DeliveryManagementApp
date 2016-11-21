package com.ranjeet.service;

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
		Employee employee = null;
		try {
			employee = jobDetailsDao.getEmployeeDetails(jobDetails.getEmployee().getEmployeeId());	
			jobDetails.setEmployee(employee);
			jobDetailsDao.saveJobDetails(jobDetails);

		}catch (Exception e){
			LOG.error("Error in fetching hotels" + e);
			throw new Exception(e);
		}
	}
	
	public Employee getEmployee(String employeeId) throws Exception {
		
		Employee employee = new Employee();
		
		employee = jobDetailsDao.getEmployeeDetails(employeeId);
		
		return employee;
		
	}

}
