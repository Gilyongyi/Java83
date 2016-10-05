package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Example02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		/*Connection con = DriverManager.getConnection(url,"scott","tiger");	
		String sql="INSERT INTO member VALUES("+no+",'"+id+"','"+pwd+"')";
		Statement stmt = con.createStatement();*/
		
		System.out.println("no �Է� : ");
		int no= sc.nextInt();
		System.out.println("id �Է� : ");
		String id = sc.next();
		System.out.println("pwd �Է� : ");
		String pwd = sc.next();
		Connection con = DriverManager.getConnection(url,"scott","tiger");
		PreparedStatement pstmt = con.prepareStatement("insert into member values(?,?,?)");
		pstmt.setInt(1,no);
		pstmt.setString(2,id);
		pstmt.setString(3,pwd);
		int confirm = pstmt.executeUpdate();
		if(confirm==1){
			System.out.println("insert �Ϸ�");
		}else{
			System.out.println("insert ����");
		}
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}

}
