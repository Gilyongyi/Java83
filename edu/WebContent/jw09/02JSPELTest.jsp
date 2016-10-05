<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%
	pageContext.setAttribute("abc", new String("page objectScope <<<<"));
	
	request.setAttribute("abc", new String("request objectScope <<<<"));
	
	session.setAttribute("abc", new String("session objectScope <<<<"));
	
	ArrayList arrayList = new ArrayList();
	arrayList.add(new String("ArrayList <<<<"));
	session.setAttribute("def", arrayList);
	
	HashMap hashMap = new HashMap();
	hashMap.put("zzz",new String("HashMap <<<<"));
	application.setAttribute("abc", hashMap);
 %>
 ${pageScope.abc} = ${pageScope["abc"]}
 </br>
 ${requestScope.abc} = ${requestScope["abc"]}
 </br>
 ${sessionScope.abc} = ${sessionScope["abc"]}
 </br>
 ${empty sessionScope.abc} = ${empty sessionScope["abc"] }
 </br>
 ${empty sessionScope.def} = ${empty sessionScope["def"] }
 </br>
 ${sessionScope.def[0] }=${sessionScope["def"][0]}
 </br>
 ${empty applicationScope.abc} = ${empty applicationScope["abc"]}
 </br>
 ${applicationScope.abc.zzz } = ${applicationScope["abc"].zzz }
 </br>
 
 
 
 
 
  