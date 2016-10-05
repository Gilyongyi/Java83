<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="jw.service.user.vo.UserVO" %>
    <%@ page import="jw.service.user.dao.UserDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 		request.setCharacterEncoding("EUC_KR");		
		
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
		//System.out.println("data 넣기전"+userVO);
		UserDao useDao = new UserDao();
		useDao.updateUser(userVO);
		//System.out.println("data 넣기후"+userVO);
		if(session.isNew()){
			session.setAttribute("userVO",userVO);
		}
		%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	수정이 완료되었습니다.
</body>
</html>