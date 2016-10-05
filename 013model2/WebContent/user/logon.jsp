<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="spring.model2.service.user.vo.UserVO" %>

<%
	UserVO userVO = (UserVO)session.getAttribute("userVO");
%>

<html>
<head>
</head>
<body>
	<body>
		<form id ="login" method="post" action="/013model3/user/logonAction.do">
		아이디 : <input id = "userId" type="text" name="userId" value=""><br/><br/>
		패스워드 : <input id = "userId" type="text" name="userPasswd" value=""><br/><br/>
		<input id="submit" type="submit" name="submit" value="Enter"/>
		</form>
		
	</body>
</body>
</html>