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
		System.out.println("삭제할 행의 no를 입력해주세요");
		int no = sc.nextInt();
		pstmt.setInt(1,no);
		pstmt.executeUpdate();
		System.out.println(no+"행이 삭제되었습니다.");
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}

}
