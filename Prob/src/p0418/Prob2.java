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
		
		System.out.println("�й��� �Է��ϼ���");
		stdNum=keyboard.nextLine();
		System.out.println("���� ������ �Է��ϼ���");
		kor = keyboard.nextInt();
		System.out.println("���� ������ �Է��ϼ���");
		math = keyboard.nextInt();
		System.out.println("���� ������ �Է��ϼ���");
		eng = keyboard.nextInt();
		System.out.println("�ڹ� ������ �Է��ϼ���");
		java = keyboard.nextInt();
		
		sum=kor+math+eng+java;
		avg=sum/4;
		PrintWriter pw = new PrintWriter(new FileWriter("./src/test.txt"));		
		pw.println("===========================");
		pw.println("�й� : "+stdNum);
		pw.println("===========================");
		pw.println("���� : "+kor);
		pw.println("���� : "+math);
		pw.println("���� : "+eng);
		pw.println("�ڹ� : "+java);
		pw.println("===========================");
		pw.println("���� : "+sum);
		pw.println("��� : "+avg);
		pw.println("���� : "+Prob2.checkGrade(avg));
		pw.close();
	}

}
