<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="spring.model1.service.user.vo.UserVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% UserVO userVO =(UserVO)session.getAttribute("userVO"); %>
<% if(userVO==null|| !userVO.isActive()){ %>
	<jsp:forward page="logon.jsp"/>
	<%} %>
<html>
<head>
</head>
<body>
	<p>Simple Model2 Examples</p>
	<p>환영합니다 . : <%=userVO.getUserId() %>님</p>
</body>
</html>