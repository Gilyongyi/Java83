package jw04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/Login")
public class LoginBeanVODao extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("EUC_KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		
		UserVO userVO= new UserVO();
		userVO.setId(id);
		userVO.setPwd(pwd);
		
		UserDao useDao = new UserDao();
		useDao.getUser(userVO);
						
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>Login 화면</h2>");
		
		if(userVO.isActive()){
			out.println(id+"님 환영합니다");
		}else{
			out.println("id,pwd를 확인하세요");
		}
		out.println("<p><p><a href='/edu/jw04/login.html'>뒤로</a>");
		out.println("</body>");
		out.println("</html>");
	}
}

