package demo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@Id
	@Column(name="EMPLOYEE_ID")
	private long employeeId;
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", salary=" + salary + ", department=" + department + ", job="
				+ job + ", jobHistories=" + jobHistories + "]";
	}

	@Column(name="SALARY")
	private long salary;

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="JOB_ID")
	private Job job;

	//bi-directional many-to-one association to JobHistory
	@OneToMany(mappedBy="employee")
	private List<JobHistory> jobHistories;

	public Employee() {
	}

	public long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<JobHistory> getJobHistories() {
		return this.jobHistories;
	}

	public void setJobHistories(List<JobHistory> jobHistories) {
		this.jobHistories = jobHistories;
	}

	public JobHistory addJobHistory(JobHistory jobHistory) {
		getJobHistories().add(jobHistory);
		jobHistory.setEmployee(this);

		return jobHistory;
	}

	public JobHistory removeJobHistory(JobHistory jobHistory) {
		getJobHistories().remove(jobHistory);
		jobHistory.setEmployee(null);

		return jobHistory;
	}

}