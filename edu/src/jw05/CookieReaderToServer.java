package jw05;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieReaderToServer extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("EUC_KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		Cookie[] cookies = req.getCookies();
		String userName=null;
		
		if(cookies!=null){
			out.println("ƒÌ≈∞¿’¿Ω");
			for(int i=0;i<cookies.length;i++){
				String name=cookies[i].getName();
				String value=URLDecoder.decode(cookies[i].getValue());
				System.out.println("¿¸º€µ» ƒÌ≈∞ : "+name+"="+value);
				
				if(name.equals("name")){
					userName=value;
				}
			}
		}else{
			out.println("ƒÌ≈∞æ¯¿Ω");
		}
		out.println("<html><body>");
		if(userName ==null){
			out.println("√≥¿Ω");
		}else{
			out.println(userName+"¥‘ »Øøµ");
		}
		 out.println("</body></html>");
	}


}
