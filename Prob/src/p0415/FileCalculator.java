package p0415;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileCalculator {
		public void addCalculateResult(String inputFileName)throws Exception{
			int sum = 0;
			int mul = 1;
			
			BufferedReader br = new BufferedReader(new FileReader(inputFileName));
			BufferedWriter bw = new BufferedWriter(new FileWriter(inputFileName,true));
			
			for(int i=0;i<3;i++){
				String s = br.readLine();
				sum+=Integer.parseInt(s);
				mul*=Integer.parseInt(s);
				}
			
				bw.newLine();
				bw.write(String.valueOf(sum));
				bw.newLine();
				bw.write(String.valueOf(mul));
				bw.flush();
				bw.close();
				br.close();
			}
		
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		FileCalculator fc = new FileCalculator();
		fc.addCalculateResult("D:\\test.dat");
	}

}
