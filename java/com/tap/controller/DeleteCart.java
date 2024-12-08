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

@WebServlet("/DeleteCart")
public class DeleteCart extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart != null) {
            String itemIdStr = req.getParameter("itemId");
            if (itemIdStr != null) {
                try {
                    int itemId = Integer.parseInt(itemIdStr);
                    cart.remove(itemId);
                    session.setAttribute("cart", cart);
                } catch (NumberFormatException e) {
                   
                    e.printStackTrace();
                }
            }
        }
        
       
        resp.sendRedirect("cart.jsp");
    }
}
