package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Example03 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection(url,"scott","tiger");
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM member WHERE no=?");
		System.out.println("������ ���� no�� �Է����ּ���");
		int no = sc.nextInt();
		pstmt.setInt(1,no);
		pstmt.executeUpdate();
		System.out.println(no+"���� �����Ǿ����ϴ�.");
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}

}
