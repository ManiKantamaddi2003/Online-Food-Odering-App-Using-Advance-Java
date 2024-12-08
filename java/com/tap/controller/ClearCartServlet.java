package com.tap.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.CartItem;

@WebServlet("/ClearCart")
public class ClearCartServlet  extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	 HttpSession   session=req.getSession();
    	 Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
    	 if(cart!=null)
    	 {
    	    cart.clear();
    	 }
    	 session.setAttribute("cart", cart);  
         resp.sendRedirect("cart.jsp"); 
    	 
    }
}
