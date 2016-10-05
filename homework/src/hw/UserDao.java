package hw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDao {
	
	public UserDao(){
	}
	
	public void addUser(UserVO userVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
	
		try{
			//con = OracleConnectionPool.getInstance().getConnection();
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:comp/env/edu/jdbc/ora");
			
			con=ds.getConnection();
			pstmt = con.prepareStatement("INSERT INTO userinfo("+
										"name,gender,birth,solar,academic, "+
										"job,dept,marital,children,phone, "+
										"wherenum,phonenumber,telecom,address) "+
										"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setString(1,userVO.getName());
			pstmt.setString(2,userVO.getGender());
			pstmt.setString(3,userVO.getBirth());
			pstmt.setString(4,userVO.getSolar());
			pstmt.setString(5,userVO.getAcademic());
			pstmt.setString(6,userVO.getJob());
			pstmt.setString(7,userVO.getDept());
			pstmt.setString(8,userVO.getMarital());
			pstmt.setString(9,userVO.getChildren());
			pstmt.setString(10,userVO.getPhone());
			pstmt.setString(11,userVO.getWherenum());
			pstmt.setString(12,userVO.getPhonenumber());
			pstmt.setString(13,userVO.getTelecom());
			pstmt.setString(14,userVO.getAddress());
			
			pstmt.executeUpdate();
			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
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