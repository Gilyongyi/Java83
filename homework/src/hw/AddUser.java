package hw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw.UserDao;
import hw.UserVO;

//@WebServlet("/ProbJoin")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("EUC_KR");		
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
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
		
		UserVO userVO= new UserVO();
		
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
		
		out.println("<html>");
		out.println("<head><title>회원가입이 완료되었습니다.</title></head>");
		out.println("<boby><center><h2>"+userVO.getName()+"님 환영합니다</h2></center><p>");

		System.out.println(userVO.getName()+"님 환영합니다");
		
		out.println("</body>");
		out.println("</html>");
	}

}//end of class
