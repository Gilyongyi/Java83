<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head><title>Insert title here</title></head>
<body>

<a href="/Spring14/user/getUser/user01">/Spring14/user/getUser/user01</a><br/><br/>

<form method="Post" action='/Spring14/user/getUser/user01'>
	���̵� : <input type='text' name='userId'><br/>
	��&nbsp;�� : <input type='text' name='userName'><br/><br/>
	
	<input type='submit' value='����'/>
	<input type='reset' value='���'/>

</form>

	���̵�(user.userId):${user.userId }<br/>
	�� ��(user.userName):${user.userName }<br/><br/>
	<br/><br/>

</body>
</html>