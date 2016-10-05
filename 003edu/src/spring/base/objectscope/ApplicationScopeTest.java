package spring.base.objectscope;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApplicationScopeTest extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res)
						throws ServletException,IOException{
		
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		ServletContext application = this.getServletContext();
		
		Integer count =(Integer)application.getAttribute("count");
		
		if(count ==null){
			out.println("::브라우저 켜고 1번째 방문");
			application.setAttribute("count", new Integer(1));
		}else{
			int changeCount = count.intValue()+1;
			out.println("::브라우저 켜고 "+changeCount+"번째 방문");
			application.setAttribute("count",new Integer(changeCount));
		}
	}
}
