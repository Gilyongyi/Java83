<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>구매 목록조회</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">
	
<script type="text/javascript">
<!--	
	function fncGetList(currentPage) {
		document.getElementById("currentPage").value = currentPage;
		document.detailForm.submit();
		}
-->	
</script>
</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width: 98%; margin-left: 10px;">

<form name="detailForm" action="/purchase/listPurchase" method="post">

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37"><img src="/images/ct_ttl_img01.gif"width="15" height="37"></td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left: 10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">구매 목록조회</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37"><img src="/images/ct_ttl_img03.gif"	width="12" height="37"></td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top: 10px;">
	<tr>
		<td colspan="11">현재 ${page.currentPage} 페이지</td>
	</tr>
	<tr>
		<td colspan="11">
			<a href="/purchase/listPurchase">▷전체보기</a>
			<a href="/purchase/listPurchase?tranCo=1">▷구매완료상태</a>
			<a href="/purchase/listPurchase?tranCo=2">▷배송중상태</a>
			<a href="/purchase/listPurchase?tranCo=3">▷배송완료상태</a>
			<a href="/purchase/listPurchase?tranCo=4">▷반품신청상태</a>
		</td>
	</tr>
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">회원ID</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">구매자</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">배송지</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">배송현황</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">정보수정</td>
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>
	<c:set var="no" value="${list.size()}"></c:set>
	<c:forEach var="vo" items="${list}">
	
	<tr class="ct_list_pop">
		<td align="center">
			<a href="/purchase/getPurchase?tranNo=${vo.tranNo}">${vo.tranNo}</a>
		</td>
		<td></td>
		<td align="left">
			<a href="/user/getUser?userId=${vo.buyer.userId }">${vo.buyer.userId }</a>
		</td>
		<td></td>
		<td align="left">${vo.receiverName }</td>
		<td></td>
		<td align="left">${vo.divyAddr }</td>
		<td></td>
		<td align="left">
					
			<c:if test="${vo.tranCode.trim()=='1'}">현재 구매완료 상태 입니다. </c:if>
			<c:if test="${vo.tranCode.trim()=='2'}">현재 배송중 상태 입니다.</c:if>
			<c:if test="${vo.tranCode.trim()=='3'}">현재 배송완료 상태 입니다.</c:if>
			<c:if test="${vo.tranCode.trim()=='4'}">현재 반품신청 상태 입니다.</c:if>
		</td>
		<td>
			
		</td>
		<td align="left">
			<c:if test="${vo.tranCode.trim()=='3'}"><a href="/purchase/updateTranCode?tranNo=${vo.tranNo }&tranCode=4">반품신청</a></c:if>
			<c:if test="${vo.tranCode.trim()=='2'}"><a href="/purchase/updateTranCode?tranNo=${vo.tranNo }&tranCode=3">물건도착</a></c:if>
			<c:if test="${vo.tranCode.trim()=='1'}"><a href="/purchase/deletePurchase?tranNo=${vo.tranNo }">구매 취소</a></c:if>
		</td>
	</tr>
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>
	</c:forEach>
	
	
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: 10px;">
	<tr>
		<td align="center">
		   <input type="hidden" id="currentPage" name="currentPage" value=""/>
			<jsp:include page="../common/pageNavigator.jsp"/>
		</td>
	</tr>
</table>

<!--  페이지 Navigator 끝 -->
</form>

</div>

</body>
</html>