<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	java.util.Vector vector = new java.util.Vector();
	vector.add("A");
	vector.add("B");
	vector.add("C");
	vector.add("D");

%>

<c:forEach var="i" items ="<%=vector%>" begin="0" step="1" end="10">
	::Vector : ${i }<br/>
</c:forEach><br/>

<c:forEach var="i" items ="<%=vector%>" begin="1" step="1">
	::Vector : ${i }<br/>
</c:forEach><br/>

<c:forEach var="i" items ="<%=vector%>" begin="0" step="2">
	::Vector : ${i }<br/>
</c:forEach><br/>

<c:forEach var="i" items ="<%=vector%>" begin="0" step="1" end="1">
	::Vector : ${i }<br/>
</c:forEach><br/>

<c:forEach var="i" items ="<%=vector%>">
	::Vector : ${i }<br/>
</c:forEach><br/>

<%
	java.util.HashMap hasMap = new java.util.HashMap();
	hasMap.put("a","A");
	hasMap.put("b","B");
	hasMap.put("c","C");
	hasMap.put("d","D");
	
%>
<c:forEach var="i" items="<%=hasMap %>">
	::HashMap : ${i.key} =${i.value }<br/>
</c:forEach><br/>

<c:set var="aaa" value="<%=hasMap%>"/>

<c:forEach var="i" items="${aaa}">
	<c:if test="${i.key=='a'}">
	::key a value : ${i.value}
	</c:if>
</c:forEach>