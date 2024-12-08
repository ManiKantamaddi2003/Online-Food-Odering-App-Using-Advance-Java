package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/confirmOrderServlet")
public class RemoveCart  extends HttpServlet
{
       @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
       {
    	   HttpSession session = req.getSession();
           session.removeAttribute("cart");

           
           resp.sendRedirect("Confirmation.jsp");
       }
}
