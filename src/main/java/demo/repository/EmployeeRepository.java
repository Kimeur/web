package demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import demo.model.Employee;
import demo.model.Job;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String> {
	List<Employee> findAll();
	List<Employee> findAllByOrderBySalaryDesc();
	
	
	
	//@Query("SELECT j FROM Job j WHERE j.maxSalary > :jobId ORDER BY j.maxSalary DESC")
	//List<Job> findBymaxSalary(@Param("jobId") BigDecimal jobId);
	
	

}




