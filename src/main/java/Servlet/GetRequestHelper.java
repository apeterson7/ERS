package Servlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Employee;
import model.Reimbursement;
import service.EmployeeService;
import service.ImageService;
import service.ReimbursementService;


public class GetRequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		if(uri.equals("/ERS/Login.do")) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//System.out.println(username + " "+ password);
			Employee e = EmployeeService.getEmployeeByUsername(username);
			//System.out.println(e);
			if(e == null) {
				response.getWriter().append("Invalid Login");
			}else {
				if(e.getPassword().equals(password)) {
					//if(username.equals("test") && password.equals("password")) {	
					request.getSession().setAttribute("employee",e);
					System.out.println(request.getSession().getAttribute("employee"));
					if(e.isAuth()) {
						//manager
						response.setStatus(201);
					}else {
						//employee
						response.setStatus(202); 
					}
				}else {
					//invalid login
					response.setStatus(203);
				}
			}
			
			
		}
		
		if(uri.equals("/ERS/getName.do")) {
			response.getWriter().append(((Employee) request.getSession().getAttribute("employee")).getFname());
			//System.out.println(((Employee) request.getSession().getAttribute("employee")).getFname());
		}
		
		//Manager Functions W/o employee parameter! these work :)
		if(uri.equals("/ERS/ListEmployees.do")) {
			/*for(Employee e: EmployeeService.getAllEmployees()) {
				response.getWriter().append("<p>"+e.toString()+"</p>" +
						"<button  class=\"btn btn-default btn-block\" onclick=\"displayPending("+e.getE_id()+")\">View Pending Requests</button>"+
						"<p id=\"display"+e.getE_id()+"\"></p>");
			}*/
			response.getWriter().append("[");
			List<Employee> e = EmployeeService.getAllEmployees();
			for(int i = 0; i < e.size(); i++) {
				if(i<e.size()-1) {
					response.getWriter().append(e.get(i).toString()+",");
				}else {
					response.getWriter().append(e.get(i).toString()+"]");
				}
			}
		}
		if(uri.equals("/ERS/PendingRequests.do")) {
			/*for(Reimbursement r: ReimbursementService.getAllPending()) {
				response.getWriter().append("<button  class=\"btn btn-default btn-block\" onclick=\"approve("+r.getR_id()+")\">Approve</button>"+
						"<button  class=\"btn btn-default btn-block\" onclick=\"deny("+r.getR_id()+")\">Deny</button><p>" +
						r.toString()+"</p>");
			}*/
			response.getWriter().append("[");
			List<Reimbursement> r =  ReimbursementService.getAllPending();
			for(int i = 0; i < r.size(); i++) {
				if(i < r.size()-1) {
					response.getWriter().append(r.get(i).toString()+",");
				}else {
					response.getWriter().append(r.get(i).toString()+"]");
				}
			}
		}
		if(uri.equals("/ERS/ResolvedRequest.do")) {
			/*for(Reimbursement r: ReimbursementService.getAllResolved()) {
				response.getWriter().append("<p class=\"inline\">" +
						r.toString()+"</p>");
				}*/
			response.getWriter().append("[");
			List<Reimbursement> r =  ReimbursementService.getAllResolved();
			for(int i = 0; i < r.size(); i++) {
				if(i < r.size()-1) {
					response.getWriter().append(r.get(i).toString()+",");
				}else {
					response.getWriter().append(r.get(i).toString()+"]");
				}
			}
		}
		
		//Employee specific requests for Mananger 
			//List Employees creates buttons that call functions defined in Manager.html 
			//that are passed e_id of employees that they are associated with 
		
		//the e_id is sent by a function attached to a button created by viewEmployees
		if(uri.equals("/ERS/EmployeePendingRequests.do")) {
			
			
			Employee e = EmployeeService.getEmployeeByID(Integer.parseInt(request.getParameter("id")));
			/*System.out.println(e);
			
			for(Reimbursement r: ReimbursementService.getPendingReimbursements(e)) {
				response.getWriter().append("<button  class=\"btn btn-default btn-block\" onclick=\"approve("+r.getR_id()+")\">Approve</button><p class=\"inline\">"+
						"<button  class=\"btn btn-default btn-block\" onclick=\"deny("+r.getR_id()+")\">Deny</button><p>" +
						r.toString()+"</p>");
				}*/
			
			response.getWriter().append("[");
			List<Reimbursement> r =  ReimbursementService.getPendingReimbursements(e);
			for(int i = 0; i < r.size(); i++) {
				if(i < r.size()-1) {
					response.getWriter().append(r.get(i).toString()+",");
				}else {
					response.getWriter().append(r.get(i).toString()+"]");
				}
			}
			
			
		}
		
		//Employee Specific Requests for Employee
		// This methods get the employee object attached the session (they are specific to the employee logged in)
		if(uri.equals("/ERS/EmployeeRequests.do")) {
			
			Employee e = (Employee) request.getSession().getAttribute("employee");
			
			response.getWriter().append("[");
			List<Reimbursement> r =  ReimbursementService.getEmployeeReimbursements(e);
			for(int i = 0; i < r.size(); i++) {
				if(i < r.size()-1) {
					response.getWriter().append(r.get(i).toString()+",");
				}else {
					response.getWriter().append(r.get(i).toString()+"]");
				}
			}
		}
		
	
		if(uri.equals("/ERS/EmployeeMyPendingRequests.do")) {
			Employee e = (Employee) request.getSession().getAttribute("employee");
			
			response.getWriter().append("[");
			List<Reimbursement> r =  ReimbursementService.getPendingReimbursements(e);
			for(int i = 0; i < r.size(); i++) {
				if(i < r.size()-1) {
					response.getWriter().append(r.get(i).toString()+",");
				}else {
					response.getWriter().append(r.get(i).toString()+"]");
				}
			}
		}
		
		if(uri.equals("/ERS/EmployeeMyResolvedRequests.do")) {
			
			Employee e = (Employee) request.getSession().getAttribute("employee");
			response.getWriter().append("[");
			List<Reimbursement> r =  ReimbursementService.getResolvedReimbursements(e);
			for(int i = 0; i < r.size(); i++) {
				if(i < r.size()-1) {
					response.getWriter().append(r.get(i).toString()+",");
				}else {
					response.getWriter().append(r.get(i).toString()+"]");
				}
			}
		}
		
		if(uri.equals("/ERS/EmployeeMyInfo.do")) {
			Employee e = (Employee) request.getSession().getAttribute("employee");
			/*
			response.getWriter().append("<p>First Name: "+e.getFname()+"</p><span><input style=\"display:inline-block\" class=\"form-control\" id=\"fname\" placeholder=\"Update First Name\"></input></span>");
			response.getWriter().append("<p>Last Name: "+e.getLname()+"</p><input class=\"form-control\" id=\"lname\" placeholder=\"Update Last Name\"></input>");
			response.getWriter().append("<p>Username: "+e.getUsername()+"</p><input class=\"form-control\" id=\"uname\" placeholder=\"Update Username\"></input>");
			StringBuilder pwrd = new StringBuilder();
			for(int i = 0; i < e.getPassword().length(); i++) {
				pwrd.append("*");
			}
			response.getWriter().append("<p>Password "+pwrd.toString()+"</p><input id=\"pword\" class=\"form-control\" placeholder=\"Update Password\"></input>");
			response.getWriter().append("<br><br><button class=\"btn btn-default btn-block\" onclick=\"update()\">Update</button>");
			*/
			response.getWriter().append(e.toString());
		}
		
		if(uri.equals("/ERS/updateInfo.do")) {
			Employee e = (Employee) request.getSession().getAttribute("employee");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String uname = request.getParameter("uname");
			String pword = request.getParameter("pword");
			if(fname != "") {
				e.setFname(fname);
			}
			if(lname != "") {
				e.setLname(lname);
			}
			if(uname != "") {
				e.setUsername(uname);
			}
			if(pword != "") {
				e.setPassword(pword);
			}
			EmployeeService.updateEmployee(e);
			System.out.println(e);
			
		}
		
		if(uri.equals("/ERS/NewRequest.do")) {
			Employee e = (Employee) request.getSession().getAttribute("employee");
			try {
				Integer amount = Integer.parseInt(request.getParameter("amount"));
				String memo = request.getParameter("memo");
				ReimbursementService.addReimbursement(e,amount,memo);
				response.getWriter().append("Success");
			}catch(NumberFormatException exception) {
				response.getWriter().append("Input Error, try again");
			}
		}
		
		if(uri.equals("/ERS/NewRequestImage.do")) {
			Employee e = (Employee) request.getSession().getAttribute("employee");
			try {
				Integer amount = Integer.parseInt(request.getParameter("amount"));
				String memo = request.getParameter("memo");
				Part myFile = request.getPart("image");
				
				Integer r_id = ReimbursementService.addReimbursement(e,amount,memo,myFile.getInputStream());
				ImageService.putImage(r_id, myFile.getInputStream());
				
				response.getWriter().append("Success");
				
			}catch(NumberFormatException exception) {
				response.getWriter().append("Input Error, try again");
			}
		}
		
		
		
		if(uri.equals("/ERS/Logout.do")) {
			request.getSession().invalidate();
			response.setStatus(201);
		}
		
		if(uri.equals("/ERS/approve.do")) {
			Employee m = (Employee) request.getSession().getAttribute("employee");
			Integer approved = Integer.parseInt(request.getParameter("approved"));
			System.out.println("here");
			System.out.println(m + " approved:"+ approved);
			
			int r_id = Integer.parseInt(request.getParameter("id"));
			ReimbursementService.updateReimbursement(r_id, m, 0, approved);
		}
		
		if(uri.equals("/ERS/deny.do")) {
			Employee m = (Employee) request.getSession().getAttribute("employee");
			Integer approved = Integer.parseInt(request.getParameter("approved"));
			System.out.println("here");
			System.out.println(m + " approved:"+ approved);
			
			int r_id = Integer.parseInt(request.getParameter("id"));
			ReimbursementService.updateReimbursement(r_id, m, 0, approved);
		}
		
//		if(uri.equals("/ERS/getImage.do")){
////			System.out.println(uri);
////			String[] uriList = uri.split("?");
////			System.out.println(uriList);
////			Integer r_id = Integer.parseInt(uriList[1]);
//			Integer r_id = 103;
//			//FileOutputStream outputStream = new FileOutputStream(new File("src/main/resources/result.jpg"));
//
//			ByteArrayOutputStream os = new ByteArrayOutputStream();
//			
//			int read = 0;
//			byte[] buffer = new byte[1024];
//			
//			InputStream fis = ImageService.getImage(r_id);
//			while ((read = fis.read(buffer)) != -1) {
//				os.write(buffer, 0, read);
//			}
//			byte[] imageBytes = os.toByteArray();
//
//		    response.setContentType("image/jpeg");
//		    response.setContentLength(imageBytes.length);
//		    response.getOutputStream().write(imageBytes);
//		}
		if(uri.equals("/ERS/putImage.do")) {
			System.out.println("In Servlet");
			Part myFile = request.getPart("image");
			
			//System.out.println("In Servlet 2");
			System.out.println(myFile);
			ImageService.putImage(2, myFile.getInputStream());
			//response.getWriter().append("Success");
		}
	}
	
	

}

