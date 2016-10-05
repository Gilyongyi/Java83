<%@ page contentType="text/html; charset=euc-kr" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
	tr:nth-child(4n){
		background-color: BDBDBD;
	}
	tr:nth-child(4n+2){
		background-color: EAEAEA;
	}
	
</style>

<c:if test="${ page.currentPage <= page.pageUnit }">
			◀ 이전
	</c:if>
	<c:if test="${ page.currentPage > page.pageUnit }">
			<a href="javascript:fncGetList('${page.beginUnitPage-1}')">◀ 이전</a>
	</c:if>
	
	<c:forEach var="i"  begin="${page.beginUnitPage}" end="${page.endUnitPage}" step="1">
		<a href="javascript:fncGetList('${ i }');">${ i }</a>
	</c:forEach>
	
	<c:if test="${ page.endUnitPage >= page.maxPage }">
			이후 ▶
	</c:if>
	<c:if test="${ page.endUnitPage < page.maxPage }">
			<a href="javascript:fncGetList('${page.endUnitPage+1}')">이후 ▶</a>
	</c:if>