<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="jw.service.user.vo.UserVO" %>
<%@ page import="jw.service.user.dao.UserDao" %>

<%if(request.getMethod().equals("GET")) {%>
	<jsp:forward page="login.html"/>;
	<% }%>
	
<%
	request.setCharacterEncoding("EUC_KR");
	
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	
	UserVO userVO = new UserVO();
	userVO.setId(id);
	userVO.setPwd(pwd);
	
	UserDao userDao=new UserDao();
	userDao.getUser(userVO);
%>

<html>
<head></head>
<body>
<h2>Login 화면</h2>
	<%if(userVO.isActive()){ %>
		<%=id%> 님 환영합니다.
		<% session.setAttribute("userVO", userVO); %>
	<%}else{ %>
		id,pwd를 확인하세요.
	<%} %>
	<p/><p/><a href='/edu/jw07/login.html'>뒤로</a>
</body>
</html>
