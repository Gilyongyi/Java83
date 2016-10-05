package p0413;

public class Prob3 {
	
	public String toEncoding(String str){
		String encodedString="";
			for(int i=0;i<str.length();i++){
				char c=str.charAt(i);
				if(c>='A'&& c<='z' || c>='0'&&c<='9' || c==' '){
					encodedString+=c;
				}else{
					String t="";
					t+=c+"";
					byte[] temp = t.getBytes();
					for(int j=0;j<temp.length;j++){
					encodedString+="%"+Integer.toHexString(temp[j]).toUpperCase().substring(6, 8);
						}
					}
			//if(Integer.toHexString(temp[i])=="20"){
				//encodedString+="%";
				//encodedString+=Integer.toHexString(temp[i]).toUpperCase();
				/*}else if(Integer.toHexString(temp[i]).charAt(i)=='F'){
					encodedString+="%";
					encodedString+=Integer.toHexString(temp[i]).substring(2).toUpperCase();
				}else{
					encodedString+="%";
					encodedString+=Integer.toHexString(temp[i]).toUpperCase();
					//encodedString+="%";
					//encodedString+=Integer.toHexString(temp[j++]).toUpperCase().substring(2);
				}*/
			}
		return encodedString;
		}
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prob3 p1 = new Prob3();
		System.out.println("입력 :Korea");
		System.out.println("출력 :" +p1.toEncoding("Korea"));
		System.out.println("입력 :홍길동");
		System.out.println("출력 :" +p1.toEncoding("홍길동"));
		System.out.println("입력 :홍 길 동");
		System.out.println("출력 :" +p1.toEncoding("홍 길 동"));
		System.out.println("입력 :Hong 길 동");
		System.out.println("출력 :" +p1.toEncoding("Hong 길 동"));
		System.out.println("입력 :0319");
		System.out.println("출력 :" +p1.toEncoding("0319"));
	}

}
