<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>��ǰ �����ȸ</title>

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
 
                $(document).on("mouseover",".thumbnail",function(e){ //���콺 ������
                     
                    $("body").append("<p id='preview'><img src='"+ $(this).attr("src") +"' width='300px' /></p>"); //������ �̹����� ����                       
                    $("#preview")
                        .css("top",(e.pageY - xOffset) + "px")
                        .css("left",(e.pageX + yOffset) + "px")
                        .fadeIn("fast"); //�̸����� ȭ�� ���� ����
                });
                 
                $(document).on("mousemove",".thumbnail",function(e){ //���콺 �̵���
                    $("#preview")
                        .css("top",(e.pageY - xOffset-100) + "px")
                        .css("left",(e.pageX + yOffset) + "px");
                });
                 
                $(document).on("mouseout",".thumbnail",function(){ //���콺 �ƿ���
                    $("#preview").remove();
                });
                  
            });
        </script>
             
        <style>
            /* �̸����� ��Ÿ�� ���� */
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
					<c:if test="${param.menu=='manage' }">��ǰ���� [Admin Page]</c:if>
					<c:if test="${param.menu=='search' }">��ǰ �����ȸ </c:if>
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
				<option value="0"  ${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>��ǰ��</option>
				<option value="1"  ${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>����</option>
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
						<a href="javascript:fncGetList('1');">�˻�</a>
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
		<td colspan="11" >��ü ${page.totalCount} �Ǽ�, ���� ${page.currentPage} ������  
		<c:if test="${param.menu=='search' }">
			<a href="/product/listProduct?menu=search&order=asc">���������ݼ�</a>
			<a href="/product/listProduct?menu=search&order=desc">���������ݼ�</a>
			<a href="/product/listProduct?menu=search&order=rasc">���ֱٵ�ϼ�</a>
			<a href="/product/listProduct?menu=search&order=gasc">�������ټ�</a>
		</c:if>
		<c:if test="${param.menu=='manage' }">
			<a href="/product/listProduct?menu=manage&order=asc">���������ݼ�</a>
			<a href="/product/listProduct?menu=manage&order=desc">���������ݼ�</a>
			<a href="/product/listProduct?menu=manage&order=rasc">���ֱٵ�ϼ�</a>
			<a href="/product/listProduct?menu=manage&order=gasc">�������ټ�</a>
		</c:if>
		</td>
	</tr>
	<tr><td class="ct_line02"></td>
		<td class="ct_list_b" width="200">�̹���</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="200">��ǰ��</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="200">����</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="400">�� ����</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="200">�������</td>		
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="200">�������</td>
		<c:if test="${param.menu=='manage'}">
			<td class="ct_line02"></td>
		<td class="ct_list_b" width="100">������</td>
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
			<c:if test="${vo.proTranCode.trim()=='0'}">�Ǹ���</c:if>
			<c:if test="${vo.proTranCode.trim()=='1' ||vo.proTranCode.trim()=='2'||vo.proTranCode.trim()=='3'||vo.proTranCode.trim()=='4'}">������ (���źҰ�)</c:if>
		</c:if>

		<c:if test="${param.menu=='manage'}">
			<c:if test="${vo.proTranCode.trim()=='0'}">�Ǹ���</c:if>
			<c:if test="${vo.proTranCode.trim()=='1'}">���ſϷ� <a href="/purchase/getPurchase2?prodNo=${vo.prodNo}&tranCode=2" >����ϱ�</a></c:if>
			<c:if test="${vo.proTranCode.trim()=='2'}">�����</c:if>
			<c:if test="${vo.proTranCode.trim()=='3'}">��ۿϷ�</c:if>
			<c:if test="${vo.proTranCode.trim()=='4'}"><a href="/purchase/getPurchase2?prodNo=${vo.prodNo}&tranCode=0" >��ǰȮ��</a></c:if>
		</c:if>
		</td>
		<td></td>
		<c:if test="${param.menu=='manage'}">
			<c:if test="${vo.proTranCode.trim()=='0'}"><td align="center"><a href="/product/deleteProduct?prodNo=${vo.prodNo }">�����ϱ�</a></td></c:if>
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
<!--  ������ Navigator �� -->

</form>

</div>
</body>
</html>
