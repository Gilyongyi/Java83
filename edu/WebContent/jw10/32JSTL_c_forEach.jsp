<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("EUC_KR");%>

<c:forEach var="i" items="${paramValues.sw }" begin="0" step="1">
	 ������ sw �� : ${i}<br/>
</c:forEach></br>

<c:forEach var="i" items="${paramValues.sw}">
	������ sw : ${i}<br/>
</c:forEach></br>

<c:forEach var="i" items="${param}">
	${i.key} : ${i.value}<br/>
</c:forEach></br>

<c:forEach var="i" items="${param}">
	<c:if test="${!empty param.name }">
		${param.name} ���̴� ${param.age}<br/>
	</c:if>
</c:forEach></br>

<c:forEach var="i" items="${param}">
	<c:if test="${i.key=='name'}">
		${param.name } ���̴� ${param.age}<br/>
	</c:if>
</c:forEach>