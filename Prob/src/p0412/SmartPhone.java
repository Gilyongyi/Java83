package p0412;

public class SmartPhone extends CellPhone {
	private boolean isMonthlyFixedRate;
	private int monthlyFixedFee;
	
	public SmartPhone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SmartPhone(String phoneNumber, int feePerCallTime) {
		super(phoneNumber, feePerCallTime);
		// TODO Auto-generated constructor stub
	}


	public SmartPhone(String phoneNumber, int feePerCallTime, boolean isMonthlyFixedRate, int monthlyFixedFee) {
		// TODO Auto-generated constructor stub
		super(phoneNumber, feePerCallTime);
		this.isMonthlyFixedRate = isMonthlyFixedRate;
		this.monthlyFixedFee = monthlyFixedFee;
	}
	public boolean isMonthlyFixedRate() {
		return isMonthlyFixedRate;
	}
	public void setMonthlyFixedRate(boolean isMonthlyFixedRate) {
		this.isMonthlyFixedRate = isMonthlyFixedRate;
	}
	public int getMonthlyFixedFee() {
		return monthlyFixedFee;
	}
	public void setMonthlyFixedFee(int monthlyFixedFee) {
		this.monthlyFixedFee = monthlyFixedFee;
	}
	
	
	public void call(String phoneNumber, int totalCallTime){
		super.call(phoneNumber, totalCallTime);
	}
	
	public void calculationTotalFee(){
		super.calculationTotalFee();
		if(isMonthlyFixedRate==true){
		System.out.println("고객님은"+monthlyFixedFee+"정액 요금제 입니다");
		setTotalFee(getTotalFee() + monthlyFixedFee);
		}
	}
}
