package p0414;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;
public class FileController {
	String fileName="";
	String fileNameNext="";
	Vector<String> s1 = new Vector<String>(5);
	public void reverseLine(String oldf,String newf)throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader(oldf));
		BufferedWriter bw= new BufferedWriter(new FileWriter(newf));
		String s = null;
		while((s = br.readLine()) !=null){
			s1.add(s);
			}
			for(int i=3;i>=0;i--){
				s1.get(i);
				bw.write(s1.get(i));
				bw.newLine();
			}
			br.close();
			bw.close();
		}
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String oldf="files/oldf.txt";
		String newf="files/newf.txt";
		new FileController().reverseLine(oldf,newf);
		
	}

}
