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
		System.out.println("�Է� :Korea");
		System.out.println("��� :" +p1.toEncoding("Korea"));
		System.out.println("�Է� :ȫ�浿");
		System.out.println("��� :" +p1.toEncoding("ȫ�浿"));
		System.out.println("�Է� :ȫ �� ��");
		System.out.println("��� :" +p1.toEncoding("ȫ �� ��"));
		System.out.println("�Է� :Hong �� ��");
		System.out.println("��� :" +p1.toEncoding("Hong �� ��"));
		System.out.println("�Է� :0319");
		System.out.println("��� :" +p1.toEncoding("0319"));
	}

}
