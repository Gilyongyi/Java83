<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page errorPage="03JSPErrorPage.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page buffer="none"%>
<html>
<body>
	안녕하세요 html 시작<br/>
	buffer 전체 크기 : <%=out.getBufferSize()%><br/>
	buffer 잔여 크기 : <%=out.getRemaining() %><br/>
	
	<hr/>
	인위적  Exception 발생...
	
	<% int number=0;%>
	<% number =Integer.parseInt("a"); %>
	<%="number : "+number %>
	<hr/>
	안녕하세요 끝
</body>
</html>