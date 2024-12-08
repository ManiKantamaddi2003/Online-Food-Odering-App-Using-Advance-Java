package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.UserDaoImpl;
import com.tap.model.User;


@WebServlet("/login")
public class Login  extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	  String email = req.getParameter("email");
      String pass = req.getParameter("password");
      UserDaoImpl userDao = new UserDaoImpl();
      User user = userDao.isValidate(email);
      if (user != null) 
      {
          if (user.getPassword().equals(pass)) 
          {
        	  HttpSession session=req.getSession();
        	  session.setAttribute("Useobj", user);
              resp.sendRedirect("GetRestaurant");
          } else {
        	  req.setAttribute("errorMessage", "Invalid password. Please try again.");
              req.getRequestDispatcher("/Login.jsp").forward(req, resp);
          }
      } else {
       
    	  req.setAttribute("errorMessage", "No user found with the given email .");
          req.getRequestDispatcher("/Login.jsp").forward(req, resp);
      }
  }
}