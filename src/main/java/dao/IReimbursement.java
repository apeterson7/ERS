package dao;

import java.util.List;

import model.*;

public interface IReimbursement {

	public List<Reimbursement> getPendingReimbursements(Employee e);
	public List<Reimbursement> getResolvedReimbursements(Employee e);
	public List<Reimbursement> getAllResolved();
	public List<Reimbursement> getAllPending();
	public List<Reimbursement> getEmployeeReimbursements(Employee e);
	public int addReimbursement(Employee e, int amount, String memo);
	public void updateReimbursement(int r, Employee m, int pending, int approved);
	
}

