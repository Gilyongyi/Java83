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
	  var dw = today.getDay(); //요일
	  var h = today.getHours();
	  var m = today.getMinutes();
	  var s = today.getSeconds();
	  
	  // 분,초가 10보다 작으면 0을 붙여준다.
	  m = addzero(m);
	  s = addzero(s);
	  
	  //월 처리; 자바스크립트에서는 "0" 이 1월이다..
	  month = month +1;
	  
	  //요일처리 
	  var dayweek = new Array(7);
	  
	  dayweek[0] = "일"
	  dayweek[1] = "월"
	  dayweek[2] = "화"
	  dayweek[3] = "수"
	  dayweek[4] = "목"
	  dayweek[5] = "금"
	  dayweek[6] = "토" 
	  
	  d = dayweek[dw];
	  
	  // 출력
	  var clock = document.getElementById('clock');
	  clock.innerHTML = month +'월 ' + dt + '일 ' + d + '요일 ' + h +'시 '+ m + '분 ' + s +'초';
	  
	  // 업데이트 주기(0.5초)
	  setTimeout(function(){
	      realTime();
	      },500);
	 }
	 function addzero(i){ // 분,초가 10보다 작으면 0을 붙여준다.
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
    <td width="800" height="30"><h1>용이 SHOP</h1></td>
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
		  	<li><a href="#tabs-1">개인정보조회</a></li>
		  	<%} %>
		  	<%	if(role.equals("admin")){ %>
		  	<li><a href="#tabs-2">회원정보조회</a></li>
		  	<li><a href="#tabs-3">상품관리[admin]</a></li>
		  	<%} %>
		  	<li><a href="#tabs-4">상 품 검 색</a></li>
		  	<% 	if(role.equals("user")){ %>
		  	<li><a href="#tabs-5">구매목록</a></li>
		  	<%} %>
		 	<li><a href="#tabs-6">최근 본 상품</a></li>
		</ul>
			
				<div id="tabs-0">
				<% 	if(user == null){ %>
					<marquee behavior="altemate" width="500">회원가입 / Login 해주세요</marquee>
				<%}else{ %>
					<marquee behavior="altemate" width="500"><%= user.getUserId() %> / <%= user.getUserName() %> 님 환영합니다</marquee>
				<%} %>
				</div>
				<div id="tabs-1">
					<% 	if(user != null){ %>
					<a href="/user/getUser.jsp" target="rightFrame">● 개 인 정 보 조 회</a>
					<%} %>
				</div>
				<%	if(role.equals("admin")){ %>
				<div id="tabs-2">
				 	<a href="/user/listUser" target="rightFrame">● 회 원 정 보 조 회</a>
				</div>
				<div id="tabs-3">
				 	<a href="/product/addProductView.jsp" target="rightFrame">
				 	● 판 매 상 품 등 록
				 	</a>&nbsp;&nbsp;&nbsp;
				 	<a href="/product/listProduct?menu=manage" target="rightFrame">
				 	● 판 매 상 품 관 리
				 	</a>
				</div>
				<%} %>
				<div id="tabs-4">
				 	<a href="/product/listProduct?menu=search" target="rightFrame">
				 	● 상 품 검 색
				 	</a>
				</div>
				<div id="tabs-5">
				<%	if(user != null && role.equals("user")){%>
				 	<a href="/purchase/listPurchase"  target="rightFrame">
				 	● 구 매 목 록 조 회 
				 	</a>
				 	<%} %>
				</div>
				<div id="tabs-6">
				   	<jsp:include page="/history.jsp"></jsp:include> 
				</div>
</div>
</body>
</html>