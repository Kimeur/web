package demo.model;

public class EmployeeDTO {
	
	private Employee Employee;
	
	private String Department_name;
	
	
	public EmployeeDTO() {
		
	}


	public Employee getEmployee() {
		return Employee;
	}


	public void setEmployee(Employee employee) {
		Employee = employee;
	}


	public String getDepartment_name() {
		return Department_name;
	}


	public void setDepartment_name(String department_name) {
		Department_name = department_name;
	}

}
