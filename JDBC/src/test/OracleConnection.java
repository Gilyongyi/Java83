package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
	public static Connection getConnection() throws SQLException{
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="hr";
		String pwd="hr";
		Connection con =null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,user,pwd);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return con;
	}
}