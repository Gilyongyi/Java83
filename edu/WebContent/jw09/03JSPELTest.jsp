<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	1 .pageContext EL ���尴ü�� �̿��� requestURI : ${pageContext.request.requestURI }<br/>
	
	2.pageContext EL ���尴ü�� �̿��� session �� id : ${pageContext.session.id }<br/>
	
	3.Expression tag ��� : <%=pageContext.getSession().getId() %><br/>
	
	4.�̸� : <%=request.getParameter("name") %><br/>
	
	5.�ּ� : ${param.addr }<br/>
	<% String sw[] = request.getParameterValues("sw"); %>
	6.������ ����Ʈ���� : <%=sw[0] %><br/>
	6.������ ����Ʈ���� : ${paramValues.sw[1] }<br/>
	6.������ ����Ʈ���� : ${paramValues.sw[2] }<br/>
	
	7.��Ű�� ����� JSESSIONID name ${cookie.JSESSIONID.name }<br/>
	7.��Ű�� ����� JSESSIONID value ${cookie.JSESSIONID.value }<br/>
	
</body>
</html>