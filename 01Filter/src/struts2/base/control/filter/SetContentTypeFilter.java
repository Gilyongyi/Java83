package struts2.base.control.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
	FielName : SetContentTypeFilter.java
	1. Servlet 실행시 공통적 또는 선행 처리해야 할 사항이 있다면....
	     ( 예 :  res.setContentType("text/html;charset=EUC_KR\")은 공통적 사항이라면...)
	2. Servlet 수행전 필터에서 미리처리 한다면...
	3. 선처리 할 수 있는 기능을 정의한...  javax.servlet.Filter를 구현한  class를 작성 후
	    web.xml에 1. Filter구현 클래스 등록 후  2. 필터를 통과할 Servlet 등록
	 
	 ==>1. Filter구현 클래스 등록  
	<filter>
		<filter-name>SetContentTypeFilter</filter-name>
		<filter-class>struts2.base.control.filter.SetContentTypeFilter</filter-class>
		<init-param>
			<param-name>ServletSPEC</param-name>
			<param-value>since2.3</param-value>
		</init-param>
	</filter>
	==> 2. 필터를 통과할 Servlet 등록
	<filter-mapping>
		<filter-name>SetContentTypeFilter</filter-name>
		<url-pattern>/FilterUse</url-pattern>
	</filter-mapping>
*/
public class SetContentTypeFilter implements Filter {
	/// Life Cycle Method OverRiding
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("========================");
		System.out.println( getClass()+".init() Method");
		System.out.println("Filter는  "+fConfig.getInitParameter("ServletSPEC")+" 지원.");
		System.out.println("========================");		
	}

	public void doFilter (	ServletRequest request, 
											ServletResponse response, 
											FilterChain chain ) throws IOException, ServletException {
		
		System.out.println( getClass()+"doFilter() start........]");//<== 디버깅용
		
		//Filer를 이용하면, Serlvet 수행전  1. 전처리 2. 후처리 가 가능
		//==>1. 전처리 시작 
		// 본 예제는 전처리로 charset=euc-kr를 전처리함. 
		response.setContentType("text/html;charset=EUC_KR");
		
		System.out.println("### before chain.doFilter().....###\n");
		//==>아래의 chain.doFilter(request,response)의 의미 :  수행할 servlet/JSP호출부분
		chain.doFilter(request,response);
		System.out.println("\n###after chain.doFilter().....###");

		//==>2. 후처리시작. ::  본에제는 후처리는 없음..
		System.out.println( getClass()+"doFilter() end........]");//<== 디버깅용
	}
	
	public void destroy() {
		System.out.println( getClass()+".destroy() Method");
	}
}