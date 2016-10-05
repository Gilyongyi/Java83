<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	session.setAttribute("client", new jw09.Client());
%>

<%
	out.println("<h3>1. Scrptlet Tag 이용 session 저장 Bean 화면 구성</h3>");

	jw09.Client client = (jw09.Client)session.getAttribute("client");
	
	out.println("이름 : "+client.getName()+"<br/>");
	String[] info = client.getInfo();
	for(int i=0;i<info.length;i++){
		out.println("info 배열의 index ["+i+"] : "+info[i]+"<br/>");
		
	}

%>

<h3> 2.EL 이용 session 저장  Bean 화면 구성</h3>

name : ${sessionScope.client.name}<br/>
addr : ${client.addr}<br/>
age : ${client.age}<br/>

info 배열은 emtty : ${empty client.info}<br/>

info 배열의 index 0 value : ${sessionScope.client.info[0]}<br/>
info 배열의 index 1 value : ${client.info[1]}<br/>