package p0414;

import java.io.File;

public class Dir {
	private void printDir(String str){
		String[] flist=new File(str).list(); 
		if(new File(str).isDirectory()){
			for (int i=0; i<flist.length ;i++){ 
				printDir(str+"/"+flist[i]);
			}
			System.out.println(str);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Dir().printDir("test_dir");
		System.out.println("출력이 완료되었습니다.");
	}

}
