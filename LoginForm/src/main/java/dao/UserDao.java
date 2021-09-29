package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import Mapper.IMapper;
import models.User;

public class UserDao extends DatabaseDao<User> {

	public User findUserByUsernameAndPassword(String username, String password) {
		StringBuilder stringBuilder = new StringBuilder("SELECT * FROM account WHERE username=? and password=?");
		java.util.List<User> usersList = query(stringBuilder.toString(), new IMapper<User>() {
			@Override
			public User mapRow(ResultSet rs) {
				try {
					User user = new User();
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setRole(rs.getInt("role"));
					return user;
				} catch (SQLException e) {
					// TODO: handle exception
				}
				return null;
			}
		}, username, password);
		return usersList==null?null:usersList.get(0);
	}

}
