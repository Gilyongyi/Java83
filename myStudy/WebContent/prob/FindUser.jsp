<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="jw.service.user.vo.UserVO" %>
<%@ page import="jw.service.user.dao.UserDao" %>
<%
		request.setCharacterEncoding("EUC_KR");
		
		String name=request.getParameter("name");
			System.out.println(name);
		UserVO userVO= (UserVO)session.getAttribute("userVO");
			System.out.println(userVO);
				
		UserDao userDao=new UserDao();
		//userVO = userDao.findUser(name);
		
		//if(!(name==null||name.equals(""))){
			userVO = new UserVO();
			userVO.setName(name);
		//}else{
			userDao = new UserDao();
			userVO = userDao.findUser(name);
			session.setAttribute("userVO", userVO);
		//}
%>
<html>
	<head><title>������ ����</title></head>
	<body><center>����������<br/>
	<%if(name==null || name.equals("")){%>
		�̸��� �Է����ּ���
		
	<%}else{ %>
		JSESSIONID : <%=session.getId() %><br/>
		<%=userVO.getName() %> �� ȯ���մϴ�(FindUser.jsp)<br/>
		<%= userDao.findUser(name)%>
		<%} %>
	<p><p><a href='/myStudy/prob/updateUserView.jsp' name=����������><input type=button value='����������'></a>
	
	</center></body>
</html>
    