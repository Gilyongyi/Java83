<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="jw.service.user.vo.UserVO" %>
<%
	UserVO userVO = (UserVO)session.getAttribute("userVO");
	if(userVO==null){
		userVO = new UserVO();
	}
%>

<%if(!userVO.isActive()){%>
	<jsp:include page="../jw07/login.html"/>
	<br/><br/>
	<a href="/edu/jw07/addUser.html">회원가입</a>
	<% }else{ %>
		<%=userVO.getId() %>님 로그인 하셧습니댜.
		<br/><br/>
		<form method="post" action="<%=request.getRequestURL()%>">
			URL = <%=request.getRequestURL() %><br/>
			URI = <%=request.getRequestURI() %><br/>
			Path = <%=request.getContextPath() %>
			<input type = "submit" value ="logout">
			</form> 
			<br/><br/>
	<%} %>
<%if(request.getMethod().equals("POST")){
	session.removeAttribute("userVO");
	response.sendRedirect("/edu/jw08/logout.jsp");
}
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>