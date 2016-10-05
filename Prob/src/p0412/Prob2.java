package p0412;

import java.util.Vector;

public class Prob2 {
	
	public Vector<String>dataChange(String[]strData){
		Vector<String> vector =new Vector<String>(4,strData.length);
		for(int i=strData.length-1;i>=0;i--){
			String u="";
			for(int j=strData[i].length()-1;j>=0;j--){
			char c=strData[i].charAt(j);
				u+=c;
				}
			vector.add(u);
			}	
		return vector;
	}
	
	public static void main(String []args){
		Prob2 st = new Prob2();
		String[]strData ={"Java Programming","JDBC","Oracle10g","JSP/Servlet"};
		Vector<String>v=st.dataChange(strData);
		
		for(int i=0;i<v.size();i++){
			System.out.println(v.elementAt(i));
		}
		/*for(String str : v){
			System.out.println(v +"\n");
		}*/
	}

}
