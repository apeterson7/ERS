package util;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCConnection {

	public static Connection conn;
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
//				Properties props = new Properties();
//				FileInputStream in; 
//				in = new FileInputStream("src/main/resources/connection.properties");
//				props.load(in);
//				
//				String url = props.getProperty("url");
//				String username = props.getProperty("username");
//				String password = props.getProperty("password");
				
				String url = "jdbc:oracle:thin:@dbpeterson.cbwlco05uxwf.us-east-2.rds.amazonaws.com:1521:ORCL";
				String username = "alexcpeterson7";
				String password = "NewPassword21!!";
				
				conn = DriverManager.getConnection(url, username, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
			}
		}
		
		return conn;
		
	}
	
	
}
