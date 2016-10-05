<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("EUC_KR"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="true">if �� ���� 1<br/></c:if>
<c:if test="false">if �� ���� 2<br/></c:if>

�̸� : ${param.name}<br/>

<c:if test="${param.name =='ȫ�浿' }">ȫ�浿 �ȳ�</c:if>
<c:if test="${!empty param.name}">${param.name} �ȳ�</c:if>

<c:set var="level" value="����" scope="session"/>
<c:if test="${param.age<19 }"><c:set var="level" value="û�ҳ�"/></c:if>
${param.name}�� ���� ${param.age} �� ${level} ��<br/>
${sessionScope.level}<br/>
${pageScope.level}<br/>

<c:if test = "${! empty paramValues.sw[0] }">
	������ SW : ${paramValues.sw[0]}<br/>
</c:if>
<c:if test = "${! empty paramValues.sw[1] }">
	������ SW : ${paramValues.sw[1]}<br/>
</c:if>
<c:if test = "${! empty paramValues.sw[2] }">
	������ SW : ${paramValues.sw[2]}<br/>
</c:if>

<c:choose>
	<c:when test ="${param.age>19}">
		${param.name } ���� �������� ���� : ${param.age }<br/>
	</c:when>
	<c:when test="${param.age<18 }">
		${param.name } ���� û�ҳ����� ���� : ${param.age }<br/>
	</c:when>
	<c:otherwise>
		${param.name } ���� û�ҳ�?�?? ���� : ${param.age}<br/>
	</c:otherwise>	
</c:choose>

<c:if test="${!empty param.name && !empty param.age }">
	<c:choose>
		<c:when test="${param.age>19 }">
			${param.name } �� ���� ���� : ${param.age }<br/>
		</c:when>
				<c:when test="${param.age<18}">
			${param.name } �� û�ҳ� ���� : ${param.age }<br/>
		</c:when>
		<c:otherwise>
			${param.name } �� ���� ���� :${param.age }<br/>
		</c:otherwise>
	</c:choose>
</c:if>



