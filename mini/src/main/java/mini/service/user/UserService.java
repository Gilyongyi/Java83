package mini.service.user;

import java.util.List;

import mini.common.Search;
import mini.service.domain.User;

public interface UserService {
	
	public int addUser(User user) throws Exception;
	
	//public User loginUser(User user) throws Exception;
	
	public User getUser(String userId) throws Exception;
	
	public List<User> getUserList(Search search) throws Exception;
	
	public int updateUser(User user) throws Exception;
	
	//public int addUser2(User user) throws Exception;
	
	//public boolean checkDuplication(String userId) throws Exception;
	
}