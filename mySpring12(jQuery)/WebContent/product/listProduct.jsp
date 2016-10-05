<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>��ǰ �����ȸ</title>
<style type="text/css">
	.slide-wrap {position:relative; width:1530; height:250px; overflow:hidden;}
	ul.slide-list{ position:absolute; left;0px; }
		ul.slide-list td {position:relative; float:center; width:600px; height:250px;}	

	a#prev2 {position:absolute; left:20px; top:100px; z-index:20;}
	a#next2 {position:absolute; right:-630px; top:100px; z-index:20;}
</style>

<link rel="stylesheet" href="/css/admin.css" type="text/css">
<script type="text/javascript">
	function fn_rollToEx(containerID, slideID){

		// �Ѹ��� ��ü�� ������ ��Ƶд�.
		var el = $('#'+containerID).find('#'+slideID);
		var lastChild;
		var speed = 3000;
		var timer = 0;

		el.data('prev', $('#'+containerID).find('.prev'));	//������ư�� data()�޼��带 ����Ͽ� �����Ѵ�.
		el.data('next', $('#'+containerID).find('.next'));	//������ư�� data()�޼��带 ����Ͽ� �����Ѵ�.
		el.data('size', el.children().outerWidth());		//�Ѹ���ü�� �ڽĿ���� ���̸� �����Ѵ�.
		el.data('len', el.children().length);				//�Ѹ���ü�� ��ü��� ����
		el.data('animating',false);

		el.css('width',el.data('size')*el.data('len'));		//�Ѹ���ü�� ��ü���� �����Ѵ�.

		//el�� ÷�ε� prev ����Ÿ�� Ŭ���̺�Ʈ�� ���ε��Ѵ�.
		el.data('prev').bind({
			click:function(e){
				e.preventDefault();
				movePrevSlide();
			}
		});

		//el�� ÷�ε� next ����Ÿ�� Ŭ���̺�Ʈ�� ���ε��Ѵ�.
		el.data('next').bind({
			click:function(e){
				e.preventDefault();
				moveNextSlide();
			}
		});

		function movePrevSlide(){
			if(!el.data('animating')){
				//�Ѹ���ü�� ������ ��Ҹ� �����Ͽ� �������� ������ �����Ѵ�.
				var lastItem = el.children().eq(-2).nextAll().clone(true);
				lastItem.prependTo(el);		//����� ��Ҹ� �Ѹ���ü�� �տ� �ٿ����´�.
				el.children().eq(-2).nextAll().remove();	//���õ� ��Ҵ� ������ �����Ѵ�
				el.css('left','-'+(el.data('size')*1+'px'));	//�Ѹ���ü�� left��ġ���� �缳���Ѵ�.
			
				el.data('animating',true);	//�ִϸ��̼� �ߺ��� ���� ���� ÷�ε� animating ����Ÿ�� true�� �����Ѵ�.

				el.animate({'left': '0px'},'normal',function(){		//�Ѹ���ü�� left:0��ŭ �ִϸ��̼� ��Ų��.
					el.data('animating',false);
				});
			}
			return false;
		}

		function moveNextSlide(){
			if(!el.data('animating')){
				el.data('animating',true);

				el.animate({'left':'-'+(el.data('size')*1)+'px'},'normal',function(){	//�Ѹ���ü�� �ִϸ��̼� ��Ų��.
					//�Ѹ���ü�� �տ��� ��Ҹ� �����Ͽ� �������� ������ �����Ѵ�.
					var firstChild = el.children().filter(':lt('+1+')').clone(true);
					firstChild.appendTo(el);	//����� ��Ҹ� �Ѹ���ü�� ���� �ٿ����´�.
					el.children().filter(':lt('+1+')').remove();	//���õ� ��Ҹ� �տ��� �����Ѵ�
					el.css('left','0px');	////�Ѹ���ü�� left��ġ���� �缳���Ѵ�.

					el.data('animating',false);
				});
			}
			return false;
		}

	}					
</script>

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
        
        	$(document).ready(function(){
        		$('#toggle').click(function(){
					$('#slider').toggle();
        		})
        	})
        	
        	$(function(){
        		$("a:contains('Click')").css("color","red");
        	})
        
        
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

<form name="detailForm" action="/product/listProduct?menu=${ param.menu }" method="post" enctype="multipart/form-data">

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
						<td colspan="11" ><h3>��ü ${page.totalCount} �Ǽ�<br/> ���� ${page.currentPage} ������ </h3> </td>
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
<hr/>
	<p align="center" id="toggle">
	<c:if test="${param.menu=='search'}">
		�ܻ�ǰ �̸����� [���� ������ ��ǰ�� <a>Click</a> �����մϴ�]
	</c:if>
	<c:if test="${param.menu=='manage'}">
		�ܻ�ǰ �̸����� [���� ������ ��ǰ�� <a>Click</a> �����մϴ�]
	</c:if>
	</p>
<hr/>
<div id="slider" style="position:relative; width:1000;" align="right">
	<a href="#" id="prev2" class="prev"><img src="../images/uploadFiles/left.png" alt="����"></a>
	<div class="slide-wrap" >
		<ul id="photo" class="slide-list mt15" style="width: 220px;">
			<c:forEach var="vo" items="${list}">
				<td align="left">
				<c:if test="${param.menu=='manage'}">
					<td align="center" >
						<a href="/product/getProduct?prodNo=${vo.prodNo}&menu=manage"><img src="../images/uploadFiles/${vo.fileName }" alt="" width="250px" height="230px"></a>
					</td>
				</c:if>
				<c:if test="${param.menu=='search'}">
					<td align="left">
						<c:if test="${vo.proTranCode.trim()=='0'}">	
							<a href="/product/getProduct?prodNo=${vo.prodNo}&menu=search"><img src="../images/uploadFiles/${vo.fileName }" alt="" width="250px" height="230px"></a>
						</c:if>
						<c:if test="${vo.proTranCode.trim()!='0'}">
							<img src="../images/uploadFiles/${vo.fileName }" alt="" width="250px" height="230px">
						</c:if>
					</td>
				</c:if>
			</td>
			
			</c:forEach>
		</ul>
	</div>
	<a href="#" id="next2" class="next"><img src="../images/uploadFiles/right.png" alt="����"></a>
</div>
<div>
	<tr>
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
		
	</tr>
</div>
<script type="text/javascript">fn_rollToEx('slider', 'photo');</script>	
<hr/>
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	
	<tr>
	<td class="ct_line02"></td>
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
		<c:if test="${param.menu=='search'}">
			<td class="ct_line02"></td>
			<td class="ct_list_b" width="100">�� ��</td>
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
			<c:if test="${vo.proTranCode.trim()!='0'}"><td align="center">�����Ұ�</td></c:if>
		</c:if>
		<c:if test="${param.menu=='search'}">
			<td align="center"></td>
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
</form>

</div>
</body>
</html>
