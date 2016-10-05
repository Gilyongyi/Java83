package p0415;

import java.util.Random;

public class Prob2 {
	private static int[] generateRandomNumber(){
		int [] arr = new int [21];
		Random rd = new Random();
		for(int i=0;i<=10;i++){
			int val = rd.nextInt(20);
			if(val==0){
				val=20;
			}
			arr[i]=val;
		}
		
		return arr;
	}
	public static void printStatistics(int[] array){
		int max =0;
		int min =array[0];
		int avg =0;
		
		for(int i=0;i<10;i++){
			System.out.println(array[i]);
			if(max<=array[i]){
				max=array[i];
			}
			if(min>=array[i]){
				min=array[i];
			}
			avg+=array[i];
		}
			System.out.println("최대값 : "+max);
			System.out.println("최소값 : "+min);
			System.out.println("평균값 : "+avg/20);
	}
	public static void main(String[]args){
		int[] array= generateRandomNumber();
		printStatistics(array);
		
	}
}
