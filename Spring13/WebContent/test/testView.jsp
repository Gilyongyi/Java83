<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>Test Page</title></head>
<body>
	<a href="/Spring13/app/user/xml/test01">/Spring13/app/user/xml/test01</a><br/><br/>
	<a href="/Spring13/app/user/json/test02">/Spring13/app/user/json/test02</a><br/><br/>
	<a href="/Spring13/app/user/user01">/Spring13/app/user/user01</a><br/><br/>
	<a href="/Spring13/app/user/user01/userName">/Spring13/app/user/user01/userName</a><br/><br/>
	
	아이디 : ${user.userId }
	이	름 : ${user.userName}
	
	<br/><br/>
	
	<form method="post" action="/Spring13/app/user/user02/userName02">
	
	아이디 : <input type="text" name="userId" value="${userForm.userId }"><br/><br/>
	패스워드 : <input type="text" name="password" value="${userForm.password }"><br/><br/>
	<input type="submit" name="submit" value="Enter"/>
	
	</form>	
</body>
</html>