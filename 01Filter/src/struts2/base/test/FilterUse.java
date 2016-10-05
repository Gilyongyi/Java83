package struts2.base.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * FileName : FilterUse.java
 * 1. http://127.0.0.1:8080/001Filter/FilterUse 로 샐행하면....
 * 2. web.xml에 설정된 내용을 참조하여 결과를 확인하면....
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
	 3. 실행결과를 확인하자... 한글처리는... 
 */
public class FilterUse extends HttpServlet {
	@Override
	protected void doGet (	HttpServletRequest request, 
												HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println( getClass()+".doGet() start........]");//<== 디버깅용
		
		//==> 아래의 실행문은 필요 없다... 
		//:: response.setContentType("text/html;charset=EUC_KR");
		//==> 필터에서 선처리하여 본 Servlet이 수행됨으로....:: 실행결과는 한글처리됨
		//==> console확인 : 필터를 거쳐 선처리 / servlet 수행 / 필터를 거쳐 후처리 됨을 확인하자.

		PrintWriter out = response.getWriter();
		
		out.println("Hello... : 안녕하세요...");
		
		System.out.println( getClass()+".doGet() end........]");//<== 디버깅용
	}
}