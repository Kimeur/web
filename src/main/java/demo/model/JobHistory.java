package demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the job_history database table.
 * 
 */
@Entity
@Table(name="job_history")
@NamedQuery(name="JobHistory.findAll", query="SELECT j FROM JobHistory j")
public class JobHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JobHistoryPK id;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="JOB_ID")
	private Job job;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID",insertable = false, updatable = false)
	private Employee employee;

	public JobHistory() {
	}

	public JobHistoryPK getId() {
		return this.id;
	}

	public void setId(JobHistoryPK id) {
		this.id = id;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}