package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBCConnection;

public class ImageDAO implements IImages{

	public void putImage(int r_id, InputStream is) {

		try {
			Connection conn = JDBCConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement("insert into images (r_id, photo) values (?,?)");
			ps.setInt(1, r_id);
			ps.setBlob(2, is);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public InputStream getImage(int r_id) {
		try {
			Connection conn = JDBCConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement("select photo from images where r_id = ?");
			ps.setInt(1, r_id);
			
			ResultSet rs = ps.executeQuery();
			
			Blob b = null;
			while(rs.next()) {
				b = rs.getBlob("photo");
			}
			
			return b.getBinaryStream();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
