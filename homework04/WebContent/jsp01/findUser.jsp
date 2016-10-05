<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="jw.services.user.vo.UserVO" %>   
<%@ page import="jw.services.user.dao.UserDAO" %>

<%
	request.setCharacterEncoding("EUC_KR");
	
	//client에서 넘어온 값을 받자.
	String id = request.getParameter("id");
	//==>id가 null인경우는 ?
	//==><a href='/homework04/findUser.jsp'>내정보보기2(session사용)</a>
	if(id == null){
		//==>  Session에 저장된 userVO instance 의 id 사용
		id =  ( (UserVO)session.getAttribute("userVO")).getId();
	}
	
	//DB에 접근하는 UserDAO를 이용 회원정보 select 후
	UserDAO bean = new UserDAO();
	//==> 회원의 정보를 갖는 userVO intance로 받기
	UserVO userVO = bean.findUser(id);
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	</head>
	<body>
		
		<h2>요청하신 회원정보</h2>
		<% if(userVO != null){  %>
		    no  :  <%= userVO.getNo()  %> <br/>
		    id   :  <%= userVO.getId() %> <br/>
		    pwd : <%= userVO.getPwd() %> <br/>
		<% }else{  %>
			<%= id  %> 에 해당하는 data는 없습니다.<br/>
		<% }  %>
		
		<br/><br/><br/>
		
	
		<a href='/homework04/jsp01/updateUserView.jsp?id=<%=userVO.getId() %>'>내정보수정(id전달)</a>
		
		<p><p>
	
		<a href='/homework04/jsp01/updateUserView.jsp'>내정보수정(session사용)</a>

	</body>
</html>