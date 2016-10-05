<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="num1" value="100" scope="page"/>
<c:set var="num2" />

<%
	String abc = (String)pageContext.getAttribute("num2");
	System.out.println("_"+abc+"_");
%>

${empty pageScope.num1} num1 = ${pageScope.num1}<br/>
${empty num2 } num2 = _${num2}_<br/>
${num1+pageScope.num2 }<br/>
num1+num2 = ${num1+num2 }<br/>

<c:set var="num1" value="${num1+100 }"/>
num1 : ${num1}<br/>

<c:remove var="num1"/>
num1 Àº empty : ${empty num1 } num1 = _${num1 }_<br/>
num2 Àº empty : ${empty num2 } num2 = _${pageScope.num2 }_ <br/>

<%
String def = (String)pageContext.getAttribute("num1");
System.out.println("_"+def+"_");
%>


	