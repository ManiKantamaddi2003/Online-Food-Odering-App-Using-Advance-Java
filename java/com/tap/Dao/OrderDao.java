package com.tap.Dao;
import java.util.List;
import com.tap.model.Orders;
	public interface OrderDao 
	{
	    int insert(Orders order);                   
	    List<Orders> fetchAll();                      
	    Orders fetchSpecific(int orderId);           
	    int updateOrder(Orders order);               
	    int deleteOrder(int orderId);         
	}
