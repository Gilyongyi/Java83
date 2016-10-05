<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<body>
	::08123123시작
	<% request.setAttribute("aaa", new String("연결됨")); %>
	<jsp:forward page = "09JSPActionForward.jsp"/>
	::08 asdfasdf.jsp 끝
</body>
</html>