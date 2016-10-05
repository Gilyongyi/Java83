package p0412;

public class CellPhoneMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CellPhoneB myPhone = new CellPhoneB("SCH-600");
		
		myPhone.charge(20);
		myPhone.printBattery();
		
		myPhone.call(300);
		myPhone.printBattery();
		
		myPhone.charge(50);
		myPhone.printBattery();
		
		myPhone.call(40);
		myPhone.printBattery();
		
		try{
		myPhone.call(-20);
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		
		CellPhoneB yourPhone = new CellPhoneB("SCH-600");
		
		System.out.println(myPhone instanceof CellPhoneB);
		
		if(myPhone.equals(yourPhone)){
			System.out.println("동일모델입니다");
		}else{
			System.out.println("다른모델입니다");
			
		}
	}
}