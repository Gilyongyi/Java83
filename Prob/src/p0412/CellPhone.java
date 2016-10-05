package p0412;

public class CellPhone {
	private String phoneNumber;
	private int totalCallTime;
	private int totalFee;
	private int feePerCallTime;
	
	public CellPhone() {
		super();
	}

	public CellPhone(String phoneNumber, int feePerCallTime) {
		super();
		this.phoneNumber = phoneNumber;
		this.feePerCallTime = feePerCallTime;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getTotalCallTime() {
		return totalCallTime;
	}

	public void setTotalCallTime(int totalCallTime) {
		this.totalCallTime = totalCallTime;
	}

	public int getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public int getFeePerCallTime() {
		return feePerCallTime;
	}

	public void setFeePerCallTime(int feePerCallTime) {
		this.feePerCallTime = feePerCallTime;
	}
	
	public void call(String phoneNumber, int callTime){
		System.out.println(phoneNumber+"의 번호로 "+callTime+" 통화함");
		totalCallTime+=callTime;
	}
	
	public void calculationTotalFee(){
		totalFee = feePerCallTime * totalCallTime;
		
	}

		
	
}
