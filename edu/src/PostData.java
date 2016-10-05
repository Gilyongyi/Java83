import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PostData extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{

		res.setCharacterEncoding("EUC_KR");
		
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();

		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");


		System.out.println(clientName+" : "+clientAddr);

		out.print("<html>");
		out.print("<head><title>PostData.java</title></head>");
		out.print("<body>");

		out.print("<h2>Post Test</h2>");
		out.print("<li> 이름 : "+clientName);
		out.print("<li> 주소 : "+clientAddr);

		out.print("<p><p><a href='/edu/PostData.html'>뒤로</a>");
		out.print("</body>");
		out.print("</html>");
	}
}