<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="client" value="<%=new jw09.Client() %>" scope="session"/>

client name : ${client.name}<br/>
client addr : ${client.addr}<br/>
client age : ${client.age}<br/>
client info empty : ${empty client.info}<br/>
info index 0 value : ${client.info[0]}<br/>
info index 1 value : ${client.info[1]}<br/>

<c:set var="test" value="${client}" scope="session"/>

client name : ${client.name }<br/>
test name : ${test.name}<br/>
<hr/>
<c:set target="${test}" property="name" value="이순신"/>
cluent name : ${client.name}<br/>
test name : ${test.name }<br/><hr/>

remove 전 client empty : ${empty client}<br/>
<c:remove var="client" scope="session"/>
remove 후 client empty : ${empty client }<br/>
remevo 안한 test empty : ${empty test }<br/>


