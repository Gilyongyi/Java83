package p0413;

public class Prob {
	public void calc(int[] ix){
		int odd=0;
		int even=0;
		for(int i=0;i<ix.length;i++){
				if(ix[i]%2==0){
					even+=ix[i];
				}else{
					odd+=ix[i];
				}
			}
		System.out.println("홀수의합 : "+odd);
		System.out.println("짝수의합 : "+even);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ia = new int[]{3,7,1,8,10,2,15,2,10};
		int[] ib = new int[]{1,2,3,4,5};
		
		Prob p = new Prob();
		System.out.println("(배열 ia)");
		p.calc(ia);
		System.out.println("(배열 ib)");
		p.calc(ib);
	}

}
