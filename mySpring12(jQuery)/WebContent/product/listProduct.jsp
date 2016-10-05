<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>상품 목록조회</title>
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

		// 롤링할 객체를 변수에 담아둔다.
		var el = $('#'+containerID).find('#'+slideID);
		var lastChild;
		var speed = 3000;
		var timer = 0;

		el.data('prev', $('#'+containerID).find('.prev'));	//이전버튼을 data()메서드를 사용하여 저장한다.
		el.data('next', $('#'+containerID).find('.next'));	//다음버튼을 data()메서드를 사용하여 저장한다.
		el.data('size', el.children().outerWidth());		//롤링객체의 자식요소의 넓이를 저장한다.
		el.data('len', el.children().length);				//롤링객체의 전체요소 개수
		el.data('animating',false);

		el.css('width',el.data('size')*el.data('len'));		//롤링객체의 전체넓이 지정한다.

		//el에 첨부된 prev 데이타를 클릭이벤트에 바인드한다.
		el.data('prev').bind({
			click:function(e){
				e.preventDefault();
				movePrevSlide();
			}
		});

		//el에 첨부된 next 데이타를 클릭이벤트에 바인드한다.
		el.data('next').bind({
			click:function(e){
				e.preventDefault();
				moveNextSlide();
			}
		});

		function movePrevSlide(){
			if(!el.data('animating')){
				//롤링객체의 끝에서 요소를 선택하여 복사한후 변수에 저장한다.
				var lastItem = el.children().eq(-2).nextAll().clone(true);
				lastItem.prependTo(el);		//복사된 요소를 롤링객체의 앞에 붙여놓는다.
				el.children().eq(-2).nextAll().remove();	//선택된 요소는 끝에서 제거한다
				el.css('left','-'+(el.data('size')*1+'px'));	//롤링객체의 left위치값을 재설정한다.
			
				el.data('animating',true);	//애니메이션 중복을 막기 위해 첨부된 animating 데이타를 true로 설정한다.

				el.animate({'left': '0px'},'normal',function(){		//롤링객체를 left:0만큼 애니메이션 시킨다.
					el.data('animating',false);
				});
			}
			return false;
		}

		function moveNextSlide(){
			if(!el.data('animating')){
				el.data('animating',true);

				el.animate({'left':'-'+(el.data('size')*1)+'px'},'normal',function(){	//롤링객체를 애니메이션 시킨다.
					//롤링객체의 앞에서 요소를 선택하여 복사한후 변수에 저장한다.
					var firstChild = el.children().filter(':lt('+1+')').clone(true);
					firstChild.appendTo(el);	//복사된 요소를 롤링객체의 끝에 붙여놓는다.
					el.children().filter(':lt('+1+')').remove();	//선택된 요소를 앞에서 제거한다
					el.css('left','0px');	////롤링객체의 left위치값을 재설정한다.

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
					<c:if test="${param.menu=='manage' }">상품관리 [Admin Page]</c:if>
					<c:if test="${param.menu=='search' }">상품 목록조회 </c:if>
						<td colspan="11" ><h3>전체 ${page.totalCount} 건수<br/> 현재 ${page.currentPage} 페이지 </h3> </td>
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
<hr/>
	<p align="center" id="toggle">
	<c:if test="${param.menu=='search'}">
		●상품 미리보기 [구매 가능한 상품만 <a>Click</a> 가능합니다]
	</c:if>
	<c:if test="${param.menu=='manage'}">
		●상품 미리보기 [수정 가능한 상품만 <a>Click</a> 가능합니다]
	</c:if>
	</p>
<hr/>
<div id="slider" style="position:relative; width:1000;" align="right">
	<a href="#" id="prev2" class="prev"><img src="../images/uploadFiles/left.png" alt="이전"></a>
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
	<a href="#" id="next2" class="next"><img src="../images/uploadFiles/right.png" alt="다음"></a>
</div>
<div>
	<tr>
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
		
	</tr>
</div>
<script type="text/javascript">fn_rollToEx('slider', 'photo');</script>	
<hr/>
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	
	<tr>
	<td class="ct_line02"></td>
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
		<c:if test="${param.menu=='search'}">
			<td class="ct_line02"></td>
			<td class="ct_list_b" width="100">비 고</td>
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
			<c:if test="${vo.proTranCode.trim()!='0'}"><td align="center">삭제불가</td></c:if>
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
