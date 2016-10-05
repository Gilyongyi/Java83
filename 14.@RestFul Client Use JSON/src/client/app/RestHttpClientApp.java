package client.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import spring.domain.User;

public class RestHttpClientApp {

	public static void main(String[] args) throws Exception{
		System.out.println("\n---------------------------------");
		RestHttpClientApp.RequestHttpGet_UseJsonSimple();
		System.out.println("\n---------------------------------");
		RestHttpClientApp.RequestHttpGet_UseCodehaus();
		System.out.println("\n---------------------------------");
		RestHttpClientApp.RequestHttpPost_UseJsonSimple();
		System.out.println("\n---------------------------------");
		RestHttpClientApp.RequestHttpPost_UseCodeHaus();
		System.out.println("\n---------------------------------");
		RestHttpClientApp.RequestHttpPostData_UseJsonSimple();
		System.out.println("\n---------------------------------");
		RestHttpClientApp.RequestHttpPostData_UseCodeHaus();
		System.out.println("\n---------------------------------");
	}
	
	public static void RequestHttpGet_UseJsonSimple() throws Exception{
		
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/Spring14/user/json/user01"+
					"?name=user02&age=10";
		
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept","application/json");
		httpGet.setHeader("Content-Type","application/json");
		
		HttpResponse httpRespone = httpClient.execute(httpGet);
		
		System.out.println(httpRespone);
		System.out.println();
		
		HttpEntity httpEntity = httpRespone.getEntity();
		
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		System.out.println("[Server 에서 받은 Data 확인]");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
		
	}
	
	public static void RequestHttpGet_UseCodehaus() throws Exception{
		
		HttpClient httpClient = new DefaultHttpClient();
		
		String url ="http://127.0.0.1:8080/Spring14/user/json/user01"+
					"?name=user02&age=10";
		
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept","application/json");
		httpGet.setHeader("Content-Type","application/json");
		
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpEntity = httpResponse.getEntity();
		
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
		
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(jsonobj.get("user").toString(), User.class);
		System.out.println(user);
	}
	
	
	public static void RequestHttpPost_UseJsonSimple() throws Exception{
		
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/Spring14/user/json/user01";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept","application/json");
		httpPost.setHeader("Content-Type","application/json");
		
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpEntity = httpResponse.getEntity();
		
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		System.out.println("[Server에서 받은 Data 확인]");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
	}
	
	public static void RequestHttpPost_UseCodeHaus() throws Exception{
		
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/Spring14/user/json/user01";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept","application/json");
		httpPost.setHeader("Content-Type","application/json");
		
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		System.out.println(httpResponse);
		System.out.println();
		HttpEntity httpEntity = httpResponse.getEntity();
		
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
		
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(jsonobj.get("user").toString(), User.class);
		System.out.println(user);
		
	}
	
	public static void RequestHttpPostData_UseJsonSimple() throws Exception{
		
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/Spring14/user/json/getUser/user01";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept","application/json");
		httpPost.setHeader("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("userId", "test");
		json.put("userName", "홍길동");
		HttpEntity httpEntity01 = new StringEntity(json.toJSONString(),"utf-8");
		
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpEntity = httpResponse.getEntity();
		
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		System.out.println("[Server에서 받은 Data 확인]");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
		
	}
	
	public static void RequestHttpPostData_UseCodeHaus() throws Exception{
		
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/Spring14/user/json/user01";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept","application/json");
		httpPost.setHeader("Content-Type","application/json");
		
		User user01 = new User("test","홍길동","1111",null,10);
		ObjectMapper objectMapper01 = new ObjectMapper();
		String jsonValue = objectMapper01.writeValueAsString(user01);
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		System.out.println(httpResponse);
		System.out.println();
		
		HttpEntity httpEntity = httpResponse.getEntity();
				
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));				
		
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
		
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(jsonobj.get("user").toString(), User.class);
		System.out.println(user);
	}
	
}
