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
	<td colspan="3" align=left>�۰�������</td>
	<td align=right>����</td>
</tr>
<tr>
	<td bgcolor=#D5D5D5>* �̸�(�ѱ۽Ǹ�)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td colspan="3"><input type=text size=20 name=name value=<%=userVO.getName()%>></td>
</tr>
<tr>
	<td  bgcolor=#D5D5D5>* ����</td>
	<td colspan="3"> 
	<%if(userVO.getGender()=="male") {%>
	<input type=radio name=gender value=male checked>����
	<input type=radio name=gender value=female>����
	<%}else{ %>
	<input type=radio name=gender value=male>����
	<input type=radio name=gender value=female checked>����
	<%} %>
	</td>
</tr>
<tr>
	<td  bgcolor=#D5D5D5>* �������</td>
	<td><input type=text size=7 name=birth value=<%=userVO.getBirth() %>>��
	<select name=birth>
	<option>����<option value=1><option value=2>2<option value=3>3
	<option value=4>4<option value=5>5<option value=6>6<option value=7>7
	<option value=8>8	<option value=9>9<option value=10>10<option value=11>11
	<option value=12>12
		
	</select>��
	<select name=birth>
	<option>����<option value=1>1<option value=2>2<option value=3>3
	<option value=4>4<option value=5>5	<option value=6>6<option value=7>7<option value=8>8
	<option value=9>9<option value=10>10<option value=11>11<option value=12>12<option value=13>13	
	<option value=14>14<option value=15>15	<option value=16>16<option value=17>17<option value=18>18
	<option value=19>19<option value=20>20<option value=21>21<option value=22>22<option value=23>23
	<option value=24>24<option value=25>25<option value=26>26<option value=27>27	<option value=28>28
	<option value=29>29<option value=30>30<option value=31>31
	</select>��
	</td>
	<td colspan="2">
		<% if(userVO.getSolar()=="solar"){%>
		<input type=radio name=solar value=solar checked>���
		<input type=radio name=solar value=lunar>����
		<input type=radio name=solar value=leap>����
		<%}else if(userVO.getSolar()=="lunar"){%>
		<input type=radio name=solar value=solar>���
		<input type=radio name=solar value=lunar checked>����
		<input type=radio name=solar value=leap>����
		<%}else{ %>
		<input type=radio name=solar value=solar>���
		<input type=radio name=solar value=lunar>����
		<input type=radio name=solar value=leap checked>����	
		<%} %>	
	</td>
<tr>
	<td  bgcolor=#D5D5D5>* �����з�</td>
	<td colspan="3"><select name=academic>
	<option>�����ϼ���
	<%if(userVO.getAcademic()=="high") {%>
	<option value=high checked>����
	<option value=univ>����
	<%}else{ %>
	<option value=high>����
	<option value=univ checked>����
	<%} %>
	</select></td>
</tr>
<tr>
	<td  bgcolor=#D5D5D5>* ����</td>
	<td><select name=job>
	<option>�����ϼ���
	<%if(userVO.getJob()=="nojob") {%>
	<option value=nojob checked>����
	<option value=ok>ȸ���
	<%}else{ %>
	<option value=nojob>����
	<option value=ok checked>ȸ���
	<%}%>
	</select></td>
	
	<td  bgcolor=#D5D5D5>&nbsp;�Ҽ�</td>
	<td><input type=name size=20 name=dept value=<%=userVO.getDept() %>></td>
</tr>
<tr>
	<td  bgcolor=#D5D5D5>* ��ȥ����&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 </td>
	<td>
		<%if(userVO.getMarital()=="single"){ %>
		<input type=radio name=marital value=single checked>��ȥ
		<input type=radio name=marital value=married>��ȥ
		<%}else{ %>
		<input type=radio name=marital value=single>��ȥ
		<input type=radio name=marital value=married checked>��ȥ
		<%} %>
	</td>
	<td  bgcolor=#D5D5D5>&nbsp;�ڳ��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td><select name=children width=40><option>����
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
	</select>��</td>
</tr>
<tr>
	<td rowspan="3"  bgcolor=#D5D5D5>* ����ó</td>
	<td>����ȭ��ȣ 
	<input type=text size=4 name=phone>-<input type=text size=4 name=phone>-
	<input type=text size=4 name=phone></td>
	<td colspan="2">
		<%if(userVO.getWherenum()=="house"){ %>
		<input type=radio name=wherenum value=house checked>��
		<input type=radio name=wherenum value=workplace>����
		<%}else{%>
		<input type=radio name=wherenum value=house>��
		<input type=radio name=wherenum value=workplace checked>����
		<%} %>
		
	</td>
</tr>
<tr>
	<td>���޴���&nbsp;&nbsp;&nbsp;&nbsp;<input type=text size=4 name=phonenumber>-
	<input type=text size=4 name=phonenumber>-<input type=text size=4 name=phonenumber></td>
	<td bgcolor=#D5D5D5>&nbsp;�̵���Ż�  </td>
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
	<th colspan="3" align=left>  ��ȭ��ȣ�� �޴�����ȣ 2���� �� �ϳ��� �ݵ�� �Է��ϼž� �մϴ�.</th>
</tr>
<tr>
	<td  bgcolor=#D5D5D5>* ������ �ּ�</td>
	<td colspan="3">
	<input type=text name=address size=40 value=<%=userVO.getAddress()%>></td> 
</center>

</table>
<input type=submit value=����������>

</html>