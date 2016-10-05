import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetDataKr extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{

		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();

		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");

		String clientNameKo = this.convertKo(clientName);
		String clientAddrKo= convertKo(clientAddr);

		System.out.println(clientNameKo+" : "+clientAddrKo);

		out.print("<html>");
		out.print("<head><title>GetData.java</title></head>");
		out.print("<body>");

		out.print("<h2>Get Test</h2>");
		out.print("<li> 이름 : "+clientNameKo);
		out.print("<li> 주소 : "+clientAddrKo);

		out.print("<p><p><a href='/edu/getDataKr.html'>뒤로</a>");
		out.print("</body>");
		out.print("</html>");
	}

	private String convertKo(String paramValue){
		String convertParamValue = null;
		try{
			byte[] b=paramValue.getBytes("8859_1");
			convertParamValue = new String(b,"EUC_KR");
		}catch(UnsupportedEncodingException uee){
			System.out.println("한글 변환중 Exception 발생");
			uee.printStackTrace();
		}
		return convertParamValue;
	
	}
}