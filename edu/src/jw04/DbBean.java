package jw04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbBean {
	private String dburl="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String dbuser="scott";
	private String dbpwd="tiger";
	private String id;
	private String pwd;
	
	public DbBean(){
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public boolean getUser(){
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl,dbuser,dbpwd);
			
			pstmt=con.prepareStatement("SELECT id,pwd FROM users "+
														"WHERE id=?");
			pstmt.setString(1,id);
			
			rs= pstmt.executeQuery();
			String str=null;
			
			if(rs.next()){
				str = rs.getString("pwd");
				System.out.println("db 에서 확인한 id pwd"+id+" : "+pwd);
			}else{
				System.out.println("db에 client에 입력한 <"+id+">의 자료가 없습니다.");
			}
				
				
		if(str!=null && str.equals(pwd)){
			return true;
		}else{
			return false;
		}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			if(rs !=null){
				try{
					rs.close();
					}catch(Exception e1){}
				}
			if(pstmt !=null){
				try{
					pstmt.close();
				}catch(Exception e2){}
			}
			if(con !=null){
				try{
					con.close();
				}catch(Exception e3){}
			}
		}
	}
}
