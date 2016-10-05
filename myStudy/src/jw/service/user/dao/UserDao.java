package jw.service.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jw.common.dao.AbstractDao;
import jw.service.user.vo.UserVO;

public class UserDao extends AbstractDao{
	
	public UserDao(){
	}
	
	public UserVO findUser(String name){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		UserVO userVO = new UserVO();
		try{
				con = this.connect();
				pstmt = con.prepareStatement("SELECT * FROM userinfo WHERE name=?");
				pstmt.setString(1,name);
				rs = pstmt.executeQuery();
				
				while(rs.next()){
				
						String name1=rs.getString("name");
						String gender=rs.getString("gender");
						String birth=rs.getString("birth");
						String solar=rs.getString("solar");
						String academic=rs.getString("academic");
						String job=rs.getString("job");
						String dept=rs.getString("dept");
						String marital=rs.getString("marital");
						String children=rs.getString("children");
						String phone=rs.getString("phone");
						String wherenum=rs.getString("wherenum");
						String phonenumber=rs.getString("phonenumber");
						String telecom=rs.getString("telecom");
						String address=rs.getString("address");
					
					userVO.setName(name1);
					userVO.setGender(gender);
					userVO.setBirth(birth);
					userVO.setSolar(solar);
					userVO.setAcademic(academic);
					userVO.setJob(job);
					userVO.setDept(dept);
					userVO.setMarital(marital);
					userVO.setChildren(children);
					userVO.setPhone(phone);
					userVO.setWherenum(wherenum);
					userVO.setPhonenumber(phonenumber);
					userVO.setTelecom(telecom);
					userVO.setAddress(address);
					
					
					
					
								
				}
				//System.out.println("userDao"+userVO);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(con,pstmt,rs);
			}
		System.out.println(userVO);
		return userVO;
	}
	public void addUser(UserVO userVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
	
		try{
			con = this.connect();
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
				this.close(con,pstmt,rs);
		}
	}
	public void updateUser(UserVO userVO){
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try{
			con = this.connect();
			pstmt = con.prepareStatement("UPDATE userinfo "+
										"SET name=?,gender=?,birth=?,solar=?,academic=?, "+
										"job=?,dept=?,marital=?,children=?,phone=?, "+
										"wherenum=?,phonenumber=?,telecom=?,address=? "+
										"WHERE name=?");
			
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
			pstmt.setString(15,userVO.getName());
			pstmt.executeUpdate();
		
		
		}
			catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(con,pstmt);
		}
	}
	
	
}