package com.tap.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.tap.model.OrderHistory;

public class OrderhistoryDaoImpl {
  
    final static String INSERT_QUERY = "INSERT INTO `orderhistory` (`orderid`, `rid`, `uid`, `total`, `status`) VALUES (?, ?, ?, ?, ?)";
    final static String FETCH_QUERY = "SELECT * FROM `orderhistory` WHERE `oh_id` = ?";
    final static String UPDATE_QUERY = "UPDATE `orderhistory` SET `status` = ? WHERE `oh_id` = ?";
    final static String DELETE_QUERY = "DELETE FROM `orderhistory` WHERE `oh_id` = ?";
    final static String FETCH_ALL_QUERY = "SELECT * FROM `orderhistory`";

    static Connection connection;

    public OrderhistoryDaoImpl() {
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

    public int insert(OrderHistory orderHistory) {
    	int n=0;
        try
        {

        PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setInt(1, orderHistory.getOrderid());
            statement.setInt(2, orderHistory.getRid());
            statement.setInt(3, orderHistory.getUid());
            statement.setDouble(4, orderHistory.getTotal());
            statement.setString(5, orderHistory.getStatus());

            n= statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    
    public OrderHistory fetch(int orderid) {
        try (PreparedStatement statement = connection.prepareStatement(FETCH_QUERY)) {
            statement.setInt(1, orderid);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int oh_id = resultSet.getInt("oh_id");
                int rid = resultSet.getInt("rid");
                int uid = resultSet.getInt("uid");
                double total = resultSet.getDouble("total");
                String status = resultSet.getString("status");

                return new OrderHistory(oh_id, orderid, rid, uid, total, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

  
    public List<OrderHistory> fetchAll() {
        List<OrderHistory> orderHistoryList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FETCH_ALL_QUERY)) {

            while (resultSet.next()) {
                int oh_id = resultSet.getInt("oh_id");
                int orderid = resultSet.getInt("orderid");
                int rid = resultSet.getInt("rid");
                int uid = resultSet.getInt("uid");
                double total = resultSet.getDouble("total");
                String status = resultSet.getString("status");

                orderHistoryList.add(new OrderHistory(oh_id, orderid, rid, uid, total, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistoryList;
    }

    public int updateStatus(int oh_id, String status) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, status);
            statement.setInt(2, oh_id);
            return statement.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

   
    public int delete(int oh_id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, oh_id);
            return statement.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
