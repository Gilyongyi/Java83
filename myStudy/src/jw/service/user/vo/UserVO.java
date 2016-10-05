package jw.service.user.vo;

public class UserVO {
	private	String name;
	private	String gender;
	private String birth;
	private	String solar;
	private	String academic;
	private	String job;
	private	String dept;
	private	String marital;
	private	String children;
	private	String phone;
	private	String wherenum;
	private	String phonenumber;
	private	String telecom;
	private	String address;
	private boolean active;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getSolar() {
		return solar;
	}
	public void setSolar(String solar) {
		this.solar = solar;
	}
	public String getAcademic() {
		return academic;
	}
	public void setAcademic(String academic) {
		this.academic = academic;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getMarital() {
		return marital;
	}
	public void setMarital(String marital) {
		this.marital = marital;
	}
	public String getChildren() {
		return children;
	}
	public void setChildren(String children) {
		this.children = children;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWherenum() {
		return wherenum;
	}
	public void setWherenum(String wherenum) {
		this.wherenum = wherenum;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getTelecom() {
		return telecom;
	}
	public void setTelecom(String telecom) {
		this.telecom = telecom;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String toString(){
		return "name="+name+"</br> gender="+gender+"</br> birth="+birth+
				"</br> solar="+solar+"</br> academic="+academic+"</br> job="+job+
				"</br> dept="+dept+"</br> marital="+marital+"</br> children="+children+
				"</br> phone="+phone+"</br> wherenum"+wherenum+"</br> phonenumber="+
				phonenumber+"</br> telecom="+telecom+"</br> address="+address+"</br> active="+
				active;
	}
	
}
