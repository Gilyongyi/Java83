package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.OracleConnection1;


//@WebServlet("/Login")
public class LoginTest01 extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("EUC_KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		
		String fromDbId = null;
		String fromDbPwd = null;
		
		try{
		PreparedStatement pstmt = OracleConnection1.getConnection()
				.prepareStatement("SELECT id,pwd FROM users "+
														"WHERE id=?");
			pstmt.setString(1,id);
			ResultSet rs= pstmt.executeQuery();
			
			if(rs.next()){
				fromDbId = rs.getString("id");
				fromDbPwd = rs.getString("pwd");
				System.out.println("db���� Ȯ�� �� id,pwd ==> :"+fromDbId+" : "+fromDbPwd);
			}else{
				System.out.println("db�� client�� �Է��� <"+id+">�� <"+pwd+"> �� �����ϴ�.");
			}
		
			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
						
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>Login ȭ��</h2>");
		
		if(fromDbId!= null && fromDbPwd!=null && fromDbId.equals(id) && fromDbPwd.equals(pwd)){
			out.println(id+"�� ȯ���մϴ�");
		}else{
			out.println("id,pwd�� Ȯ���ϼ���");
		}
		out.println("<p><p><a href='/edu/jw04/login.html'>�ڷ�</a>");
		out.println("</body>");
		out.println("</html>");
	}
}

