<%@ page contentType="text/html; charset=EUC-KR" %>

<html>
<head>
<title>열어본 상품 보기</title>
</head>

<body>
	최근 열어본 상품 목록 :: &nbsp;&nbsp;
<%
	request.setCharacterEncoding("euc-kr");
	response.setCharacterEncoding("euc-kr");
	
	String history = null;
	
	Cookie[] cookies = request.getCookies();
	
	if (cookies!=null && cookies.length > 0) {
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookie.getName().equals("history")) {
				history = cookie.getValue();
			}
		}
		if (history != null) {
			String[] h = history.split(",");
			for (int i = 0; i < h.length; i++) {
				if (!h[i].equals("null")) {
%>
	<a href="/product/getProduct?prodNo=<%=h[i]%>&menu=search"	target="rightFrame"><%=h[i]%></a>&nbsp;
<%
				}
			}
		}
	}
%>

</body>
</html>