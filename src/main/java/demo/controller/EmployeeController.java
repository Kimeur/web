package demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.springframework.ui.Model;

import demo.model.Employee;
import demo.model.Job;
import demo.repository.EmployeeRepository;
import demo.repository.JobRepository;

@Controller
public class EmployeeController {
	@Autowired
	public EmployeeRepository employeeRepository;
	
    @RequestMapping("/employee")
    public List<Employee> employee( Model model) {
    	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    	

    	List<Employee> employee = employeeRepository.findAllByOrderBySalaryDesc();
    	System.out.println("ok");
    	try {
			String employeeJson = ow.writeValueAsString(employee.get(5));
			model.addAttribute("employeeJson", employeeJson);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated cat	ch block
			e.printStackTrace();
		}

    	model.addAttribute("employee", employee);
    	System.out.println(employee.get(5).getEmployeeId());
    	return employee;
    }
    	   
    
}
