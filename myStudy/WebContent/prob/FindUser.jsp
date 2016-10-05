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
	<head><title>내정보 보기</title></head>
	<body><center>내정보보기<br/>
	<%if(name==null || name.equals("")){%>
		이름을 입력해주세요
		
	<%}else{ %>
		JSESSIONID : <%=session.getId() %><br/>
		<%=userVO.getName() %> 님 환영합니다(FindUser.jsp)<br/>
		<%= userDao.findUser(name)%>
		<%} %>
	<p><p><a href='/myStudy/prob/updateUserView.jsp' name=내정보수정><input type=button value='내정보수정'></a>
	
	</center></body>
</html>
    