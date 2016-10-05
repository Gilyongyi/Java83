package prob;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jw.service.user.dao.UserDao;
import jw.service.user.vo.UserVO;

public class FindUser extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("EUC_KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();

		String name=req.getParameter("name");
		
		Cookie[] cookies = req.getCookies();
		if(cookies !=null){
			for(int i=0;i<cookies.length;i++){
				System.out.println("쿠키저장정보 : "+cookies[i].getName()+":"+
			cookies[i].getValue());
				System.out.println("\n");
			}
		}
		UserVO userVO=new UserVO();
		userVO.setName(name);
		
		UserDao userDao=new UserDao();
		userVO = userDao.findUser(name);
		
		HttpSession session = req.getSession(false);
		if(session!=null){
			out.println("JSESSIONID : "+session.getId());
			
		}else{
			out.println("처음 접속하셨습니다.");
		}
		out.println("<html>");
		out.println("<head><title>내정보 보기</title></head>");
		out.println("<body><center>내정보보기<br/>");
		out.println(userDao.findUser(name));
		out.println("<p><p><a href='/myStudy/prob/findUserView.jsp' name=내정보보기><input type=button value='내정보보기'</a>");
		out.println("<p><p><a href='/myStudy/prob/updateUserView.jsp' name=내정보수정><input type=button value='내정보수정'</a>");
		out.println("</center></body>");
		out.println("</html>");
	}

}
