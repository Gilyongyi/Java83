package p0418;

import java.util.List;

public class Prob1 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String pathName = "./src/data.txt";
		
		FileUtil.fileToPrint(pathName);
	
		System.out.println("==========================");
		System.out.println("ȭ�� ������ ���� ���� �˻�");
		List<User> vector = FileUtil.fileFindAddres(pathName, "����");
		/*for(int i=0;i<vector.size();i++){
			System.out.println("�̸� : "+vector.get(i).getName()+", "+
								"�ڵ��� : "+vector.get(i).getPhone()+", "+
								"���� : "+vector.get(i).getMf()+", "+
								"�ּ� : "+vector.get(i).getAddres());*/
		for(User e : vector){
			System.out.println("�̸� : "+e.getName()+", �ڵ��� : "+e.getPhone()+
								", ���� : "+e.getMf()+", �ּ� : "+e.getAddres());
			}
		
		
		System.out.println("==========================");
		System.out.println("ȭ�� ������ ���� ���� �˻�");
		vector = FileUtil.fileFindAddres(pathName, "����");
		for(User e : vector){
			System.out.println("�̸� : "+e.getName()+", �ڵ��� : "+e.getPhone()+
								", ���� : "+e.getMf()+", �ּ� : "+e.getAddres());
			}
		
		System.out.println("==========================");
		System.out.println("ȭ�� ������ ��⵵ ���� �˻�");
		vector = FileUtil.fileFindAddres("./src/data.txt", "��⵵");
		for(User e : vector){
			System.out.println("�̸� : "+e.getName()+", �ڵ��� : "+e.getPhone()+
								", ���� : "+e.getMf()+", �ּ� : "+e.getAddres());
			}
	}

}
