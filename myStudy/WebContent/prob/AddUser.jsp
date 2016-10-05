<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="jw.service.user.vo.UserVO" %>
<%@ page import="jw.service.user.dao.UserDao" %>
<%
		request.setCharacterEncoding("EUC_KR");		
		
		UserVO userVO=(UserVO)session.getAttribute("userVO");
				
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String []birth=request.getParameterValues("birth");
		String solar=request.getParameter("solar");
		String academic=request.getParameter("academic");
		String job=request.getParameter("job");
		String dept=request.getParameter("dept");
		String marital=request.getParameter("marital");
		String children=request.getParameter("children");
		String []phone=request.getParameterValues("phone");
		String wherenum=request.getParameter("wherenum");
		String []phonenumber=request.getParameterValues("phonenumber");
		String telecom=request.getParameter("telecom");
		String address=request.getParameter("address");
		
		userVO= new UserVO();
		if(!(name==null||name.equals(""))){
		userVO.setName(name);
		userVO.setGender(gender);
		userVO.setBirth(birth[0]+"."+birth[1]+"."+birth[2]);
		userVO.setSolar(solar);
		userVO.setAcademic(academic);
		userVO.setJob(job);
		userVO.setDept(dept);
		userVO.setMarital(marital);
		userVO.setChildren(children);
		userVO.setPhone(phone[0]+"-"+phone[1]+"-"+phone[2]);
		userVO.setWherenum(wherenum);
		userVO.setPhonenumber(phonenumber[0]+"-"+phonenumber[1]+"-"+phonenumber[2]);
		userVO.setTelecom(telecom);
		userVO.setAddress(address);

		UserDao useDao = new UserDao();
		useDao.addUser(userVO);
		}
		if(session.isNew()){
			session.setAttribute("userVO",userVO);
		}
		
%>
<html>
<head>

</head>
<boby><center><h2>Client에서 전송된 내용</h2><p>
		<% if(session.isNew()){%>
			<%=userVO.getName()%> 님 가입을 환영합니다.
		<% }else{%>
			<%=userVO.getName() %> 님 환영합니다.
			JSESSIONID : <%=session.getId()%>
			<%}%>
		
<p><p><a href='/myStudy/prob/findUserView.jsp' name=내정보보기><input type=button value='내정보보기'></a>
<p><p><a href='/myStudy/prob/addUserView.jsp' name=뒤로><input type=button value='뒤로'></a>
</center></body>
</html>
