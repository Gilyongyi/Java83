<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>��ǰ �����ȸ</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

<script type="text/javascript">
<!--
function fncGetProductList(){
	document.detailForm.submit();
}
-->
</script>
</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width:98%; margin-left:10px;">

<form name="detailForm" action="/listProduct.do?menu=manage" method="post">

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37">
			<img src="/images/ct_ttl_img01.gif" width="15" height="37"/>
		</td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">
					<c:if test="${param.menu=='manage' }">��ǰ����</c:if>
					<c:if test="${param.menu=='search' }">��ǰ �����ȸ</c:if>
					</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37">
			<img src="/images/ct_ttl_img03.gif" width="12" height="37"/>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		
		<td align="right">
			<select name="searchCondition" class="ct_input_g" style="width:80px">
				<option value="0">��ǰ��ȣ</option>
				<option value="1">��ǰ��</option>
				<option value="2">��ǰ����</option>
			</select>
			<input type="text" name="searchKeyword"  class="ct_input_g" style="width:200px; height:19px" />
		</td>
	
		
		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23">
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						<a href="javascript:fncGetProductList();">�˻�</a>
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23">
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td colspan="11" >��ü ${pageVO.total} �Ǽ�, ���� ${pageVO.currentPage} ������</td>
	</tr>
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">��ǰ��</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">����</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">�����</td>	
		<td class="ct_line02"></td>
		<td class="ct_list_b">�������</td>	
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>

	<c:set var="no" value="${list.size()}"></c:set>
	<c:forEach var="vo" items="${list}">
	
	<tr class="ct_list_pop">
		<td align="center">${no}</td>
		<td></td>
		<c:if test="${!vo.proTranCode=='0'}"><td>${vo.prodName}</td></c:if>	
		<c:if test="${param.menu=='manage'}">
		<td align="left"><a href="/getProduct.do?prodNo=${vo.prodNo}&menu=manage">${vo.prodName}</a></c:if></td>
		<c:if test="${param.menu=='search'}">
		<td align="left"><a href="/getProduct.do?prodNo=${vo.prodNo}&menu=search">${vo.prodName}</a></c:if></td>
				
			<td></td>
		<td align="left">${vo.price}</td>
		<td></td>
		<td align="left">${vo.regDate}</td>
		<td></td>
		<td align="left">

		<c:if test="${param.menu=='search'}">
			<c:if test="${vo.proTranCode.trim()=='0'}">�Ǹ���</c:if>
			<c:if test="${vo.proTranCode.trim()=='1' ||vo.proTranCode.trim()=='2'||vo.proTranCode.trim()=='3'}">�������</c:if>
		</c:if>

		<c:if test="${param.menu=='manage'}">
			<c:if test="${vo.proTranCode.trim()=='0'}">�Ǹ���</c:if>
			<c:if test="${vo.proTranCode.trim()=='1'}">���ſϷ� <a href="updateTranCodeByProd.do?prodNo=${vo.prodNO}&tranCode=2" >����ϱ�</a></c:if>
			<c:if test="${vo.proTranCode.trim()=='2'}">�����</c:if>
			<c:if test="${vo.proTranCode.trim()=='3'}">��ۿϷ�</c:if>
		</c:if>
		</td>	

	</tr>
	
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>	
	</c:forEach>
	
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td align="center">
		
			<c:if test="${pageVO.currentPage>pageVO.sPage}">
				<a href="/listProduct.do?page=${pageVO.currentPage-pageVO.sPage}&menu=
				<c:if test ="${param.menu=='manage'}">manage">Pre</a></c:if>
				<c:if test ="${param.menu=='search'}">search">Pre</a></c:if>
			</c:if>
			<c:if test="${pageVO.currentPage<=pageVO.sPage}"> </c:if>
				
					
			<c:forEach var="k" begin="${pageVO.startPage}" step="1" end="${pageVO.endPage}">
				<a href="/listProduct.do?page=${k}&menu=
				<c:if test="${param.menu=='manage'}">manage">${k}</a></c:if>
				<c:if test="${param.menu=='search'}">search">${k}</a></c:if>	
			</c:forEach>
			
			<c:if test="${(pageVO.currentPage+pageVO.sPage)<=pageVO.lastPage || pageVO.currentPage==(pageVO.lastPage/pageVO.sPage)*pageVO.sPage
			}"></c:if>
				<a href="/listProduct.do?page=${(pageVO.sPage*((pageVO.currentPage-1)/pageVO.sPage)+1+pageVO.sPage).intValue() }&menu=
				<c:if test ="${param.menu=='manage'}">manage">next</a></c:if>
				<c:if test ="${param.menu=='search'}">search">next</a></c:if>
			<c:if test="!(pageVO.currentPage+pageVO.sPage<=pageVO.lastPage || pageVO.currentPage=(pageVO.lastPage/pageVO.sPage)*pageVO.sPage
			||pageVO.currentPage=='10')"></c:if>
		</td>
	</tr>
</table>
<!--  ������ Navigator �� -->

</form>

</div>
</body>
</html>