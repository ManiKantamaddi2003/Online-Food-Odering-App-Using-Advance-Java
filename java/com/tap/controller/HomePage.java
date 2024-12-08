package com.tap.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tap.daoimpl.RestaurantDaoImpl;
import com.tap.model.Restaurant;

@WebServlet("/home")
public class HomePage extends HttpServlet
{
       @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
       {
    	
    	RestaurantDaoImpl rid=new RestaurantDaoImpl();
       	List<Restaurant> restaurantList=rid.fetchAll();
       	HttpSession sesstion=req.getSession();
       	sesstion.setAttribute("restaurantList",restaurantList);
       	resp.sendRedirect("frist.jsp");	 
       }
}
