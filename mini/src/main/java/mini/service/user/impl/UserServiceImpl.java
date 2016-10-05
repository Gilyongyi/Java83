package mini.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mini.common.Search;
import mini.service.domain.User;
import mini.service.user.UserDao;
import mini.service.user.UserService;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	
	@Autowired
	@Qualifier("userDaoImpl")
	UserDao userDao;
	
	public void setUserDao(UserDao userDao){
		System.out.println("::"+getClass()+".setUserDao Call....");
		this.userDao = userDao;
	}

	///Method
	public int addUser(User user) throws Exception {
		return userDao.insertUser(user);
		/*System.out.println("1번째 insert:::::::::::::::::::::");
		result = userDao.insertUser(user);
		System.out.println("1번째 insert 결과:::::::::::::::::");
		System.out.println("2번째 insert:::::::::::::::::::::");
		result = userDao.insertUser(user);
		System.out.println("2번째 insert 결과:::::::::::::::::");
		System.out.println("::::::결과는???::::::::::::::::::");
		return 0;*/
	}

	public User getUser(String userId) throws Exception {
		return userDao.findUser(userId);
	}

	public int updateUser(User user) throws Exception {
		return userDao.updateUser(user);
	}
	
	public List<User> getUserList(Search search) throws Exception {
		return userDao.getUserList(search);
	}
	
	/*public int addUser2(User user) throws Exception {
		int result =0;
		System.out.println("1번째 insert:::::::::::::::::::::");
		result = userDao.insertUser(user);
		System.out.println("1번째 insert 결과:::::::::::::::::");
		System.out.println("2번째 insert:::::::::::::::::::::");
		result = userDao.insertUser(user);
		System.out.println("2번째 insert 결과:::::::::::::::::");
		System.out.println("::::::결과는???::::::::::::::::::");
		return 0;
	}*/
	/*public User loginUser(User user) throws Exception {
	User dbUser=userDao.findUser(user.getUserId());

	if(! dbUser.getPassword().equals(user.getPassword())){
		throw new Exception("로그인에 실패했습니다.");
	}
	
	return dbUser;
	}*/
	
	/*public boolean checkDuplication(String userId) throws Exception {
		boolean result=true;
		User user=userDao.findUser(userId);
		if(user != null) {
			result=false;
		}
		return result;
	}*/
}