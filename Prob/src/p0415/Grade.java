package p0415;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Grade {
	public void printGrade(String fileName) throws IOException{
		int sum=0;
		int avg=0;
		String s="";
		String []ss=new String[2];
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		for(int i=0;i<ss.length+2;i++){
			s=br.readLine();
			ss =s.split(",");
			sum+=Integer.parseInt(ss[1]);
			avg+=Integer.parseInt(ss[1]);
			System.out.println(ss[0]+"�� ������ "+ss[1]+"�� �Դϴ�.");
			}
		
			System.out.println("����� ������ "+sum+"�� �Դϴ�");
			System.out.println("����� ����� "+(avg/4)+"�� �Դϴ�");
		
		br.close();

	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Grade grade = new Grade();
		String fileName = "score.txt";
		grade.printGrade(fileName);
	}

}
