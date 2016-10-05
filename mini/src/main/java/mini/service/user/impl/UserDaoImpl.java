package mini.service.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mini.common.Search;
import mini.service.domain.User;
import mini.service.user.UserDao;


@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession){
		System.out.println("::"+getClass()+".setSqlSession() Call.....");
		this.sqlSession = sqlSession;
	}
	
	public UserDaoImpl(){
		System.out.println("::"+getClass()+" default Constructor Call....");
	}
	
	public int insertUser(User user) throws Exception {
		return sqlSession.insert("UserMapper.addUser",user);
	}

	public User findUser(String userId) throws Exception {
		return sqlSession.selectOne("UserMapper.getUser",userId);
	}
	
	public int updateUser(User vo) throws Exception{
		return sqlSession.update("UserMapper.updateUser",vo);
	}

	public List<User> getUserList(Search search) throws Exception {
		return sqlSession.selectList("UserMapper.getUserList",search);
	}
	
	/*public int insertUser2(User user) throws Exception{
		return sqlSession.insert("UserMapper.addUser2",user);
	}
*/
	/*
	// 게시판 Page 처리를 위한 전체 Row(totalCount)  return
	private int getTotalCount(String sql) throws Exception {
		
		sql = "SELECT COUNT(*) "+
		          "FROM ( " +sql+ ") countTable";
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pStmt = con.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();
		
		int totalCount = 0;
		if( rs.next() ){
			totalCount = rs.getInt(1);
		}
		
		pStmt.close();
		con.close();
		rs.close();
		
		return totalCount;
	}
	
	// 게시판 currentPage Row 만  return 
	private String makeCurrentPageSql(String sql , Search search){
		sql = 	"SELECT * "+ 
					"FROM (		SELECT inner_table. * ,  ROWNUM AS row_seq " +
									" 	FROM (	"+sql+" ) inner_table "+
									"	WHERE ROWNUM <="+search.getCurrentPage()*search.getPageSize()+" ) " +
					"WHERE row_seq BETWEEN "+((search.getCurrentPage()-1)*search.getPageSize()+1) +" AND "+search.getCurrentPage()*search.getPageSize();
		
		System.out.println("UserDAO :: make SQL :: "+ sql);	
		
		return sql;
	}*/
}