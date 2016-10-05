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
	1. Servlet ����� ������ �Ǵ� ���� ó���ؾ� �� ������ �ִٸ�....
	     ( �� :  res.setContentType("text/html;charset=EUC_KR\")�� ������ �����̶��...)
	2. Servlet ������ ���Ϳ��� �̸�ó�� �Ѵٸ�...
	3. ��ó�� �� �� �ִ� ����� ������...  javax.servlet.Filter�� ������  class�� �ۼ� ��
	    web.xml�� 1. Filter���� Ŭ���� ��� ��  2. ���͸� ����� Servlet ���
	 
	 ==>1. Filter���� Ŭ���� ���  
	<filter>
		<filter-name>SetContentTypeFilter</filter-name>
		<filter-class>struts2.base.control.filter.SetContentTypeFilter</filter-class>
		<init-param>
			<param-name>ServletSPEC</param-name>
			<param-value>since2.3</param-value>
		</init-param>
	</filter>
	==> 2. ���͸� ����� Servlet ���
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
		System.out.println("Filter��  "+fConfig.getInitParameter("ServletSPEC")+" ����.");
		System.out.println("========================");		
	}

	public void doFilter (	ServletRequest request, 
											ServletResponse response, 
											FilterChain chain ) throws IOException, ServletException {
		
		System.out.println( getClass()+"doFilter() start........]");//<== ������
		
		//Filer�� �̿��ϸ�, Serlvet ������  1. ��ó�� 2. ��ó�� �� ����
		//==>1. ��ó�� ���� 
		// �� ������ ��ó���� charset=euc-kr�� ��ó����. 
		response.setContentType("text/html;charset=EUC_KR");
		
		System.out.println("### before chain.doFilter().....###\n");
		//==>�Ʒ��� chain.doFilter(request,response)�� �ǹ� :  ������ servlet/JSPȣ��κ�
		chain.doFilter(request,response);
		System.out.println("\n###after chain.doFilter().....###");

		//==>2. ��ó������. ::  �������� ��ó���� ����..
		System.out.println( getClass()+"doFilter() end........]");//<== ������
	}
	
	public void destroy() {
		System.out.println( getClass()+".destroy() Method");
	}
}