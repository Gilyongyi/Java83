<%@ page contentType="text/html; charset=euc-kr" %>

<%@ page import="com.model2.mvc.service.domain.User" %>

<%
	User user=(User)session.getAttribute("user");
		String role="";
		
		if(user != null) {
			role=user.getRole();
		}
%>
<html>
<head>

<title>Model2 MVC Shop</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#tabs" ).tabs();
  });
  
  function realTime(){
	  var today = new Date();
	  var month = today.getMonth(); 
	  var dt = today.getDate(); 
	  var dw = today.getDay(); //����
	  var h = today.getHours();
	  var m = today.getMinutes();
	  var s = today.getSeconds();
	  
	  // ��,�ʰ� 10���� ������ 0�� �ٿ��ش�.
	  m = addzero(m);
	  s = addzero(s);
	  
	  //�� ó��; �ڹٽ�ũ��Ʈ������ "0" �� 1���̴�..
	  month = month +1;
	  
	  //����ó�� 
	  var dayweek = new Array(7);
	  
	  dayweek[0] = "��"
	  dayweek[1] = "��"
	  dayweek[2] = "ȭ"
	  dayweek[3] = "��"
	  dayweek[4] = "��"
	  dayweek[5] = "��"
	  dayweek[6] = "��" 
	  
	  d = dayweek[dw];
	  
	  // ���
	  var clock = document.getElementById('clock');
	  clock.innerHTML = month +'�� ' + dt + '�� ' + d + '���� ' + h +'�� '+ m + '�� ' + s +'��';
	  
	  // ������Ʈ �ֱ�(0.5��)
	  setTimeout(function(){
	      realTime();
	      },500);
	 }
	 function addzero(i){ // ��,�ʰ� 10���� ������ 0�� �ٿ��ش�.
	  if(i<10){
	   i = "0" + i;
	  }
	  
	  return i;
	 }
  </script>

<link href="/css/left.css" rel="stylesheet" type="text/css">

</head>

<body topmargin="0" leftmargin="0" onload=" realTime();">
 
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
	<td height="10"></td>
	<td height="10" >&nbsp;</td>
  </tr>
  <tr>
    <td width="800" height="30"><h1>���� SHOP</h1></td>
    <td><h2><div id="clock"></h2></div></td>
  </tr>
  	
  <tr>
    <td height="20" align="right" background="/images/img_bg.gif">
	    <table width="200" border="0" cellspacing="0" cellpadding="0">
	        <tr> 
	          <td width="115">
		          <%	if(user == null) { %>
		              <a href="/user/loginView.jsp" target="rightFrame">login</a>   
		          <%}%>        
	          </td>
	          <td width="14">&nbsp;</td>
	          <td width="56">
		          <% if(user != null) {  %>
		            	<a href="/user/logout" target="_parent">logout</a>  
		           <% } %>
	          </td>
	        </tr>
	      </table>
      </td>
    <td height="20" background="/images/img_bg.gif">&nbsp;</td>
  </tr>
</table>
<div id="tabs">

		<ul>
			<li><a href="#tabs-0">main</a></li>
			<% 	if(user != null){ %>
		  	<li><a href="#tabs-1">����������ȸ</a></li>
		  	<%} %>
		  	<%	if(role.equals("admin")){ %>
		  	<li><a href="#tabs-2">ȸ��������ȸ</a></li>
		  	<li><a href="#tabs-3">��ǰ����[admin]</a></li>
		  	<%} %>
		  	<li><a href="#tabs-4">�� ǰ �� ��</a></li>
		  	<% 	if(role.equals("user")){ %>
		  	<li><a href="#tabs-5">���Ÿ��</a></li>
		  	<%} %>
		 	<li><a href="#tabs-6">�ֱ� �� ��ǰ</a></li>
		</ul>
			
				<div id="tabs-0">
				<% 	if(user == null){ %>
					<marquee behavior="altemate" width="500">ȸ������ / Login ���ּ���</marquee>
				<%}else{ %>
					<marquee behavior="altemate" width="500"><%= user.getUserId() %> / <%= user.getUserName() %> �� ȯ���մϴ�</marquee>
				<%} %>
				</div>
				<div id="tabs-1">
					<% 	if(user != null){ %>
					<a href="/user/getUser.jsp" target="rightFrame">�� �� �� �� �� �� ȸ</a>
					<%} %>
				</div>
				<%	if(role.equals("admin")){ %>
				<div id="tabs-2">
				 	<a href="/user/listUser" target="rightFrame">�� ȸ �� �� �� �� ȸ</a>
				</div>
				<div id="tabs-3">
				 	<a href="/product/addProductView.jsp" target="rightFrame">
				 	�� �� �� �� ǰ �� ��
				 	</a>&nbsp;&nbsp;&nbsp;
				 	<a href="/product/listProduct?menu=manage" target="rightFrame">
				 	�� �� �� �� ǰ �� ��
				 	</a>
				</div>
				<%} %>
				<div id="tabs-4">
				 	<a href="/product/listProduct?menu=search" target="rightFrame">
				 	�� �� ǰ �� ��
				 	</a>
				</div>
				<div id="tabs-5">
				<%	if(user != null && role.equals("user")){%>
				 	<a href="/purchase/listPurchase"  target="rightFrame">
				 	�� �� �� �� �� �� ȸ 
				 	</a>
				 	<%} %>
				</div>
				<div id="tabs-6">
				   	<jsp:include page="/history.jsp"></jsp:include> 
				</div>
</div>
</body>
</html>