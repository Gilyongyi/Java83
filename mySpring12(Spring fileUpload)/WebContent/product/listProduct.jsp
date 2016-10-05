<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>상품 목록조회</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

<script type="text/javascript">
<!--
	function fncGetList(currentPage){
		document.getElementById("currentPage").value = currentPage;
		document.detailForm.submit();
}
-->
</script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                  
                var xOffset = 10;
                var yOffset = 30;
 
                $(document).on("mouseover",".thumbnail",function(e){ //마우스 오버시
                     
                    $("body").append("<p id='preview'><img src='"+ $(this).attr("src") +"' width='300px' /></p>"); //보여줄 이미지를 선언                       
                    $("#preview")
                        .css("top",(e.pageY - xOffset) + "px")
                        .css("left",(e.pageX + yOffset) + "px")
                        .fadeIn("fast"); //미리보기 화면 설정 셋팅
                });
                 
                $(document).on("mousemove",".thumbnail",function(e){ //마우스 이동시
                    $("#preview")
                        .css("top",(e.pageY - xOffset-100) + "px")
                        .css("left",(e.pageX + yOffset) + "px");
                });
                 
                $(document).on("mouseout",".thumbnail",function(){ //마우스 아웃시
                    $("#preview").remove();
                });
                  
            });
        </script>
             
        <style>
            /* 미리보기 스타일 셋팅 */
            #preview{
                z-index: 9999;
                position:absolute;
                border:0px solid #ccc;
                background:#333;
                padding:1px;
                display:none;
                color:#fff;
            }
        </style>

</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width:98%; margin-center:10px;">

<form name="detailForm" action="/product/listProduct?menu=${ param.menu }" method="post">

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37">
			<img src="/images/ct_ttl_img01.gif" width="15" height="37"/>
		</td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-center:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">
					<c:if test="${param.menu=='manage' }">상품관리 [Admin Page]</c:if>
					<c:if test="${param.menu=='search' }">상품 목록조회 </c:if>
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
				<option value="0"  ${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>상품명</option>
				<option value="1"  ${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>가격</option>
			</select>
			<input type="text" name="searchKeyword" id="searchKeyword" 
						value="${! empty search.searchKeyword ? search.searchKeyword : ''}"  
						class="ct_input_g" style="width:200px; height:20px" > 
		</td>
	
		
		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23">
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						<a href="javascript:fncGetList('1');">검색</a>
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
		<td colspan="11" >전체 ${page.totalCount} 건수, 현재 ${page.currentPage} 페이지  
		<c:if test="${param.menu=='search' }">
			<a href="/product/listProduct?menu=search&order=asc">▶낮은가격순</a>
			<a href="/product/listProduct?menu=search&order=desc">▶높은가격순</a>
			<a href="/product/listProduct?menu=search&order=rasc">▶최근등록순</a>
			<a href="/product/listProduct?menu=search&order=gasc">▶가나다순</a>
		</c:if>
		<c:if test="${param.menu=='manage' }">
			<a href="/product/listProduct?menu=manage&order=asc">▶낮은가격순</a>
			<a href="/product/listProduct?menu=manage&order=desc">▶높은가격순</a>
			<a href="/product/listProduct?menu=manage&order=rasc">▶최근등록순</a>
			<a href="/product/listProduct?menu=manage&order=gasc">▶가나다순</a>
		</c:if>
		</td>
	</tr>
	<tr><td class="ct_line02"></td>
		<td class="ct_list_b" width="200">이미지</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="200">상품명</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="200">가격</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="400">상세 정보</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="200">등록일자</td>		
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="200">현재상태</td>
		<c:if test="${param.menu=='manage'}">
			<td class="ct_line02"></td>
		<td class="ct_list_b" width="100">등록취소</td>
		</c:if>
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>

	<c:set var="no" value="${list.size()}"></c:set>
	<c:forEach var="vo" items="${list}">
	
	<tr class="ct_list_pop">
		<td></td>
		<td align="center"><img src = '../images/uploadFiles/${vo.fileName }' class="thumbnail" width="100px" height="100px"></td>
		<td></td>
		<c:if test="${param.menu=='manage'}">
		<td align="center" ><a href="/product/getProduct?prodNo=${vo.prodNo}&menu=manage">${vo.prodName}</a></td></c:if>
		<c:if test="${param.menu=='search'}">
			<td align="center">
				<c:if test="${vo.proTranCode.trim()=='0'}">	
					<a href="/product/getProduct?prodNo=${vo.prodNo}&menu=search">${vo.prodName}</a>
				</c:if>
				<c:if test="${vo.proTranCode.trim()!='0'}">
					${vo.prodName}
				</c:if>
			</td>
		</c:if>
				
		<td></td>
		<td align="center">${vo.price}</td>
		<td></td>
		<td align="center">${vo.prodDetail}</td>
		<td></td>
		<td align="center">${vo.regDate}</td>
		<td></td>
		<td align="center">

		<c:if test="${param.menu=='search'}">
			<c:if test="${vo.proTranCode.trim()=='0'}">판매중</c:if>
			<c:if test="${vo.proTranCode.trim()=='1' ||vo.proTranCode.trim()=='2'||vo.proTranCode.trim()=='3'||vo.proTranCode.trim()=='4'}">재고없음 (구매불가)</c:if>
		</c:if>

		<c:if test="${param.menu=='manage'}">
			<c:if test="${vo.proTranCode.trim()=='0'}">판매중</c:if>
			<c:if test="${vo.proTranCode.trim()=='1'}">구매완료 <a href="/purchase/getPurchase2?prodNo=${vo.prodNo}&tranCode=2" >배송하기</a></c:if>
			<c:if test="${vo.proTranCode.trim()=='2'}">배송중</c:if>
			<c:if test="${vo.proTranCode.trim()=='3'}">배송완료</c:if>
			<c:if test="${vo.proTranCode.trim()=='4'}"><a href="/purchase/getPurchase2?prodNo=${vo.prodNo}&tranCode=0" >반품확인</a></c:if>
		</c:if>
		</td>
		<td></td>
		<c:if test="${param.menu=='manage'}">
			<c:if test="${vo.proTranCode.trim()=='0'}"><td align="center"><a href="/product/deleteProduct?prodNo=${vo.prodNo }">삭제하기</a></td></c:if>
		</c:if>
	</tr>
	
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>	
	</c:forEach>
	
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
		<tr>
		<td align="center">
		   <input type="hidden" id="currentPage" name="currentPage" value=""/>
		   <input type="hidden" id="order" name="order" value="${search.order}"/>
		<jsp:include page="../common/pageNavigator.jsp"/>
		</td>
	</tr>
</table>
<!--  페이지 Navigator 끝 -->

</form>

</div>
</body>
</html>
