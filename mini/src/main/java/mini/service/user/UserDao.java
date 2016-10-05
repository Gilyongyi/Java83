package mini.service.user;

import java.util.List;

import mini.common.Search;
import mini.service.domain.User;

public interface UserDao {
	
	public int insertUser(User user) throws Exception;

	public User findUser(String userId) throws Exception;

	public List<User> getUserList(Search search) throws Exception;

	public int updateUser(User vo) throws Exception;
	
	//public int insertUser2(User user) throws Exception;
	
	//public int getTotalCount(String sql) throws Exception ;	
	
	//String makeCurrentPageSql(String sql , Search search) throws Exception;
}