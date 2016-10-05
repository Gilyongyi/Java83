<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("EUC_KR"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="true">if 문 내부 1<br/></c:if>
<c:if test="false">if 문 내부 2<br/></c:if>

이름 : ${param.name}<br/>

<c:if test="${param.name =='홍길동' }">홍길동 안녕</c:if>
<c:if test="${!empty param.name}">${param.name} 안녕</c:if>

<c:set var="level" value="성인" scope="session"/>
<c:if test="${param.age<19 }"><c:set var="level" value="청소년"/></c:if>
${param.name}님 나이 ${param.age} 로 ${level} 임<br/>
${sessionScope.level}<br/>
${pageScope.level}<br/>

<c:if test = "${! empty paramValues.sw[0] }">
	선택한 SW : ${paramValues.sw[0]}<br/>
</c:if>
<c:if test = "${! empty paramValues.sw[1] }">
	선택한 SW : ${paramValues.sw[1]}<br/>
</c:if>
<c:if test = "${! empty paramValues.sw[2] }">
	선택한 SW : ${paramValues.sw[2]}<br/>
</c:if>

<c:choose>
	<c:when test ="${param.age>19}">
		${param.name } 님은 성인으로 나이 : ${param.age }<br/>
	</c:when>
	<c:when test="${param.age<18 }">
		${param.name } 님은 청소년으로 나이 : ${param.age }<br/>
	</c:when>
	<c:otherwise>
		${param.name } 님은 청소년?어른?? 나이 : ${param.age}<br/>
	</c:otherwise>	
</c:choose>

<c:if test="${!empty param.name && !empty param.age }">
	<c:choose>
		<c:when test="${param.age>19 }">
			${param.name } 님 성인 나이 : ${param.age }<br/>
		</c:when>
				<c:when test="${param.age<18}">
			${param.name } 님 청소년 나이 : ${param.age }<br/>
		</c:when>
		<c:otherwise>
			${param.name } 님 뭐야 나이 :${param.age }<br/>
		</c:otherwise>
	</c:choose>
</c:if>



