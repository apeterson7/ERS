package model;

public class Employee {

	int e_id;
	String fname;
	String lname;
	String username;
	String password;
	boolean auth;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int e_id, String fname, String lname, String username, String password, boolean auth) {
		super();
		this.e_id = e_id;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.auth = auth;
	}
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAuth() {
		return auth;
	}
	public void setAuth(boolean auth) {
		this.auth = auth;
	}
	
	@Override
	public String toString() {
		return "{\"e_id\":\"" + e_id + "\",\"fname\":\"" + fname + "\",\"lname\":\"" + lname + "\",\"username\":\"" + username
				+ "\",\"password\":\"" + password + "\",\"auth\":\"" + auth + "\"}";
	}
	
	
	
}
