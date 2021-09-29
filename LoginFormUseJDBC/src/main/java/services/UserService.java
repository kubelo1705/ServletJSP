package services;
import dao.*;
import models.User;
public class UserService {

	private UserDao userDao;

	public UserService() {
		userDao = new UserDao();
	}
	
	public User findUserByUsernameAndPassword(String userName, String password) {
		return userDao.findUserByUsernameAndPassword(userName, password);
	}
	
}