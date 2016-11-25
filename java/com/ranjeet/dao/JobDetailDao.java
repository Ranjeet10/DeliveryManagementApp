package com.ranjeet.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
	
	public Employee getEmployeeDetails(int employeeId) throws Exception {
		Employee employee = null;
		try {
			employee = hibernateTemplate.get(Employee.class, employeeId);
		} catch (DataAccessException e) {
			LOG.debug(e.getMessage());
			throw new Exception(e.getMessage(), e);
		}
		return employee;

	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeDetailsFromActualEmployeeId(int employeeId) throws Exception {
		
		List<Employee> employees = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Employee.class)
					.createAlias("employee", "e")
					.add(Restrictions.eq("e.empId",employeeId));
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			employees = criteria.list();
			System.out.println(employees);
		} catch (DataAccessException e) {
			LOG.debug(e.getMessage());
			throw new Exception(e.getMessage(), e);
		}
		return employees;

	}
	
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public Employee findEmployeeByEmployeeId(int employeeId) {
		@SuppressWarnings("unchecked")
		List<Employee> employees = (List<Employee>) hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Employee.class)
				.add(Restrictions.eq("employeeId", employeeId)));
		if(!CollectionUtils.isEmpty(employees)) {
			return employees.get(0);
		}
		return null;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@SuppressWarnings("unchecked")
	public List<JobDetails> findJobDetailsById(int empId) throws Exception {
		List<JobDetails> jobDetails = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(JobDetails.class)
					.createAlias("employee", "e")
					.add(Restrictions.eq("e.id", empId));
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			jobDetails = criteria.list();
		} catch (DataAccessException e) {
			LOG.debug(e.getMessage());
			throw new Exception(e.getMessage(), e);
		}
		return jobDetails;
		
	}

	public void saveEmployeeDetails(Employee employee) throws Exception {

		try {			
			int id = (Integer) hibernateTemplate.save(employee);
			employee.setId(id);
			LOG.info("Employee Details saved successfully");

		} catch (DataAccessException e) {
			LOG.debug(e.getMessage());
		}
		
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@SuppressWarnings("unchecked")
	public List<JobDetails> findJobDetailsById(int empId, Date fromDate, Date toDate) throws Exception {

		List<JobDetails> filteredjobDetails = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(JobDetails.class)
					//.createAlias("employee", "e")
					.createAlias("savedDate", "savedDate")
					//.add(Restrictions.eq("e.id", empId))
					.add(Restrictions.between("savedDate", fromDate, toDate));
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			filteredjobDetails = criteria.list();
		} catch (DataAccessException e) {
			LOG.debug(e.getMessage());
			throw new Exception(e.getMessage(), e);
		}
		return filteredjobDetails;
		
	}
	

}
