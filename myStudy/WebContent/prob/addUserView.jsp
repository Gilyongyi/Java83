<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<form method='post' action='AddUser.jsp'>
<center>
<table border=0 whidth=2000 height=100 cellspacing="1">
<tr>
	<td colspan="3" align=left>�۰�������</td>
	<td align=right>����</td>
</tr>
<tr>
	<td bgcolor=#D5D5D5>* �̸�(�ѱ۽Ǹ�)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td colspan="3"><input type=text size=20 name=name></td>
</tr>
<tr>
	<td  bgcolor=#D5D5D5>* ����</td>
	<td colspan="3"> <input type=radio name=gender value=male>����
			 <input type=radio name=gender value=female>����</td>
</tr>
<tr>
	<td  bgcolor=#D5D5D5>* �������</td>
	<td><input type=text size=7 name=birth>��
	<select name=birth>
	<option>����<option value=1>1<option value=2>2
	<option value=3>3<option value=4>4<option value=5>5
	<option value=6>6<option value=7>7<option value=8>8
	<option value=9>9<option value=10>10<option value=11>11
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
	<td colspan="2"><input type=radio name=solar value=solar>���
			<input type=radio name=solar value=lunar>����
			<input type=radio name=solar value=leap>����</td>
<tr>
	<td  bgcolor=#D5D5D5>* �����з�</td>
	<td colspan="3"><select name=academic>
	<option>�����ϼ���
	<option value=high>�����б�
	<option value=univ>���б�
	</select></td>
</tr>
<tr>
	<td  bgcolor=#D5D5D5>* ����</td>
	<td><select name=job>
	<option>�����ϼ���
	<option>����
	<option>ȸ���
	</select></td>
	<td  bgcolor=#D5D5D5>&nbsp;�Ҽ�</td>
	<td><input type=name size=20 name=dept></td>
</tr>
<tr>
	<td  bgcolor=#D5D5D5>* ��ȥ����&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 </td>
	<td><input type=radio name=marital value=single>��ȥ
			<input type=radio name=marital value=married>��ȥ
	</td>
	<td  bgcolor=#D5D5D5>&nbsp;�ڳ��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td><select name=children><option>����
	<option value=0>0<option value=1>1<option value=2>2</select>��</td>
</tr>
<tr>
	<td rowspan="3"  bgcolor=#D5D5D5>* ����ó</td>
	<td>����ȭ��ȣ <input type=text size=4 name=phone>-<input type=text size=4 name=phone>-
	<input type=text size=4 name=phone></td>
	<td colspan="2"><input type=radio name=wherenum value=house>��
			<input type=radio name=wherenum value=workplace>����
	</td>
</tr>
<tr>
	<td>���޴���&nbsp;&nbsp;&nbsp;&nbsp;<input type=text size=4 name=phonenumber>-
	<input type=text size=4 name=phonenumber>-<input type=text size=4 name=phonenumber></td>
	<td bgcolor=#D5D5D5>&nbsp;�̵���Ż�  </td>
	<td><input type=radio name=telecom value=SKT>SKT
			<input type=radio name=telecom value=KTF>KTF
			<input type=radio name=telecom value=LGT>LGT
	</td>
</tr>
<tr>
	<th colspan="3" align=left>  ��ȭ��ȣ�� �޴�����ȣ 2���� �� �ϳ��� �ݵ�� �Է��ϼž� �մϴ�.</th>
</tr>
<tr>
	<td bgcolor=#D5D5D5>* ������ �ּ�</td>
	<td> <input type=text size=40 name=address></td> 
</center>

</table>
<input type=submit value=ȸ������>
</html>