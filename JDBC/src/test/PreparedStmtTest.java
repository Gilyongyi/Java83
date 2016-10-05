package test;

import java.sql.*;


public class PreparedStmtTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		if(args.length!=3){
			System.out.println("���۹�� java Example02 [no��][id��][pwd��]");
			System.exit(0);
		}
		
		int no=Integer.parseInt(args[0]);
		String id=args[1];
		String pwd=args[2];
		
		String url="jdbc:oracle:thin@127.0.0.1:1521:xe";
		Class.forName("oracle.jdbd.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"scott","tiger");
		
		/*Statement stmt = con.createStatement();
		 * String createSql = "insert into member values("+no+",'"+id+"','"+pwd+"');
		 * int confirm = stmt.executeUpdate(createSql);
		*/
		
		PreparedStatement pstmt = con.prepareStatement("insert into member values(?,?,?)");
		pstmt.setInt(1,no);
		pstmt.setString(2,id);
		pstmt.setString(3,pwd);
		int confirm=pstmt.executeUpdate();
		
		if(confirm ==1){
			System.out.println("number TABLE DATA INSERT �Ϸ�");
		}else{
			System.out.println("number TABLE DATE INSERT ����");
		}
		
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
		}
}
