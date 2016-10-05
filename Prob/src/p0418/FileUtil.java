package p0418;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Vector;

class User{
	String name;
	String phone;
	String mf;
	String addres;
	
	public User(String name, String phone, String mf, String addres) {
		super();
		this.name = name;
		this.phone = phone;
		this.mf = mf;
		this.addres = addres;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMf() {
		return mf;
	}

	public void setMf(String mf) {
		this.mf = mf;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}
	
	
}
public class FileUtil {
	
	
	public static void fileToPrint(String fileName)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String source="";
		while((source=br.readLine())!=null){
			System.out.println(source);
		}
		br.close();
	}
	
	public static List fileFindAddres(String fileName,String address)throws Exception{
		List v= new Vector();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String str="";
		while((str = br.readLine())!=null){
			String[] arr = str.split("/");
			String name=arr[0];
			String phone=arr[2];
			String mf=arr[3];
			String addres=arr[1];
			
			if(address.equals(addres)){
				User user = new User(name,phone,mf,addres);
				v.add(user);
			}
		}
		br.close();
		return v;
		}
	}
