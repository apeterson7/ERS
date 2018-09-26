package dao;

import java.util.List;

import model.Employee;

public interface IEmployee {

	public List<Employee> getAllEmployees();
	public void updateEmployee(Employee e);
	public Employee getEmployeeById(int e_id);
	public Employee getEmployeeByUserName(String username);
	
}
