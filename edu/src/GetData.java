import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetData extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{

		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();

		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");

		System.out.println(clientName+" : "+clientAddr);

		out.print("<html>");
		out.print("<head><title>GetData.java</title></head>");
		out.print("<body>");

		out.print("<h2>Get Test</h2>");
		out.print("<li> 이름 : "+clientName);
		out.print("<li> 주소 : "+clientAddr);

		out.print("<p><p><a href='/edu/getData.html'>뒤로</a>");
		out.print("</body>");
		out.print("</html>");
	}
}