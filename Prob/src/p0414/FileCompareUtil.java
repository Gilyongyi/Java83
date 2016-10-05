package p0414;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
public class FileCompareUtil {
	
	public ArrayList compareFile(String fstFileName,String scdFileName)throws Exception{
		ArrayList arr=new ArrayList(3);
		BufferedReader br1 = new BufferedReader(new FileReader(fstFileName));
		BufferedReader br2 = new BufferedReader(new FileReader(scdFileName));
		for(int i=0;i<3;i++){
			String s2=br2.readLine();
		if(br1.readLine().equals(s2)){
			}else{
			arr.add("Line "+(i+1)+": "+s2);
			}
		}
		br1.close();
		br2.close();
		return arr;
	}
	
	public static void main(String []args)throws Exception{
		System.out.println(new FileCompareUtil().compareFile("./files/fstFile1.txt","./files/scdFile1.txt"));
		System.out.println("Successful!!!");
		}

}
