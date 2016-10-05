<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	1 .pageContext EL 내장객체를 이용한 requestURI : ${pageContext.request.requestURI }<br/>
	
	2.pageContext EL 내장객체를 이용한 session 의 id : ${pageContext.session.id }<br/>
	
	3.Expression tag 사용 : <%=pageContext.getSession().getId() %><br/>
	
	4.이름 : <%=request.getParameter("name") %><br/>
	
	5.주소 : ${param.addr }<br/>
	<% String sw[] = request.getParameterValues("sw"); %>
	6.선택한 소프트웨어 : <%=sw[0] %><br/>
	6.선택한 소프트웨어 : ${paramValues.sw[1] }<br/>
	6.선택한 소프트웨어 : ${paramValues.sw[2] }<br/>
	
	7.쿠키에 저장된 JSESSIONID name ${cookie.JSESSIONID.name }<br/>
	7.쿠키에 저장된 JSESSIONID value ${cookie.JSESSIONID.value }<br/>
	
</body>
</html>