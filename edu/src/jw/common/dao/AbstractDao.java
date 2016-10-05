package jw.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jw.common.util.DBUtil;

public abstract class AbstractDao {

	public AbstractDao(){
		
	}
	
	public Connection connect(){
		Connection con = null;
		try{
			con=DBUtil.getConnection();
		}catch(RuntimeException ex){
			throw ex;
		}
		return con;
	}
	
	public void close(Connection con,PreparedStatement pstmt, ResultSet rs){
		if(rs!=null){
			try{
				rs.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		this.close(con, pstmt);
	}
	
	public void close(Connection con,PreparedStatement pstmt){
		if(pstmt!=null){
			try{
				pstmt.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		if(con!=null){
			try{
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
}
