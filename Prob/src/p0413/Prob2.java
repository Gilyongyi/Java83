package p0413;

public class Prob2 {
	
	private static String[] stringSplit(String str1,String str2){
		StringBuffer s=new StringBuffer();
		String []ss=new String[5];
		int j=0;
		for(int i=0;i<str1.length();i++){
			if(str1.charAt(i)!=str2.charAt(0)){
				s.append(str1.charAt(i));
			}
			if(str1.charAt(i)==str2.charAt(0)){
				ss[j]=s.toString();
				s.delete(0, s.length());
				j++;
			}
			if(i==(str1.length()-1)){
				ss[j]=s.toString();
			}
		}
		return ss;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="PROD_001#X-note#Damsung#3#6000000";
		String[] strs = stringSplit(str,"#");
		System.out.println("===문자열 처리 결과===");
		for(int i=0;i<strs.length;i++){
			System.out.println(strs[i]);
		}
	}
}
