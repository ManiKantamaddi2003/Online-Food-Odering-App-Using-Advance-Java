package com.tap.daoimpl;
import com.tap.Dao.OrderDao;
import com.tap.model.Orders;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class OrderDaoImpl implements OrderDao {
	    
	    
	    final static String INSERT_QUERY = "INSERT INTO `orders` (`orderid`,`uid`, `rid`, `menuid`, `quantity`, `total`, `payment_method`, `status`) VALUES (?,?, ?, ?, ?, ?, ?, ?)";
	    final static String FETCH_ALL_QUERY = "SELECT * FROM `orders`";
	    final static String SELECT_QUERY = "SELECT * FROM `orders` WHERE `orderid` = ?";
	    final static String UPDATE_QUERY = "UPDATE `orders` SET `uid` = ?, `rid` = ?, `menuid` = ?, `quantity` = ?, `total` = ?, `payment_method` = ?, `status` = ? WHERE `orderid` = ?";
	    final static String DELETE_QUERY = "DELETE FROM `orders` WHERE `orderid` = ?";

	    static Connection connection;

	    public OrderDaoImpl() {
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
	    public int insert(Orders order) {
	    	int n=0;
	        try (PreparedStatement prepareStatement = connection.prepareStatement(INSERT_QUERY)) {
	        	prepareStatement.setInt(1, order.getOrderid());
	            prepareStatement.setInt(2, order.getUid());
	            prepareStatement.setInt(3, order.getRid());
	            prepareStatement.setInt(4, order.getMenuid());
	            prepareStatement.setInt(5, order.getQuantity());
	            prepareStatement.setDouble(6, order.getTotal());
	            prepareStatement.setString(7, order.getPayment_method());
	            prepareStatement.setString(8, order.getStatus());
	            
	             n = prepareStatement.executeUpdate();
	            if (n > 0) {
	                System.out.println("Order inserted successfully.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return n;
	    }

	    @Override
	    public List<Orders> fetchAll() {
	        List<Orders> orderList = new ArrayList<>();
	        try (Statement statement = connection.createStatement();
	             ResultSet res = statement.executeQuery(FETCH_ALL_QUERY)) {

	            while (res.next()) {
	                int orderId = res.getInt("orderId");
	                int userId = res.getInt("uid");
	                int restaurantId = res.getInt("rid");
	                int menuId = res.getInt("menuid");
	                int quantity = res.getInt("quantity");
	                int total = res.getInt("total");
	                String paymentMethod = res.getString("payment_method");
	                String status = res.getString("status");

	                Orders order = new Orders(orderId, userId, restaurantId, menuId, quantity, total, paymentMethod, status);
	                orderList.add(order);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return orderList;
	    }

	    @Override
	    public Orders fetchSpecific(int orderId) {
	        Orders order = null;
	        try (PreparedStatement prepareStatement = connection.prepareStatement(SELECT_QUERY)) {
	            prepareStatement.setInt(1, orderId);
	            try (ResultSet res = prepareStatement.executeQuery()) {
	                if (res.next()) {
	                    int userId = res.getInt("uid");
	                    int restaurantId = res.getInt("rid");
	                    int menuId = res.getInt("menuid");
	                    int quantity = res.getInt("quantity");
	                    int total = res.getInt("total");
	                    String paymentMethod = res.getString("payment_method");
	                    String status = res.getString("status");

	                    order = new Orders(orderId, userId, restaurantId, menuId, quantity, total, paymentMethod, status);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return order;
	    }

	    @Override
	    public int updateOrder(Orders order) {
	        int n = 0;
	        try (PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_QUERY)) {
	            prepareStatement.setInt(1, order.getUid());
	            prepareStatement.setInt(2, order.getRid());
	            prepareStatement.setInt(3, order.getMenuid());
	            prepareStatement.setInt(4, order.getQuantity());
	            prepareStatement.setDouble(5, order.getTotal());
	            prepareStatement.setString(6, order.getPayment_method());
	            prepareStatement.setString(7, order.getStatus());
	            prepareStatement.setInt(8, order.getOrderid());
	            n = prepareStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return n;
	    }

	    @Override
	    public int deleteOrder(int orderId) {
	        int n = 0;
	        try (PreparedStatement prepareStatement = connection.prepareStatement(DELETE_QUERY)) {
	            prepareStatement.setInt(1, orderId);
	            n = prepareStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return n;
	    }
	    	public static int getLastOrderIdFromDatabase()  {
	    		int lastOrderId = 0;
	    		String query = "SELECT MAX(orderid) FROM `orders`"; 

	    		try 
	    		{
	    				PreparedStatement statement = connection.prepareStatement(query);
	    				ResultSet resultSet = statement.executeQuery();
	    				{
	    			if (resultSet.next()) {
	    				lastOrderId = resultSet.getInt(1);
	    			}
	    		 }
	    		}catch(Exception e)
	    		{
	    			e.printStackTrace();
	    		}
	    	return lastOrderId;
	    	}
}