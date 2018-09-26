package service;

import java.io.InputStream;
import java.util.List;

import dao.ReimbursementDAO;
import model.*;

public class ReimbursementService {

	public static List<Reimbursement> getPendingReimbursements(Employee e) {
		return new ReimbursementDAO().getPendingReimbursements(e);
	}
	
	public static List<Reimbursement> getResolvedReimbursements(Employee e){
		return new ReimbursementDAO().getResolvedReimbursements(e);
	}
	
	public static List<Reimbursement> getAllResolved(){
		return new ReimbursementDAO().getAllResolved();
	}
	
	public static List<Reimbursement> getAllPending(){
		return new ReimbursementDAO().getAllPending();
	}
	
	public static List<Reimbursement> getEmployeeReimbursements(Employee e){
		return new ReimbursementDAO().getEmployeeReimbursements(e);
	}
	
	public static int addReimbursement(Employee e, int amount, String memo) {
		return new ReimbursementDAO().addReimbursement(e, amount, memo);
	}
	
	public static int addReimbursement(Employee e, int amount, String memo, InputStream is) {
		return new ReimbursementDAO().addReimbursement(e, amount, memo,is);
	}
	
	
	public static void updateReimbursement(int r, Employee m, int pending, int approved) {
		new ReimbursementDAO().updateReimbursement(r, m, pending, approved);
	}
	
	
}
