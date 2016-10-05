package p0418;

import java.util.List;

public class Prob1 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String pathName = "./src/data.txt";
		
		FileUtil.fileToPrint(pathName);
	
		System.out.println("==========================");
		System.out.println("화일 내용중 서울 정보 검색");
		List<User> vector = FileUtil.fileFindAddres(pathName, "서울");
		/*for(int i=0;i<vector.size();i++){
			System.out.println("이름 : "+vector.get(i).getName()+", "+
								"핸드폰 : "+vector.get(i).getPhone()+", "+
								"성별 : "+vector.get(i).getMf()+", "+
								"주소 : "+vector.get(i).getAddres());*/
		for(User e : vector){
			System.out.println("이름 : "+e.getName()+", 핸드폰 : "+e.getPhone()+
								", 성별 : "+e.getMf()+", 주소 : "+e.getAddres());
			}
		
		
		System.out.println("==========================");
		System.out.println("화일 내용중 경주 정보 검색");
		vector = FileUtil.fileFindAddres(pathName, "경주");
		for(User e : vector){
			System.out.println("이름 : "+e.getName()+", 핸드폰 : "+e.getPhone()+
								", 성별 : "+e.getMf()+", 주소 : "+e.getAddres());
			}
		
		System.out.println("==========================");
		System.out.println("화일 내용중 경기도 정보 검색");
		vector = FileUtil.fileFindAddres("./src/data.txt", "경기도");
		for(User e : vector){
			System.out.println("이름 : "+e.getName()+", 핸드폰 : "+e.getPhone()+
								", 성별 : "+e.getMf()+", 주소 : "+e.getAddres());
			}
	}

}
