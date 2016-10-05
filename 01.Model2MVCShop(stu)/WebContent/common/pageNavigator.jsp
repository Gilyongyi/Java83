<%@ page contentType="text/html; charset=euc-kr" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<c:if test="${ pageVO.currentPage <= pageVO.pageUnit }">
			◀ 이전
	</c:if>
	<c:if test="${ pageVO.currentPage > pageVO.pageUnit }">
			<a href="javascript:fncGetList('${pageVO.beginUnitPage-1}')">◀ 이전</a>
	</c:if>
	
	<c:forEach var="i"  begin="${pageVO.beginUnitPage}" end="${pageVO.endUnitPage}" step="1">
		<a href="javascript:fncGetList('${ i }');">${ i }</a>
	</c:forEach>
	
	<c:if test="${ pageVO.endUnitPage >= pageVO.maxPage }">
			이후 ▶
	</c:if>
	<c:if test="${ pageVO.endUnitPage < pageVO.maxPage }">
			<a href="javascript:fncGetList('${pageVO.endUnitPage+1}')">이후 ▶</a>
	</c:if>