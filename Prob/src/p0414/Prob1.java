package p0414;

public class Prob1 {

	private static String getParameter(String url, String paramName){
		//int a = url.indexOf(paramName);
		//System.out.println(url.indexOf("&", a));
		url=url.substring(url.indexOf(paramName),url.indexOf("&", url.indexOf(paramName)));
		url=url.substring(url.indexOf("=")+1);
		
		return url;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url1="http://localhost/order?prodid=PROD_001&prodName=������3&price=980000";
		String prodName=getParameter(url1,"prodName");
		System.out.println("��ǰ �̸� : "+prodName);
		
		String url2="http://localhost/registUser?userId=USER_001&userName=ȫ�浿&address=����� ������&userAge=28";
		String userAddress = getParameter(url2,"address");
		System.out.println("ȸ�� �ּ� : "+userAddress);
		

	}

}
