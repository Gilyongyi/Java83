package jw04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserInitParamDao {
	private String jdbcDriver;
	private String jdbcURL;
	private String jdbcUser;
	private String jdbcPasswd;
	
	public UserInitParamDao(){
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}
	public void setJdbcURL(String jdbcURL) {
		this.jdbcURL = jdbcURL;
	}
	public void setJdbcUser(String jdbcUser) {
		this.jdbcUser = jdbcUser;
	}
	public void setJdbcPasswd(String jdbcPasswd) {
		this.jdbcPasswd = jdbcPasswd;
	}
	public void getUser(UserVO userVO){
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try{
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(jdbcURL,jdbcUser,jdbcPasswd);
			
			pstmt=con.prepareStatement("SELECT id,pwd FROM users "+
									"WHERE id=? AND pwd=?");
			pstmt.setString(1,userVO.getId());
			pstmt.setString(2,userVO.getPwd());
			
			rs= pstmt.executeQuery();
			
			if(rs.next()){
				System.out.println("db 에서 확인한 id pwd"+userVO.getId()+" : "+userVO.getPwd());
				userVO.setActive(true);
			}else{
				System.out.println("db에 client에 입력한 <"+userVO.getId()+">의 자료가 없습니다.");
			}

		}catch(Exception e){
			e.printStackTrace();
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
