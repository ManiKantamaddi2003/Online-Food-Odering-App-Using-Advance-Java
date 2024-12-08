package com.tap.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.OrderItemDao;
import com.tap.model.OrderItems;

public class OrderItemDaoImpl implements OrderItemDao {
    
    private static Connection connection;

  
    final static String INSERT_QUERY = "INSERT INTO `orderitem` (`orderid`, `menuid`, `quantity`, `total_item`) VALUES (?, ?, ?, ?)";
    final static String FETCH_ALL_QUERY = "SELECT * FROM `orderitem`";
    final static String SELECT_QUERY = "SELECT * FROM `orderitem` WHERE `orderitemid` = ?";
    final static String UPDATE_QUERY = "UPDATE `orderitem` SET `orderid` = ?, `menuid` = ?, `quantity` = ?, `total_item` = ? WHERE `orderitemid` = ?";
    final static String DELETE_QUERY = "DELETE FROM `orderitem` WHERE `orderitemid` = ?";

   
    public OrderItemDaoImpl() {
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
    public int insert(OrderItems orderItem) {
    	int n=0;
        try 
        {
        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, orderItem.getOrderid());
            preparedStatement.setInt(2, orderItem.getMenuid());
            preparedStatement.setInt(3, orderItem.getQuantity());
            preparedStatement.setDouble(4, orderItem.getTotal_item());
            n= preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<OrderItems> fetchAll() {
        List<OrderItems> orderItemsList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FETCH_ALL_QUERY)) {
            while (resultSet.next()) {
                int orderItemId = resultSet.getInt("orderitemid");
                int orderId = resultSet.getInt("orderid");
                int menuId = resultSet.getInt("menuid");
                int quantity = resultSet.getInt("quantity");
                double totalItem = resultSet.getDouble("total_item");

                OrderItems orderItem = new OrderItems(orderItemId, orderId, menuId, quantity, totalItem);
                orderItemsList.add(orderItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItemsList;
    }

    @Override
    public OrderItems fetchSpecific(int orderItemId) {
        OrderItems orderItem = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setInt(1, orderItemId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int orderId = resultSet.getInt("orderid");
                    int menuId = resultSet.getInt("menuid");
                    int quantity = resultSet.getInt("quantity");
                    double totalItem = resultSet.getDouble("total_item");

                    orderItem = new OrderItems(orderItemId, orderId, menuId, quantity, totalItem);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItem;
    }

    @Override
    public int updateOrderItem(OrderItems orderItem) {
        int rowsAffected = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setInt(1, orderItem.getOrderid());
            preparedStatement.setInt(2, orderItem.getMenuid());
            preparedStatement.setInt(3, orderItem.getQuantity());
            preparedStatement.setDouble(4, orderItem.getTotal_item());
            preparedStatement.setInt(5, orderItem.getOrderid());

            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    @Override
    public int deleteOrderItem(int orderItemId) {
        int rowsAffected = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.setInt(1, orderItemId);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }
}
