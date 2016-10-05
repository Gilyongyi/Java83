package json.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JSONDecodingTestApp {

	public static void main(String[] args){
		String date = "{\"address\":\"서울\",\"age\":1000,\"name\":\"홍길동\"}";
		JSONObject jsonObj = (JSONObject)JSONValue.parse(date);
		
		System.out.println("DATA 확인 : "+jsonObj);
		System.out.println("====DATA 추출====");
		System.out.println(jsonObj.get("address"));
		System.out.println("\n\n");
		
		String arrayDate ="[\"서울\",1000,\"홍길동\"]";
		JSONArray jsonArray = (JSONArray)JSONValue.parse(arrayDate);
		
		System.out.println("DATA 확인 : "+jsonArray);
		System.out.println("====DATA 추출====");
		System.out.println(jsonArray.get(0));
	}
}
