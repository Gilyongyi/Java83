<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="spring.model2.service.user.vo.UserVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% UserVO userVO =(UserVO)session.getAttribute("userVO"); %>

<html>
<head>
</head>
<body>
	<p>Simple Model2 Examples</p>
	<p>ȯ���մϴ�. : <%=userVO.getUserId() %>��</p>
</body>
</html>