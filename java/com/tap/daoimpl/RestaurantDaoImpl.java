package com.tap.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.tap.Dao.RestaurantDao;
import com.tap.model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao {
   
    final static String INSERT_QUERY = "INSERT INTO `restaurant` (`rname`, `cusineType`, `ratings`, `address`, `isActive`, `image`) VALUES (?, ?, ?, ?, ?, ?)";
    final static String FETCH_ALL_QUERY = "SELECT * FROM `restaurant`";
    final static String SELECT_QUERY = "SELECT * FROM `restaurant` WHERE `rid` = ?";
    final static String UPDATE_QUERY = "UPDATE `restaurant` SET `rname` = ?, `cusineType` = ?, `ratings` = ?, `address` = ?, `isActive` = ?, `image` = ? WHERE `rid` = ?";
    final static String DELETE_QUERY = "DELETE FROM `restaurant` WHERE `rid` = ?";

    static Connection connection;

    public RestaurantDaoImpl() {
        String url = "jdbc:mysql://localhost:3306/foodie";
        String username = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Restaurant restaurant) {
        PreparedStatement prepareStatement = null;

        try {
            prepareStatement = connection.prepareStatement(INSERT_QUERY);
            prepareStatement.setString(1, restaurant.getRname());
            prepareStatement.setString(2, restaurant.getCusineType());
            prepareStatement.setDouble(3, restaurant.getRatings());
            prepareStatement.setString(4, restaurant.getAddress());
            prepareStatement.setString(5, restaurant.getIsActive());
            prepareStatement.setString(6, restaurant.getImage()); 

            int n = prepareStatement.executeUpdate();
            if (n != 0) {
                System.out.println("Insert success");
            } else {
                System.out.println("Insert failure");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Restaurant> fetchAll() {
        Statement statement = null;
        ResultSet res = null;
        List<Restaurant> restaurantList = new ArrayList<>();

        try {
            statement = connection.createStatement();
            res = statement.executeQuery(FETCH_ALL_QUERY);

            while (res.next()) {
                int rid = res.getInt("rid");
                String rname = res.getString("rname");
                String cuisineType = res.getString("cusineType");
                double ratings = res.getDouble("ratings");
                String address = res.getString("address");
                String isActive = res.getString("isActive");
                String image = res.getString("image"); 

                Restaurant restaurant = new Restaurant(rid, rname, cuisineType, ratings, address, isActive, image);
                restaurantList.add(restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurantList;
    }

    @Override
    public Restaurant fetchSpecific(int rid) {
        PreparedStatement prepareStatement = null;
        ResultSet res = null;
        Restaurant restaurant = null;

        try {
            prepareStatement = connection.prepareStatement(SELECT_QUERY);
            prepareStatement.setInt(1, rid);
            res = prepareStatement.executeQuery();

            if (res.next()) {
                String rname = res.getString("rname");
                String cuisineType = res.getString("cusineType");
                double ratings = res.getDouble("ratings");
                String address = res.getString("address");
                String isActive = res.getString("isActive");
                String image = res.getString("image"); 

                restaurant = new Restaurant(rname, cuisineType, ratings, address, isActive, image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public int updateRestaurant(Restaurant restaurant) {
        PreparedStatement prepareStatement = null;
        int n = 0;

        try {
            prepareStatement = connection.prepareStatement(UPDATE_QUERY);
            prepareStatement.setString(1, restaurant.getRname());
            prepareStatement.setString(2, restaurant.getCusineType());
            prepareStatement.setDouble(3, restaurant.getRatings());
            prepareStatement.setString(4, restaurant.getAddress());
            prepareStatement.setString(5, restaurant.getIsActive());
            prepareStatement.setString(6, restaurant.getImage());
            prepareStatement.setInt(7, restaurant.getRid());

            n = prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int deleteRestaurant(int rid) {
        PreparedStatement prepareStatement = null;
        int n = 0;

        try {
            prepareStatement = connection.prepareStatement(DELETE_QUERY);
            prepareStatement.setInt(1, rid);
            n = prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
}
