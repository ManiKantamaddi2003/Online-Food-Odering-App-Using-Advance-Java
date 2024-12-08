package com.tap.controller;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tap.Security.AutoGenerateNumber;
import com.tap.daoimpl.CartDaoImpl;
import com.tap.daoimpl.OrderDaoImpl;
import com.tap.daoimpl.OrderhistoryDaoImpl;
import com.tap.daoimpl.OrderItemDaoImpl;
import com.tap.daoimpl.OrderhistoryDaoImpl;
import com.tap.model.CartItem;
import com.tap.model.OrderHistory;
import com.tap.model.OrderItems;
import com.tap.model.Orders;
import com.tap.model.User;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

    private OrderItemDaoImpl orderItemDaoImpl;
    private CartDaoImpl cartDaoImpl;
    private OrderDaoImpl orderDaoImpl;
    private OrderhistoryDaoImpl orderHistoryDaoImpl;

    @Override
    public void init() throws ServletException {
        cartDaoImpl = new CartDaoImpl(); 
        orderItemDaoImpl = new OrderItemDaoImpl();
        orderDaoImpl = new OrderDaoImpl();
        orderHistoryDaoImpl = new OrderhistoryDaoImpl(); 
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        
       
        User user = (User) session.getAttribute("Useobj");
        
        if (user == null) {
           
            resp.sendRedirect("login.jsp");
            return;
        }
        
        String paymentMethod = req.getParameter("paymentMethod");

       
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        System.out.println(cart);
        
        if (cart == null || cart.isEmpty()) {
           
            resp.sendRedirect("cart.jsp");
            return;
        }

        int orderid = AutoGenerateNumber.generateUniqueOrderId();

       
        double totalAmount = 0; 
        
        for (CartItem cartItem : cart.values()) {
            double itemTotal = cartItem.getPrice() * cartItem.getQuantity();
            totalAmount += itemTotal; 

           
            Orders order = new Orders();
            order.setOrderid(orderid);
            order.setUid(user.getUid());
            order.setRid(cartItem.getResturantId());
            order.setMenuid(cartItem.getItemId()); 
            order.setQuantity(cartItem.getQuantity()); 
            order.setTotal(itemTotal); 
            order.setPayment_method(paymentMethod); 
            order.setStatus("Pending"); 

             int n = orderDaoImpl.insert(order);
            if (n == 1) {
                System.out.println("Order Insert success");
            } else {
                System.out.println("Order Insert failure");
            }

           
            OrderItems orderItem = new OrderItems();
            orderItem.setOrderid(orderid); 
            orderItem.setMenuid(cartItem.getItemId()); 
            orderItem.setQuantity(cartItem.getQuantity()); 
            orderItem.setTotal_item(itemTotal); 

           
            int n1 = orderItemDaoImpl.insert(orderItem);
            if (n1 != 0) {
                System.out.println("Order Item Insert success");
            } else {
                System.out.println("Order Item Insert failure");
            }

        }

       
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderid(orderid); 
        orderHistory.setRid(cart.values().iterator().next().getResturantId()); 
        orderHistory.setUid(user.getUid());
        orderHistory.setTotal(totalAmount); 
        orderHistory.setStatus("Pending");

        
        int orderHistoryInserted = orderHistoryDaoImpl.insert(orderHistory);
        if (orderHistoryInserted == 1) {
            System.out.println("Order History Insert success");
        } else {
            System.out.println("Order History Insert failure");
        }

        session.removeAttribute("cart");

       
        resp.sendRedirect("Confirmation.jsp");
    }
}
