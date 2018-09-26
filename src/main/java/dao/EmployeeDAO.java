package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.JDBCConnection;

public class EmployeeDAO implements IEmployee{

	public List<Employee> getAllEmployees(){
		try {
			Connection conn = JDBCConnection.getConnection();
		
			
			String sql = "SELECT * FROM EMPLOYEES WHERE AUTH = 0";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Employee> employees = new ArrayList<Employee>();
			Employee e;
			
			while(rs.next()) {
				e  = new Employee();
				e.setE_id(rs.getInt("E_ID"));
				e.setFname(rs.getString("FNAME"));
				e.setLname(rs.getString("LNAME"));
				e.setUsername(rs.getString("UN"));
				e.setPassword(rs.getString("PW"));
				if(rs.getInt("AUTH") == 1) {
					e.setAuth(true);
				}else {
					e.setAuth(false);
				}
				employees.add(e);
			}
			
			return employees;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

	public void updateEmployee(Employee e) {
		try {
			Connection conn = JDBCConnection.getConnection();
			
			String sql = "UPDATE EMPLOYEES SET FNAME = ?, LNAME = ?, UN = ?, PW = ?, AUTH = ? WHERE E_ID = ?";
			PreparedStatement ps = conn.prepareCall(sql);
			
			ps.setString(1, e.getFname());
			ps.setString(2, e.getLname());
			ps.setString(3, e.getUsername());
			ps.setString(4, e.getPassword());
			if(e.isAuth()) {
				ps.setInt(5, 1);
			}else {
				ps.setInt(5, 0);
			}
			ps.setInt(6, e.getE_id());
			
			ps.executeQuery();			
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}

	public Employee getEmployeeById(int e_id) {
		
		try {
			Connection conn = JDBCConnection.getConnection();
			
			
			String sql = "SELECT * FROM EMPLOYEES WHERE E_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e_id);
			
			ResultSet rs = ps.executeQuery();
		
			
			Employee e = new Employee();
			while(rs.next()) {
				e  = new Employee();
				e.setE_id(rs.getInt("E_ID"));
				e.setFname(rs.getString("FNAME"));
				e.setLname(rs.getString("LNAME"));
				e.setUsername(rs.getString("UN"));
				e.setPassword(rs.getString("PW"));
				if(rs.getInt("AUTH") == 1) {
					e.setAuth(true);
				}else {
					e.setAuth(false);
				}
			}
			
			return e;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public Employee getEmployeeByUserName(String username) {
		
		try {
			Connection conn = JDBCConnection.getConnection();
			
			
			String sql = "SELECT * FROM EMPLOYEES WHERE UN = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
		
			
			Employee e = new Employee();
			while(rs.next()) {
				e  = new Employee();
				e.setE_id(rs.getInt("E_ID"));
				e.setFname(rs.getString("FNAME"));
				e.setLname(rs.getString("LNAME"));
				e.setUsername(rs.getString("UN"));
				e.setPassword(rs.getString("PW"));
				if(rs.getInt("AUTH") == 1) {
					e.setAuth(true);
				}else {
					e.setAuth(false);
				}
			}
			
			return e;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
