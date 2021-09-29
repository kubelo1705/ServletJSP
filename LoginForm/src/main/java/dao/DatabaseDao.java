package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Mapper.IMapper;
import constants.Constant;

public class DatabaseDao<T> {
	public Connection getConnection() throws ClassNotFoundException {
		try {
			String url = Constant.DB_URL;
			String user = Constant.USER;
			String password = Constant.PASS;
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}
	@SuppressWarnings("hiding")
	public <T> java.util.List<T> query(String sql, IMapper<T> iMapper,Object... parameters) {
		List<T> resultsList=new ArrayList<T>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=getConnection();
			preparedStatement=connection.prepareStatement(sql);
			setParameters(preparedStatement, parameters);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				resultsList.add(iMapper.mapRow(resultSet));
			}
			return resultsList;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	private void setParameters(PreparedStatement preparedStatement,Object...parameters) {
		try {
			for(int i=0;i<parameters.length;i++) {
				if(parameters[i] instanceof String) {
					preparedStatement.setString(i+1, (String) parameters[i]);
				}else if(parameters[i] instanceof Integer) {
					preparedStatement.setInt(i+1, (int) parameters[i]);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

}
