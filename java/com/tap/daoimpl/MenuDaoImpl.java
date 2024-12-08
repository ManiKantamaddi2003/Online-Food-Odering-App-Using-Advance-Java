package com.tap.daoimpl;
import com.tap.Dao.MenuDao;
import com.tap.model.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDaoImpl implements MenuDao {
    final static String INSERT_QUERY = "INSERT INTO `menu` (`rid`, `name`, `description`, `price`, `rating`, `isAvailable`,`image`) VALUES (?, ?, ?, ?, ?, ?,?)";
    final static String FETCH_ALL_QUERY = "SELECT * FROM `menu`";
    final static String SELECT_QUERY = "SELECT * FROM `menu` WHERE `menuid` = ?";
    final static String UPDATE_QUERY = "UPDATE `menu` SET `rid` = ?, `name` = ?, `description` = ?, `price` = ?, `rating` = ?, `isAvailable` = ? `image` = ? WHERE `menuid` = ?";
    final static String DELETE_QUERY = "DELETE FROM `menu` WHERE `menuid` = ?";
    final static String SELECT_RQUERY = "SELECT * FROM `menu` WHERE `rid` = ?";
    static Connection connection;

    public MenuDaoImpl() {
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
    public void insert(Menu menu) {
        try 
        {
        	PreparedStatement prepareStatement = connection.prepareStatement(INSERT_QUERY);
            prepareStatement.setInt(1, menu.getRid());
            prepareStatement.setString(2, menu.getName());
            prepareStatement.setString(3, menu.getDescription());
            prepareStatement.setDouble(4, menu.getPrice());
            prepareStatement.setDouble(5, menu.getRating());
            prepareStatement.setString(6, menu.getIsAvailable()); 
            prepareStatement.setString(7, menu.getImage()); 
            
            int n = prepareStatement.executeUpdate();
            if (n > 0) {
                System.out.println("Menu item inserted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Menu> fetchAll() {
        List<Menu> menuList = new ArrayList<>();
        try 
        {
        	Statement statement = connection.createStatement();
             ResultSet res = statement.executeQuery(FETCH_ALL_QUERY);
            while (res.next()) {
                int menuid = res.getInt("menuid");
                int rid = res.getInt("rid");
                String name = res.getString("name");
                String description = res.getString("description");
                double price = res.getDouble("price");
                double rating = res.getDouble("rating");
                String isAvailable = res.getString("isAvailable");
                String image=res.getString("image");

                Menu menu = new Menu(menuid, rid, name, description, price, rating, isAvailable,image);
                menuList.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public Menu fetchSpecific(int menuId) {
        Menu menu = null;
        try 
        {
        	PreparedStatement prepareStatement = connection.prepareStatement(SELECT_QUERY);
            prepareStatement.setInt(1, menuId);
            ResultSet res = prepareStatement.executeQuery();
                if (res.next()) {
                    int rid = res.getInt("rid");
                    String name = res.getString("name");
                    String description = res.getString("description");
                    double price = res.getDouble("price");
                    double rating = res.getDouble("rating");
                    String isAvailable = res.getString("isAvailable"); 
                     String image=res.getString("image");
                    menu = new Menu(menuId, rid, name, description, price, rating, isAvailable,image);
                }
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public int updateMenu(Menu menu) {
        int n = 0;
        try 
        {
        	PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_QUERY);
            prepareStatement.setInt(1, menu.getRid());
            prepareStatement.setString(2, menu.getName());
            prepareStatement.setString(3, menu.getDescription());
            prepareStatement.setDouble(4, menu.getPrice());
            prepareStatement.setDouble(5, menu.getRating());
            prepareStatement.setString(6, menu.getIsAvailable()); 
            prepareStatement.setString(7, menu.getImage()); 
            prepareStatement.setInt(8, menu.getMenuid());
            n = prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int deleteMenu(int menuId) {
        int n = 0;
        try 
        {
        	PreparedStatement prepareStatement = connection.prepareStatement(DELETE_QUERY);
            prepareStatement.setInt(1, menuId);
            n = prepareStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return n;
    }
    public List<Menu> getonId(int id)
    {
    	 List<Menu> menuList = new ArrayList<>();
    	try
    	{
    		PreparedStatement prepareStatement = connection.prepareStatement(SELECT_RQUERY);
                prepareStatement.setInt(1, id);
                ResultSet res = prepareStatement.executeQuery() ;
                    while (res.next()) 
                    {
                        int menuId=res.getInt("menuid");     
                        int rid = res.getInt("rid");
                        String name = res.getString("name");
                        String description = res.getString("description");
                        double price = res.getDouble("price");
                        double rating = res.getDouble("rating");
                        String isAvailable = res.getString("isAvailable"); 
                        String image = res.getString("image"); 
                        Menu menu = new Menu(menuId, rid, name, description, price, rating, isAvailable,image);
                        menuList.add(menu);
                        
                    }
               }
    	     catch (SQLException e) 
    	     {
                e.printStackTrace();
              }
            return menuList;
        }  
}
