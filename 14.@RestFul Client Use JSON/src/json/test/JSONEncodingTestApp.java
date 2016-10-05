package json.test;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONEncodingTestApp {
	
	public static void main(String []args){
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "ȫ�浿");
		jsonObj.put("age", new Integer(1000));
		jsonObj.put("address", "����");
		
		System.out.println("DATA Ȯ�� : " +jsonObj);
		System.out.println("=====DATA ����=======");
		System.out.println(jsonObj.get("address"));
		System.out.println("\n\n");
		
		JSONObject innerJsonObj = new JSONObject();
		innerJsonObj.put("name", "ȫ�浿");
		innerJsonObj.put("age", new Integer(1000));
		innerJsonObj.put("address", "inner����");
		jsonObj.put("innerJson", innerJsonObj);
		
		System.out.println("DATA Ȯ�� : "+jsonObj);
		System.out.println("=====DATA ����=====");
		System.out.println(jsonObj.get("address"));
		JSONObject returnJsonObj =(JSONObject)jsonObj.get("innerJson");
		System.out.println(returnJsonObj.get("address"));
		System.out.println("\n\n");
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("����1", "���");
		map.put("����2", "�븮");
		map.put("����3", "����");
		jsonObj.put("career", map);
		
		System.out.println("DATA Ȯ�� : "+jsonObj);
		System.out.println(jsonObj.get("career"));
		Map returnMap = (Map)jsonObj.get("career");
		System.out.println(returnMap.get("����1"));
		System.out.println("\n\n");
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(new Integer(1));
		jsonArray.add("2");
		jsonArray.add("3");
		jsonObj.put("number", jsonArray);
		
		System.out.println("DATA Ȯ�� : " +jsonObj);
		System.out.println(jsonObj.get("number"));
		JSONArray returnJsonArray = (JSONArray)jsonObj.get("number");
		System.out.println(returnJsonArray.get(0));
	}
}