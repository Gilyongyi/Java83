package prob;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jw.service.user.dao.UserDao;
import jw.service.user.vo.UserVO;

//@WebServlet("/ProbJoin")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("EUC_KR");		
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		HttpSession session = req.getSession(true);
		
		UserVO userVO=(UserVO)session.getAttribute("userVO");
				
		String name=req.getParameter("name");
		String gender=req.getParameter("gender");
		String []birth=req.getParameterValues("birth");
		String solar=req.getParameter("solar");
		String academic=req.getParameter("academic");
		String job=req.getParameter("job");
		String dept=req.getParameter("dept");
		String marital=req.getParameter("marital");
		String children=req.getParameter("children");
		String []phone=req.getParameterValues("phone");
		String wherenum=req.getParameter("wherenum");
		String []phonenumber=req.getParameterValues("phonenumber");
		String telecom=req.getParameter("telecom");
		String address=req.getParameter("address");
		
		userVO= new UserVO();
		
		if(!(name==null||name.equals(""))){
		userVO.setName(name);
		userVO.setGender(gender);
		userVO.setBirth(birth[0]+"."+birth[1]+"."+birth[2]);
		userVO.setSolar(solar);
		userVO.setAcademic(academic);
		userVO.setJob(job);
		userVO.setDept(dept);
		userVO.setMarital(marital);
		userVO.setChildren(children);
		userVO.setPhone(phone[0]+"-"+phone[1]+"-"+phone[2]);
		userVO.setWherenum(wherenum);
		userVO.setPhonenumber(phonenumber[0]+"-"+phonenumber[1]+"-"+phonenumber[2]);
		userVO.setTelecom(telecom);
		userVO.setAddress(address);

		UserDao useDao = new UserDao();
		useDao.addUser(userVO);
		}
		if(session.isNew()){
			session.setAttribute("name",userVO.getName());
		}
		out.println("<html>");
		out.println("<head></head>");
		out.println("<boby><center><h2>Client에서 전송된 내용</h2><p>");
		
		if(session.isNew()){
			out.println(userVO.getName()+"님 가입을 환영합니다.");
			out.println("세션 생성");
		}else{
			out.println(session.getAttribute("name")+" 님 환영합니다.");
			out.println("JSESSIONID : "+session.getId());
		}
		
		out.println("<p><p><a href='/myStudy/prob/findUserView.jsp' name=내정보보기><input type=button value='내정보보기'</a>");
		out.println("<p><p><a href='/myStudy/prob/addUserView.jsp' name=뒤로><input type=button value='뒤로'</a>");
		out.println("</center></body>");
		out.println("</html>");
	}

}//end of class
