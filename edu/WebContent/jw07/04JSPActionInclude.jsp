<%@ page contentType="text/html;charset=euc-kr" %>
<html>
<body>

::  04JSPActionInclude.jsp ���� <br/>

<%
	// Scriptlet tag ���� ���� :: service() Method  local variable
	String value = "local variable";

	// request,session,application  ObjectScope  Data ����
	request.setAttribute("value", value);
	request.setAttribute("aaa",new String("request ObjectScope ����� ���ڿ�"));
	session.setAttribute("bbb",new String("session ObjectScope ����� ���ڿ�"));
	application.setAttribute("ccc",new String("application ObjectScope ����� ���ڿ�"));
%>


::  04JSPActionInclude.jsp �� <br/>

</body>
</html>