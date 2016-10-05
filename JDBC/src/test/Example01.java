package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Example01 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		String createSql=
				"CREATE TABLE member"+
				"(no	NUMBER, "+
				"id	VARCHAR2(10),"+
				"pwd  VARCHAR2(10))";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection(url,"scott","tiger");
		stmt = con.createStatement();
		System.out.println(stmt.executeUpdate(createSql));
		
		if(stmt!=null)
			stmt.close();
		if(con != null)	
			con.close();
	}

}
