<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="jw04.*" %>

<%		request.setCharacterEncoding("EUC_KR");
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		
		UserVO userVO=(UserVO)session.getAttribute("userVO");
		System.out.println("세션 저장된 UserVO 유무 : "+userVO);
		
		if(!(id==null||id.equals(""))){
			userVO=new UserVO();
			userVO.setId(id);
			userVO.setPwd(pwd);
			
			UserDataSourceDao userDataSourceDao = new UserDataSourceDao();
			userDataSourceDao.getUser(userVO);
		}
%>
<html>
		<head></head>
		<body>
		<h2>Login 화면</h2>
		<% if(userVO!=null && userVO.isActive()){%>
			<%=userVO.getId()%> 님환영
			 <%session.setAttribute("userVO", userVO);%>
		<% }else{%>
			로그인실패
		<% }%>
		<p><p><a href='/edu/jw07/loginBeanDataSourceSessionJSP.html'>뒤로</a>
		</body>
		</html>
	}

}
