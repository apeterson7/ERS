package service;

import java.util.List;

import dao.EmployeeDAO;
import model.Employee;

public class EmployeeService {
	
	public static List<Employee> getAllEmployees(){
		return new EmployeeDAO().getAllEmployees();
	}

	public static void updateEmployee(Employee e) {
		new EmployeeDAO().updateEmployee(e);
	}
	
	public static Employee getEmployeeByID(int e_id) {
		return new EmployeeDAO().getEmployeeById(e_id);
	}
	
	public static Employee getEmployeeByUsername(String username) {
		return new EmployeeDAO().getEmployeeByUserName(username);
	}
}
