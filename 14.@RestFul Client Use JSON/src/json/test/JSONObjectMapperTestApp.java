package json.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import spring.domain.User;

public class JSONObjectMapperTestApp {

	public static void main(String[]args) throws Exception{
		User user = new User("user01","홍길동","1111",null,10);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		System.out.println("1.Object ->JSON Value(String)로 변환");
		String jsonValue = objectMapper.writeValueAsString(user);
		System.out.println(jsonValue);
		
		System.out.println("\n1.JSON Value=>Object 변환 및 값 추출 :ObjectMapper");
		User returnUser = objectMapper.readValue(jsonValue, User.class);
		System.out.println(returnUser);
		System.out.println("userId : "+returnUser.getUserId());
		
		System.out.println("\n1.JSON Value=>값 추출 :JSONObject");
		JSONObject jsonObj=(JSONObject)JSONValue.parse(jsonValue);
		String str=(String)jsonObj.get("userId");
		System.out.println("userId : "+str);
		System.out.println("\n\n");
		
		List<User> list = new ArrayList<User>(10);
		list.add(user);
		list.add(new User("user02","홍길동","2222",null,20));
		
		System.out.println("2.List =>JSON Value(String)로 변환");
		jsonValue = objectMapper.writeValueAsString(list);
		System.out.println(jsonValue);
		
		System.out.println("\n2.JSON Value(String)=>List 변환 및 값 추출:ObjectMapper");
		List<User> returnList = objectMapper.readValue(jsonValue, new TypeReference<List<User>>(){});
		System.out.println(returnList);
		returnUser = returnList.get(0);
		System.out.println(returnUser);
		System.out.println("userId : "+returnUser.getUserId());
		
		System.out.println("\n2.JSON Value=>값 추출 : JSONObject");
		JSONArray jsonArray = (JSONArray)JSONValue.parse(jsonValue);
		System.out.println(jsonArray);
		jsonObj = (JSONObject)jsonArray.get(0);
		str = (String)jsonObj.get("userId");
		System.out.println("userId  " +str);
		System.out.println("\n\n");
		
		Map<String,User> map = new HashMap<String,User>();
		map.put("1", user);
		map.put("2",new User("user02","홍길동","2222",null,20));
		
		System.out.println("3.Map =>JSON Value(String)로 변환");
		jsonValue = objectMapper.writeValueAsString(map);
		System.out.println(jsonValue);
		
		System.out.println("\n3.JSON Value(String)=>Map 로 변환 및 값 추출 : ObjectMapper");
		Map<String,User> returnMap = objectMapper.readValue(jsonValue, new TypeReference<Map<String,User>>(){});
		System.out.println(returnMap);
		returnUser = returnMap.get("1");
		System.out.println(returnUser);
		System.out.println(returnUser.getUserId());
		
		System.out.println("\n3.JSON Value=>추출 : JSONObject");
		jsonObj = (JSONObject)JSONValue.parse(jsonValue);
		System.out.println(jsonObj);
		jsonObj = (JSONObject)jsonObj.get("1");
		System.out.println(jsonObj);
		str= (String)jsonObj.get("userId");
		System.out.println("userId : "+str);
		
	}
}
