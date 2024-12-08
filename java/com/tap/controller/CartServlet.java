package com.tap.controller;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpl.CartDaoImpl;
import com.tap.daoimpl.MenuDaoImpl;
import com.tap.model.CartItem;
import com.tap.model.Menu;

@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
             if (cart == null) {
            cart = new HashMap<>();  
            System.out.println("New cart created.");
            req.getSession().setAttribute("cart", cart);
        } else {
            System.out.println("Existing cart found.");
        }
        int menuId = Integer.parseInt(req.getParameter("menuid"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        MenuDaoImpl menuDao = new MenuDaoImpl();
        Menu menu = menuDao.fetchSpecific(menuId);
        CartItem ci = new CartItem(menuId, menu.getRid(), menu.getName(), quantity, menu.getPrice());
        CartDaoImpl cartDao = new CartDaoImpl();
        cart = cartDao.addItem(ci,cart);  
        System.out.println("Added Item \n"+cart);
        req.getSession().setAttribute("cart", cart);  
        System.out.println("Cart after adding item: " + cart);
        resp.sendRedirect("cart.jsp");
    }
}
