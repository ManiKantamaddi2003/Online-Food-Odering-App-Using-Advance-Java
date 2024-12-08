package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.Dao.OrderDao;
import com.tap.daoimpl.OrderDaoImpl;
import com.tap.model.Orders;
import com.tap.model.User;

@WebServlet("/Orders")
public class Confirm extends HttpServlet {

    private OrderDao orderDao;

    @Override
    public void init() throws ServletException {
        super.init();
        orderDao = new OrderDaoImpl(); // Instantiate the DAO to interact with the database
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<Orders> cart = (List<Orders>) req.getSession().getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            resp.getWriter().write("Your cart is empty.");
            return;
        }
        User user = (User) req.getSession().getAttribute("Useobj");

        if (user == null) {
            resp.getWriter().write("Please log in first.");
            return;
        }
        double totalAmount = 0;
        for (Orders order : cart) {
            totalAmount += order.getTotal(); 
        }
        String paymentMethod = req.getParameter("payment_method");
        for (Orders order : cart) {
            order.setUid(user.getUid());
            order.setTotal(totalAmount);
            order.setPayment_method(paymentMethod);
            order.setStatus("Pending"); 

           
            orderDao.insert(order);
        }
        req.getSession().removeAttribute("cart");
        resp.getWriter().write("Order confirmed successfully! Your total is: " + totalAmount);
        
    }
}
