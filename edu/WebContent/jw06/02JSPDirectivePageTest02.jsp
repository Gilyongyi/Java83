<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page errorPage="03JSPErrorPage.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page buffer="none"%>
<html>
<body>
	�ȳ��ϼ��� html ����<br/>
	buffer ��ü ũ�� : <%=out.getBufferSize()%><br/>
	buffer �ܿ� ũ�� : <%=out.getRemaining() %><br/>
	
	<hr/>
	������  Exception �߻�...
	
	<% int number=0;%>
	<% number =Integer.parseInt("a"); %>
	<%="number : "+number %>
	<hr/>
	�ȳ��ϼ��� ��
</body>
</html>