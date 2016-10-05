package p0412;

public class Prob {
	
	public static String myReplace(String str,char oldChar,char newChar){
		/*str=str.replace(oldChar, newChar);
		return str;*/
		String s="";
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==oldChar){
				s+=newChar;
			}else{
				s+=str.charAt(i);
				}
			}
		return s;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("문자열에 특정 문자 변경하는 테스트");
		System.out.println("-------Sample1----------");
		String str1=myReplace("hello world",'l','*');
		System.out.println(str1);
		System.out.println("-------Sample2----------");
		String str2=myReplace("hello world",' ','-');	
		System.out.println(str2);
		System.out.println("-------Sample3----------");
		String str3=myReplace("hello world",'a','*');
		System.out.println(str3);
	}

}
