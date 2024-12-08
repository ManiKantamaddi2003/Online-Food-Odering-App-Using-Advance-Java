package com.tap.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpl.CartDaoImpl;
import com.tap.model.CartItem;


@WebServlet("/callUpdateservlet")
public class UpdateCartServlet  extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		     int ItemId=Integer.parseInt(req.getParameter("itemId"));
		     int qunantity=Integer.parseInt(req.getParameter("quantity"));
		     Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
	            if (cart != null) {
	                CartDaoImpl cartDao = new CartDaoImpl();
	                cart = cartDao.updateCartItem(ItemId, qunantity, cart);
	                req.getSession().setAttribute("cart", cart);
	            }
	            resp.sendRedirect("cart.jsp");
		   
	}
}
