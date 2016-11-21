package com.ranjeet.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ranjeet.model.Employee;
import com.ranjeet.model.JobDetails;


@Transactional
@Repository
public class JobDetailDao {
	
	
	private static Logger LOG = Logger.getLogger(JobDetailDao.class);

	@Autowired
	private SessionFactory sessionFactory;


	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveJobDetails(JobDetails jobDetail) throws Exception {
		
		try {			
			int jobId = (Integer) hibernateTemplate.save(jobDetail);
			jobDetail.setJobId(jobId);
			LOG.info("Job Detail saved successfully");

		} catch (DataAccessException e) {
			LOG.debug(e.getMessage());
		}
	}
	
	public List<Employee> getAllEmployees() throws Exception {
		try {
			return hibernateTemplate.loadAll(Employee.class);
		} catch (DataAccessException e) {
			LOG.debug(e.getMessage());
			throw new Exception(e.getMessage(), e);
		}
	}
	
	public Employee getEmployeeDetails(String employeeId) throws Exception {
		Employee user = null;
		try {
			user = hibernateTemplate.get(Employee.class, employeeId);
		} catch (DataAccessException e) {
			LOG.debug(e.getMessage());
			throw new Exception(e.getMessage(), e);
		}
		return user;

	}

}
