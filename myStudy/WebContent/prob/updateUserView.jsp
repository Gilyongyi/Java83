<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import ="jw.service.user.vo.UserVO" %>
    <%UserVO userVO=(UserVO)session.getAttribute("userVO");%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<form method='post' action='UpdateUser.jsp'>
<center>
<table border=0 whidth=2000 height=100 cellspacing="1">
<tr>
	<td colspan="3" align=left>○개인정보</td>
	<td align=right>도움말</td>
</tr>
<tr>
	<td bgcolor=#D5D5D5>* 이름(한글실명)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td colspan="3"><input type=text size=20 name=name value=<%=userVO.getName()%>></td>
</tr>
<tr>
	<td  bgcolor=#D5D5D5>* 성별</td>
	<td colspan="3"> 
	<%if(userVO.getGender()=="male") {%>
	<input type=radio name=gender value=male checked>남자
	<input type=radio name=gender value=female>여자
	<%}else{ %>
	<input type=radio name=gender value=male>남자
	<input type=radio name=gender value=female checked>여자
	<%} %>
	</td>
</tr>
<tr>
	<td  bgcolor=#D5D5D5>* 생년월일</td>
	<td><input type=text size=7 name=birth value=<%=userVO.getBirth() %>>년
	<select name=birth>
	<option>선택<option value=1><option value=2>2<option value=3>3
	<option value=4>4<option value=5>5<option value=6>6<option value=7>7
	<option value=8>8	<option value=9>9<option value=10>10<option value=11>11
	<option value=12>12
		
	</select>월
	<select name=birth>
	<option>선택<option value=1>1<option value=2>2<option value=3>3
	<option value=4>4<option value=5>5	<option value=6>6<option value=7>7<option value=8>8
	<option value=9>9<option value=10>10<option value=11>11<option value=12>12<option value=13>13	
	<option value=14>14<option value=15>15	<option value=16>16<option value=17>17<option value=18>18
	<option value=19>19<option value=20>20<option value=21>21<option value=22>22<option value=23>23
	<option value=24>24<option value=25>25<option value=26>26<option value=27>27	<option value=28>28
	<option value=29>29<option value=30>30<option value=31>31
	</select>일
	</td>
	<td colspan="2">
		<% if(userVO.getSolar()=="solar"){%>
		<input type=radio name=solar value=solar checked>양력
		<input type=radio name=solar value=lunar>음력
		<input type=radio name=solar value=leap>윤달
		<%}else if(userVO.getSolar()=="lunar"){%>
		<input type=radio name=solar value=solar>양력
		<input type=radio name=solar value=lunar checked>음력
		<input type=radio name=solar value=leap>윤달
		<%}else{ %>
		<input type=radio name=solar value=solar>양력
		<input type=radio name=solar value=lunar>음력
		<input type=radio name=solar value=leap checked>윤달	
		<%} %>	
	</td>
<tr>
	<td  bgcolor=#D5D5D5>* 최종학력</td>
	<td colspan="3"><select name=academic>
	<option>선택하세요
	<%if(userVO.getAcademic()=="high") {%>
	<option value=high checked>고졸
	<option value=univ>대졸
	<%}else{ %>
	<option value=high>고졸
	<option value=univ checked>대졸
	<%} %>
	</select></td>
</tr>
<tr>
	<td  bgcolor=#D5D5D5>* 직업</td>
	<td><select name=job>
	<option>선택하세요
	<%if(userVO.getJob()=="nojob") {%>
	<option value=nojob checked>무직
	<option value=ok>회사원
	<%}else{ %>
	<option value=nojob>무직
	<option value=ok checked>회사원
	<%}%>
	</select></td>
	
	<td  bgcolor=#D5D5D5>&nbsp;소속</td>
	<td><input type=name size=20 name=dept value=<%=userVO.getDept() %>></td>
</tr>
<tr>
	<td  bgcolor=#D5D5D5>* 결혼여부&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 </td>
	<td>
		<%if(userVO.getMarital()=="single"){ %>
		<input type=radio name=marital value=single checked>미혼
		<input type=radio name=marital value=married>기혼
		<%}else{ %>
		<input type=radio name=marital value=single>미혼
		<input type=radio name=marital value=married checked>기혼
		<%} %>
	</td>
	<td  bgcolor=#D5D5D5>&nbsp;자녀수&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td><select name=children width=40><option>선택
	<%if(userVO.getChildren()=="0"){ %>
		<option value=0 checked>0
		<option value=1>1
		<option value=2>2
		<%}else if(userVO.getChildren()=="1"){ %>
		<option value=0>0
		<option value=1 checked>1
		<option value=2>2
		<%}else{ %>
		<option value=0>0
		<option value=1>1
		<option value=2 checked>2
	<%} %>
	</select>명</td>
</tr>
<tr>
	<td rowspan="3"  bgcolor=#D5D5D5>* 연락처</td>
	<td>·전화번호 
	<input type=text size=4 name=phone>-<input type=text size=4 name=phone>-
	<input type=text size=4 name=phone></td>
	<td colspan="2">
		<%if(userVO.getWherenum()=="house"){ %>
		<input type=radio name=wherenum value=house checked>집
		<input type=radio name=wherenum value=workplace>직장
		<%}else{%>
		<input type=radio name=wherenum value=house>집
		<input type=radio name=wherenum value=workplace checked>직장
		<%} %>
		
	</td>
</tr>
<tr>
	<td>·휴대폰&nbsp;&nbsp;&nbsp;&nbsp;<input type=text size=4 name=phonenumber>-
	<input type=text size=4 name=phonenumber>-<input type=text size=4 name=phonenumber></td>
	<td bgcolor=#D5D5D5>&nbsp;이동통신사  </td>
	<td>
		<%if(userVO.getTelecom()=="SKT"){%>
		<input type=radio name=telecom value=SKT checked>SKT
		<input type=radio name=telecom value=KTF>KTF
		<input type=radio name=telecom value=LGT>LGT
		<%}else if(userVO.getTelecom()=="KTF"){%>
		<input type=radio name=telecom value=SKT>SKT
		<input type=radio name=telecom value=KTF checked>KTF
		<input type=radio name=telecom value=LGT>LGT
		<%}else{ %>
		<input type=radio name=telecom value=SKT>SKT
		<input type=radio name=telecom value=KTF>KTF
		<input type=radio name=telecom value=LGT checked>LGT
		<%} %>
	</td>
</tr>
<tr>
	<th colspan="3" align=left>  전화번호나 휴대폰번호 2가지 중 하나는 반드시 입력하셔야 합니다.</th>
</tr>
<tr>
	<td  bgcolor=#D5D5D5>* 거주지 주소</td>
	<td colspan="3">
	<input type=text name=address size=40 value=<%=userVO.getAddress()%>></td> 
</center>

</table>
<input type=submit value=내정보수정>

</html>