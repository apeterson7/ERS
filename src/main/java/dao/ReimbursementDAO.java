package dao;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.Reimbursement;
import util.JDBCConnection;

public class ReimbursementDAO implements IReimbursement{

	public List<Reimbursement> getPendingReimbursements(Employee e) {
		try {
			Connection conn = JDBCConnection.getConnection();
			
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE PENDING = 1 AND E_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//finds ? and replaces with second argument (1)
			ps.setInt(1, e.getE_id());
			
			ResultSet rs = ps.executeQuery();
			
			Reimbursement r = new Reimbursement();
			
			List<Reimbursement> rmbs = new ArrayList<Reimbursement>();
			
			while(rs.next()) {
				r = new Reimbursement();
				r.setR_id(rs.getInt("r_id"));
				r.setE_id(rs.getInt("e_id"));
				r.setM_id(rs.getInt("m_id"));
				r.setAmount(rs.getInt("amount"));
				if(rs.getInt("pending") == 1) {
					r.setPending(true);
				}else {
					r.setPending(false);
				}
				if(rs.getInt("approved") == 1) {
					r.setApproved(true);
				}else {
					r.setApproved(false);
				}
				r.setMemo(rs.getString("memo"));
				
				rmbs.add(r);
			}
			return rmbs;
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reimbursement> getResolvedReimbursements(Employee e) {
		try {
			Connection conn = JDBCConnection.getConnection();
			
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE PENDING = 0 AND E_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//finds ? and replaces with second argument (1)
			ps.setInt(1, e.getE_id());
			
			ResultSet rs = ps.executeQuery();
			
			Reimbursement r = new Reimbursement();
			
			List<Reimbursement> rmbs = new ArrayList<Reimbursement>();
			
			while(rs.next()) {
				r = new Reimbursement();
				r.setR_id(rs.getInt("r_id"));
				r.setE_id(rs.getInt("e_id"));
				r.setM_id(rs.getInt("m_id"));
				r.setAmount(rs.getInt("amount"));
				if(rs.getInt("pending") == 1) {
					r.setPending(true);
				}else {
					r.setPending(false);
				}
				if(rs.getInt("approved") == 1) {
					r.setApproved(true);
				}else {
					r.setApproved(false);
				}
				r.setMemo(rs.getString("memo"));
				
				rmbs.add(r);
			}
			return rmbs;
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reimbursement> getAllResolved() {
		try {
			Connection conn = JDBCConnection.getConnection();
			
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE PENDING = 0";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Reimbursement r = new Reimbursement();
			List<Reimbursement> rmbs = new ArrayList<Reimbursement>();
			
			while(rs.next()) {
				r = new Reimbursement();
				r.setR_id(rs.getInt("r_id"));
				r.setE_id(rs.getInt("e_id"));
				r.setM_id(rs.getInt("m_id"));
				r.setAmount(rs.getInt("amount"));
				if(rs.getInt("pending") == 1) {
					r.setPending(true);
				}else {
					r.setPending(false);
				}
				if(rs.getInt("approved") == 1) {
					r.setApproved(true);
				}else {
					r.setApproved(false);
				}
				r.setMemo(rs.getString("memo"));
				
				rmbs.add(r);
			}
			return rmbs;
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reimbursement> getAllPending() {
		try {
			Connection conn = JDBCConnection.getConnection();
			
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE PENDING = 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Reimbursement r = new Reimbursement();
			List<Reimbursement> rmbs = new ArrayList<Reimbursement>();
			
			while(rs.next()) {
				r = new Reimbursement();
				r.setR_id(rs.getInt("r_id"));
				r.setE_id(rs.getInt("e_id"));
				r.setM_id(rs.getInt("m_id"));
				r.setAmount(rs.getInt("amount"));
				if(rs.getInt("pending") == 1) {
					r.setPending(true);
				}else {
					r.setPending(false);
				}
				if(rs.getInt("approved") == 1) {
					r.setApproved(true);
				}else {
					r.setApproved(false);
				}
				r.setMemo(rs.getString("memo"));
				
				rmbs.add(r);
			}
			return rmbs;
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reimbursement> getEmployeeReimbursements(Employee e) {
		try {
			Connection conn = JDBCConnection.getConnection();
			
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE E_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getE_id());
			ResultSet rs = ps.executeQuery();
			
			Reimbursement r = new Reimbursement();
			List<Reimbursement> rmbs = new ArrayList<Reimbursement>();
			
			while(rs.next()) {
				r = new Reimbursement();
				r.setR_id(rs.getInt("r_id"));
				r.setE_id(rs.getInt("e_id"));
				r.setM_id(rs.getInt("m_id"));
				r.setAmount(rs.getInt("amount"));
				if(rs.getInt("pending") == 1) {
					r.setPending(true);
				}else {
					r.setPending(false);
				}
				if(rs.getInt("approved") == 1) {
					r.setApproved(true);
				}else {
					r.setApproved(false);
				}
				r.setMemo(rs.getString("memo"));
				
				rmbs.add(r);
			}
			return rmbs;
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	public int addReimbursement(Employee e, int amount, String memo) {
		try {
			Connection conn = JDBCConnection.getConnection();
			
			
			//If the first is not the employee or the second is not the manager... then u fucked up!
			if(e.isAuth()) {
				return -1;
			}
			
			String sql = "CALL ADD_REIMBURSEMENT(?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			
			//finds ? and replaces with second argument (1)
			cs.setInt(1, e.getE_id());
			cs.setInt(2, amount);
			cs.setString(3, memo);
			cs.execute();
			
			sql = "SELECT * FROM REIMBURSEMENTS WHERE E_ID = ? AND AMOUNT = ? AND MEMO = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getE_id());
			ps.setInt(2, amount);
			ps.setString(3, memo);
			ResultSet rs = ps.executeQuery();
			
			//test this thoroughly, should get the r_id of the reimbursement record
			//just created 
			int ret_id = -1;
			
			Reimbursement r = new Reimbursement();
			while(rs.next()) {
				ret_id = rs.getInt("R_ID");
			}
			
			return ret_id;
			
		}catch(SQLException ex){
			ex.printStackTrace();
			return -1;
		}
		
		
	}
	
	public int addReimbursement(Employee e, int amount, String memo, InputStream is) {
		try {
			Connection conn = JDBCConnection.getConnection();
			
			
			//If the first is not the employee or the second is not the manager... then u fucked up!
			if(e.isAuth()) {
				return -1;
			}
			
			String sql = "CALL ADD_REIMBURSEMENT(?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			
			//finds ? and replaces with second argument (1)
			cs.setInt(1, e.getE_id());
			cs.setInt(2, amount);
			cs.setString(3, memo);
			cs.execute();
			
			sql = "SELECT R_ID FROM REIMBURSEMENTS WHERE E_ID = ? AND AMOUNT = ? AND MEMO = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getE_id());
			ps.setInt(2, amount);
			ps.setString(3, memo);
			ResultSet rs = ps.executeQuery();
			
			//test this thoroughly, should get the r_id of the reimbursement record
			//just created 
			int ret_id = -1;
			
			Reimbursement r = new Reimbursement();
			while(rs.next()) {
				ret_id = rs.getInt("R_ID");
			}
			
			try {

				PreparedStatement ps2 = conn.prepareStatement("insert into images (r_id, photo) values (?,?)");
				ps2.setInt(1, ret_id);
				ps2.setBlob(2, is);
				ps2.executeUpdate();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			return ret_id;
			
		}catch(SQLException ex){
			ex.printStackTrace();
			return -1;
		}
		
		
	}

	public void updateReimbursement(int r, Employee m, int pending, int approved) {
		try {
			Connection conn = JDBCConnection.getConnection();
			
			String sql = "CALL UPDATE_REIMBURSEMENT(?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setInt(1, r);
			cs.setInt(2, m.getE_id());
			cs.setInt(3, pending);
			cs.setInt(4, approved);
			cs.executeQuery();			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	
	
}
