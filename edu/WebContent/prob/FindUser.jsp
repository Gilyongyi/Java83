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
			out.println("ó�� �����ϼ̽��ϴ�.");
		}
%>
<html>
	<head><title>������ ����</title></head>
	<body><center>����������<br/>
	<%=userDao.findUser(name) %>
	</center></body>
</html>
    