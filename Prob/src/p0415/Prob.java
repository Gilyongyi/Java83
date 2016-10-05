package p0415;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Prob {
	
	public Vector getList() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("list.txt"));
		Vector<String> v= new Vector<String>();
		String s="";
		String [] ss= new String[12];
		for(int i=0;i<4;i++){
			s=br.readLine();
			ss=s.split("/");
			String pName=ss[0];
			int score=Integer.parseInt(ss[1]);
			
			v.add(ss[0]+","+ss[1]+","+ss[2]+",수료");
			if("java".equalsIgnoreCase(pName)||"JAVA".equalsIgnoreCase(pName)){
				if(score>=85){
				v.add(ss[0]+","+ss[1]+","+ss[2]+",수료");
				}else{
					v.add(ss[0]+","+ss[1]+","+ss[2]+",미수료");	
					}
				}
			else{
				if(score>=90){
				v.add(ss[0]+","+ss[1]+","+ss[2]+",수료");
				}else{
					v.add(ss[0]+","+ss[1]+","+ss[2]+",미수료");	
					}
				}	
			}
			System.out.println(v);
		br.close();
				
		return v;
		
	}
		public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Prob e = new Prob();
		Vector scores = e.getList();
		for(int i=0;i<scores.size();i++){
			System.out.println(scores.get(i));
		}
	}
}
/*	v=ss;
if(v[1]=="java" || v[1]=="JAVA"){
	if(Integer.parseInt(v[2])>=80){
		System.out.println(v[0]+","+v[1]+","+v[2]+"수료");
	}else{
		System.out.println(v[0]+","+v[1]+","+v[2]+"미수료");
	}
if(v[1]=="SQL" || v[1]=="sql"){
	if(Integer.parseInt(v[2])>=90){
		System.out.println(v[0]+","+v[1]+","+v[2]+"수료");
	}else{
		System.out.println(v[0]+","+v[1]+","+v[2]+"미수료");
		}
	}
}*/
