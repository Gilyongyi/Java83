<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<html>
<head>
<title>Insert title here</title>
</head>

<body>

<form name="updatePurchase" action="/updatePurchaseView.do?tranNo=0" method="post">

������ ���� ���Ű� �Ǿ����ϴ�.

<table border=1>
	<tr>
		<td>��ǰ��ȣ</td>
		<td>${prod.prodNo }</td>
		<td></td>
	</tr>
	<tr>
		<td>�����ھ��̵�</td>
		<td>${user.userName }</td>
		<td></td>
	</tr>
	<tr>
		<td>���Ź��</td>
		<td>
			
			${pur.paymentOption }
		
		</td>
		<td></td>
	</tr>
	<tr>
		<td>�������̸�</td>
		<td>${pur.receiverName }</td>
		<td></td>
	</tr>
	<tr>
		<td>�����ڿ���ó</td>
		<td>${pur.receiverPhone }</td>
		<td></td>
	</tr>
	<tr>
		<td>�������ּ�</td>
		<td>${pur.divyAddr }</td>
		<td></td>
	</tr>
		<tr>
		<td>���ſ�û����</td>
		<td>${pur.divyRequest }</td>
		<td></td>
	</tr>
	<tr>
		<td>����������</td>
		<td>${pur.divyDate }</td>
		<td></td>
	</tr>
</table>
</form>

</body>
</html>