<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="java.util.List" %>
    <%@page import="jw.service.user.vo.UserVO" %>
    <%@page import="jw.service.user.dao.UserDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	UserVO userVO=(UserVO)session.getAttribute("userVO");
	if(userVO ==null){
		userVO = new UserVO();
	}
%>

<%if(! userVO.isActive()){%>
	<jsp:include page="../jw07/login.html"></jsp:include>
	<br/><br/>
	<a href="/edu/jw07/addUser.html">ȸ������...</a>

<%}else{%>
	<center><h1>ȸ�������� ��ü ���</h1></center></hr>
		<center>
			<table vorder='1'>
				<tr>
					<th>��ȣ</th><th>���̵�</th><th>��й�ȣ</th>
				</tr>
				<%UserDao userDao = new UserDao(); %>
				<%List<UserVO> list=userDao.getUserList(); %>
				<%for(int i=0;i<list.size();i++){ %>
					<%UserVO user = list.get(i); %>
				<tr>
						<td><%=user.getNo() %></td>
						<td><%=user.getId() %></td>
						<td><%=user.getPwd() %></td>
				</tr>
					<%} %>
					</table>
			</center>
			<%} %>