package struts2.base.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * FileName : FilterUse.java
 * 1. http://127.0.0.1:8080/001Filter/FilterUse �� �����ϸ�....
 * 2. web.xml�� ������ ������ �����Ͽ� ����� Ȯ���ϸ�....
		<filter>
				<filter-name>SetContentTypeFilter</filter-name>
				<filter-class>struts2.base.control.filter.SetContentTypeFilter</filter-class>
				<init-param>
					<param-name>ServletSPEC</param-name>
					<param-value>since2.3</param-value>
				</init-param>
			</filter>
			<filter-mapping>
				<filter-name>SetContentTypeFilter</filter-name>
				<url-pattern>/FilterUse</url-pattern>
			</filter-mapping>
	 3. �������� Ȯ������... �ѱ�ó����... 
 */
public class FilterUse extends HttpServlet {
	@Override
	protected void doGet (	HttpServletRequest request, 
												HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println( getClass()+".doGet() start........]");//<== ������
		
		//==> �Ʒ��� ���๮�� �ʿ� ����... 
		//:: response.setContentType("text/html;charset=EUC_KR");
		//==> ���Ϳ��� ��ó���Ͽ� �� Servlet�� ���������....:: �������� �ѱ�ó����
		//==> consoleȮ�� : ���͸� ���� ��ó�� / servlet ���� / ���͸� ���� ��ó�� ���� Ȯ������.

		PrintWriter out = response.getWriter();
		
		out.println("Hello... : �ȳ��ϼ���...");
		
		System.out.println( getClass()+".doGet() end........]");//<== ������
	}
}