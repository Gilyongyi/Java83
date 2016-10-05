package json.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JSONDecodingTestApp {

	public static void main(String[] args){
		String date = "{\"address\":\"����\",\"age\":1000,\"name\":\"ȫ�浿\"}";
		JSONObject jsonObj = (JSONObject)JSONValue.parse(date);
		
		System.out.println("DATA Ȯ�� : "+jsonObj);
		System.out.println("====DATA ����====");
		System.out.println(jsonObj.get("address"));
		System.out.println("\n\n");
		
		String arrayDate ="[\"����\",1000,\"ȫ�浿\"]";
		JSONArray jsonArray = (JSONArray)JSONValue.parse(arrayDate);
		
		System.out.println("DATA Ȯ�� : "+jsonArray);
		System.out.println("====DATA ����====");
		System.out.println(jsonArray.get(0));
	}
}
