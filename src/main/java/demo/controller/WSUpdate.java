package demo.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Employee;
import demo.model.Job;
import demo.repository.EmployeeRepository;
import demo.repository.JobRepository;

@RestController
public class WSUpdate {
	@Autowired
	private JobRepository jobRepository;
	
    @RequestMapping("/job")
    public List<Job> job(@RequestBody String salary) {
    	System.out.println(salary);
    	List<Job> jobs = jobRepository.findBymaxSalary(new BigDecimal(salary.replaceAll("\"","")));
    System.out.println("######" + jobs.size());
    	return jobs;
    	
        
    }
    
}