<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<body>
	::08123123����
	<% request.setAttribute("aaa", new String("�����")); %>
	<jsp:forward page = "09JSPActionForward.jsp"/>
	::08 asdfasdf.jsp ��
</body>
</html>