<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="prob.*" %>
<%
		request.setCharacterEncoding("EUC_KR");

		String name=request.getParameter("name");
		
		UserVO userVO=new UserVO();
		userVO.setName(name);
		
		UserDao userDao=new UserDao();
		userDao.findUser(name);
		
		if(session!=null){
			out.println("JSESSIONID : "+session.getId());
			
		}else{
			out.println("처음 접속하셨습니다.");
		}
%>
<html>
	<head><title>내정보 보기</title></head>
	<body><center>내정보보기<br/>
	<%=userDao.findUser(name) %>
	</center></body>
</html>
    