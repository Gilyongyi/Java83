package p0412;

public class Prob3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CellPhone cellPhone = new CellPhone("010-010-010",1000);
		cellPhone.call("017-017-017",10);
		cellPhone.call("016-016-016",10);
		cellPhone.calculationTotalFee();
		System.out.println(cellPhone.getPhoneNumber()+"�� ��ȭ�ð���"
				+cellPhone.getTotalCallTime()+"�̸� \n"+"�ܰ�"+cellPhone.getFeePerCallTime()+
				"�ѿ����"+cellPhone.getTotalFee()+"�� �Դϴ�.");
		System.out.println("=================================");
		
		SmartPhone smartPhone = new SmartPhone("000-000-000",200);
		smartPhone.call("017-017-017",10);
		smartPhone.calculationTotalFee();
		System.out.println(smartPhone.getPhoneNumber()+"�� ��ȭ�ð���"
				+smartPhone.getTotalCallTime()+"�̸� \n"+"�ܰ�"+smartPhone.getFeePerCallTime()+
				"�ѿ����"+smartPhone.getTotalFee()+"�� �Դϴ�.");
		System.out.println("=================================");
		
		SmartPhone smartPhone01 = new SmartPhone("111-111-111",0,true,3000);
		smartPhone01.call("017-017-017",10);
		smartPhone01.call("016-016-016",10);
		smartPhone01.calculationTotalFee();
		System.out.println(smartPhone01.getPhoneNumber()+"�� ��ȭ�ð���"
				+smartPhone01.getTotalCallTime()+"�̸� \n"+"�ܰ�"+smartPhone01.getFeePerCallTime()+
				"�ѿ����"+smartPhone01.getTotalFee()+"�� �Դϴ�.");
		System.out.println("=================================");
		

	}

}