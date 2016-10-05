package p0418;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
public class Prob2 {
	public static char checkGrade(double avg){
		char grade=0;
		switch(((int)avg/10)){
		case 10:
		case 9:
			grade='A';
			break;
		case 8:
			grade='B';
			break;
		case 7:
			grade='C';
			break;
		case 6:
			grade='D';
			break;
		default:
			grade='F';
			break;
		}
		return grade;

	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String stdNum ="";
		int kor = 0;
		int math = 0;
		int eng = 0;
		int java = 0;
		int sum = 0;
		double avg = 0;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("학번을 입력하세요");
		stdNum=keyboard.nextLine();
		System.out.println("국어 성적을 입력하세요");
		kor = keyboard.nextInt();
		System.out.println("수학 성적을 입력하세요");
		math = keyboard.nextInt();
		System.out.println("영어 성적을 입력하세요");
		eng = keyboard.nextInt();
		System.out.println("자바 성적을 입력하세요");
		java = keyboard.nextInt();
		
		sum=kor+math+eng+java;
		avg=sum/4;
		PrintWriter pw = new PrintWriter(new FileWriter("./src/test.txt"));		
		pw.println("===========================");
		pw.println("학번 : "+stdNum);
		pw.println("===========================");
		pw.println("국어 : "+kor);
		pw.println("수학 : "+math);
		pw.println("영어 : "+eng);
		pw.println("자바 : "+java);
		pw.println("===========================");
		pw.println("총점 : "+sum);
		pw.println("평균 : "+avg);
		pw.println("학점 : "+Prob2.checkGrade(avg));
		pw.close();
	}

}
