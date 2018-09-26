package model;

public class Reimbursement {

	int r_id;
	int e_id;
	int m_id;
	int amount;
	boolean pending;
	boolean approved;
	String memo;
	
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int r_id, int e_id, int m_id, int amount, boolean pending, boolean approved, String memo) {
		super();
		this.r_id = r_id;
		this.e_id = e_id;
		this.m_id = m_id;
		this.amount = amount;
		this.pending = pending;
		this.approved = approved;
		this.memo = memo;
	}
	
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public boolean isPending() {
		return pending;
	}
	public void setPending(boolean pending) {
		this.pending = pending;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "{\"r_id\":\"" + r_id + "\",\"e_id\":\"" + e_id + "\",\"m_id\":\"" + m_id + "\", \"amount\":\"" + amount + "\", \"pending\":\""
				+ pending + "\", \"approved\":\"" + approved + "\", \"memo\":\"" + memo + "\"}";
		
	}
	
	
	
}
