package p0418;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Prob {

	public Vector getScore(String fileName) throws IOException{
		Vector v= new Vector();
		BufferedReader br= new BufferedReader(new FileReader("src/data01.txt"));
		String str="";
		
		while((str=br.readLine())!=null){
			String [] arrStr = str.split("/");
			String name=arrStr[0];
			int kor=Integer.parseInt(arrStr[1]);
			int eng=Integer.parseInt(arrStr[2]);
			int math=Integer.parseInt(arrStr[3]);
			int sum = kor+eng+math;
			
			Score score = new Score(name, kor, eng, math, sum);
		
			v.add(score);
		}
		return v;
	}
	
	class Score{
		private String name;
		private int kor;
		private int eng;
		private int math;
		private int sum;
		
		public Score(String name, int kor, int eng, int math, int sum) {
			super();
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
			this.sum = sum;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getKor() {
			return kor;
		}

		public void setKor(int kor) {
			this.kor = kor;
		}

		public int getEng() {
			return eng;
		}

		public void setEng(int eng) {
			this.eng = eng;
		}

		public int getMath() {
			return math;
		}

		public void setMath(int math) {
			this.math = math;
		}

		public int getSum() {
			return sum;
		}

		public void setSum(int sum) {
			this.sum = sum;
		}
						
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Prob p2 = new Prob();
		Vector scores = p2.getScore("src/data.txt");
		for(int i=0;i<scores.size();i++){
			Score score = (Score)scores.get(i);
			System.out.println(score.getName()+" : "
								+score.getKor()+" "+score.getEng()+" "
								+score.getMath()+" "+score.getSum());		
		}
	}

}
