package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Example04 {
			
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		PreparedStatement tstmt = OracleConnection.getConnection().prepareStatement("SELECT*FROM member");
		ResultSet rs = tstmt.executeQuery();
		
		while(rs.next()){
		int no = rs.getInt("no");
		String id = rs.getString("id");
		String pwd1 = rs.getString("pwd");
		System.out.print("회원정보 =>");
		System.out.print("  번호 : "+no);
		System.out.print("  id : "+id);
		System.out.print("  pwd : "+pwd1);
		System.out.println("");
		}
		rs.close();
		tstmt.close();
		OracleConnection.getConnection().close();
	}

}
