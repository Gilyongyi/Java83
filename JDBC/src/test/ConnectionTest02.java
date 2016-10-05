package test;

import java.sql.*;
public class ConnectionTest02 {
	
	public static void main(String[] args) throws Exception{
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="scott";
		String pwd="tiger";
		/*
		 * OracleDriver od = new OracleDriver();
		 * info.put("user",user);
		 * info.put("password",pwd);
		 * Connection con = od.connect(url,info);
		 */
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,user,pwd);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT*FROM product");
		
		while(rs.next()){
		String productName = rs.getString("p_name");
		//String productName = rs.getString(1);
		int productPrice = rs.getInt("p_price");
		//int productPrice = rs.getInt(2);
		
		System.out.println("상품명 : "+productName);
		System.out.println("가격 : "+productPrice);
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
