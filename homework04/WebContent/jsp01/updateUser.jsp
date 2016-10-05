<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="jw.services.user.vo.UserVO" %>   
<%@ page import="jw.services.user.dao.UserDAO" %>

<%
	request.setCharacterEncoding("EUC_KR");
	
	//client에서 넘어온 값을 받자.
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	int no = Integer.parseInt(request.getParameter("no"));
	
	//Client에 받은 data로 UserVO instance 생성 및 Value set
	UserVO userVO = new UserVO();
	userVO.setId(id);
	userVO.setPwd(pwd);
	userVO.setNo(no);
	
	//DB에 접근하는 UserDAO를 이용 회원정보 Insert
	UserDAO userDAO = new UserDAO();
	userDAO.updateUser(userVO);

%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	</head>
	<body>
		
		<h2>요청하신 회원정보</h2>
		<% if(userVO.isActive() ){  %>
		    수정완료 <br/>
		<% }else{  %>
			  수정 error<br/>
		<% }  %>
		
		<br/><br/><br/>
		
	</body>
</html>