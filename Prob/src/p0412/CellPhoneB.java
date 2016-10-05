package p0412;



public class CellPhoneB {
	private String model;
	private double battery;
	private int time;
	
	public CellPhoneB() {
		super();
	}

	public CellPhoneB(String model) {
		// TODO Auto-generated constructor stub
		this.model=model;
	}

	public CellPhoneB(String model, int battery) {
		super();
		this.model = model;
		this.battery = battery;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getBattery() {
		return battery;
	}

	public void setBattery(double battery) {
		this.battery = battery;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void charge(int time) {
		// TODO Auto-generated method stub
		System.out.println("�����ð� : "+time);
		battery += time*3;

	}

	public void call(int time) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		battery -= time*0.5;
		
		if(time<=0){
			throw new IllegalArgumentException("��ȭ�ð�����");
		}else{
			System.out.println("��ȭ�ð� : "+time);
		}
	}

	public void printBattery() {
		// TODO Auto-generated method stub
		if(battery>100){
			battery=100;
			System.out.println("���� ���͸��� : "+battery);
		}else if(battery<0){
			battery=0;
			System.out.println("���� ���͸��� : "+battery);
		}else
		System.out.println("���� ���͸��� : "+battery);
		
	}
	
	public boolean equals(Object otherObject){
		if(this.model==((CellPhoneB)otherObject).model){
			return true;
		}else{
			return false;
		}
	}
}
	
	

