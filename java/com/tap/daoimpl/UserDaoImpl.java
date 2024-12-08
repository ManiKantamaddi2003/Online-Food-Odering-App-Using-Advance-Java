package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.UserDao;
import com.tap.Security.Decrypt;
import com.tap.model.User;

public class UserDaoImpl implements UserDao
{
  final static String INSERT_QUERY = "INSERT into `user` (`username` , `email`, `password`,`mobile`) values (?,?,?,?)";
  final static String FETCH_ALL_QUERY = "SELECT * from `user`";
  final static String SELECT_QUERY = "SELECT * from `user` WHERE `uid` = ?";
  final static String UPDATE_QUERY = "UPDATE `user` SET `username` = ? ,`email` = ? ,`password` = ? , `mobile` = ? WHERE`uid` = ?";
  final static String DELETE_QUERY = "DELETE from `user` WHERE `uid` = ?";
  final static String SELECT_BY_EMAIL= "SELECT * from `user` WHERE `email` = ?";
		static Connection connection;
		public UserDaoImpl() {
			String url = "jdbc:mysql://localhost:3306/foodie";
			String username = "root";
			String password = "1234";

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, username, password);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		@Override
		public int insert(User user) {
			PreparedStatement prepareStatement = null;
            int n=0;
			try {
				prepareStatement = connection.prepareStatement(INSERT_QUERY);
				prepareStatement.setString(1, user.getUsername());
				prepareStatement.setString(2, user.getEmail());
				prepareStatement.setString(3, user.getPassword());
				prepareStatement.setString (4,user.getMobile());
			    n=prepareStatement.executeUpdate();
		   }
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return n;	
	}
		@Override
		public List<User> fetchAll() {

			Statement statement = null;

			ResultSet res = null;

			ArrayList<User> userList = new ArrayList<User>();
			try {
				statement = connection.createStatement();
				res = statement.executeQuery(FETCH_ALL_QUERY);

				while (res.next()) {
					int userId = res.getInt("uid");
					String name = res.getString("username");
					String email =res.getString("email");
					String password =Decrypt.decrypt( res.getString("password"));
					String mobile = res.getString("mobile");
					User user = new User(userId,name,email,password,mobile);
					userList.add(user);
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return userList;
		}
		@Override
		public User fetchSpecific(int uid) {

			PreparedStatement prepareStatement = null;
			ResultSet res = null;
			User user = null;
			try {
				prepareStatement = connection.prepareStatement(SELECT_QUERY);

				prepareStatement.setInt(1, uid);
				res = prepareStatement.executeQuery();

				if (res.next()) {
					String name = res.getString("username");
					String email = res.getString("email");
					String password =Decrypt.decrypt( res.getString("password"));
					String address = res.getString("mobile");
					user = new User( name, email, password, address);
				}

			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return user;
		}
		@Override
		public int updateUser(User user)
		{
			PreparedStatement prepareStatement = null;
             int n=0;
			try {
				prepareStatement = connection.prepareStatement(UPDATE_QUERY);
				prepareStatement.setString(1, user.getUsername());
				prepareStatement.setString(2, user.getEmail());
				prepareStatement.setString(3, user.getPassword());
				prepareStatement.setString(4, user.getMobile());	
				prepareStatement.setInt(5, user.getUid());

				 n=prepareStatement.executeUpdate();

			} catch (SQLException e) 
			{

				e.printStackTrace();
			}
			return n;
		}
		@Override
		public int deleteUser(int uid) 
		{
			int n=0;
			PreparedStatement prepareStatement = null;
			try {
				prepareStatement = connection.prepareStatement(DELETE_QUERY);
				prepareStatement.setInt(1, uid);
				 n=prepareStatement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n;
		}
		public User isValidate(String email) {
		    User user = null;
		    try (PreparedStatement stmt = connection.prepareStatement(SELECT_BY_EMAIL)) {
		        stmt.setString(1, email);
		        ResultSet rs = stmt.executeQuery();
		        
		        if (rs.next()) {
		     
		            int id = rs.getInt("uid");
		            String name = rs.getString("username");
		            String password =Decrypt.decrypt(rs.getString("password"));
		            String mobile = rs.getString("mobile");
		            user = new User(id, name, email, password, mobile);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		    return user; 
		}
}