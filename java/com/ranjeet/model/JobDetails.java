package com.ranjeet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job_details")
public class JobDetails {
	
	@Id
	@Column(name="job_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int jobId;
	
	
	@ManyToOne
	@JoinColumn(name="emp_id", nullable=false)
	private Employee employee;
	
	@Column(name="part_number")
	private int partNumber;


	public int getJobId() {
		return jobId;
	}


	public void setJobId(int jobId) {
		this.jobId = jobId;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public int getPartNumber() {
		return partNumber;
	}


	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}
	
	
	
}
