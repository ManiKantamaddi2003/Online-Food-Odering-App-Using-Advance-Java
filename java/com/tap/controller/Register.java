package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.Security.Encrypt;
import com.tap.daoimpl.UserDaoImpl;
import com.tap.model.User;

@WebServlet("/Register")
public class Register extends HttpServlet
{
	private UserDaoImpl userDaoImpl;
	public void init() throws ServletException {
		userDaoImpl = new UserDaoImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
	   User user = (User) req.getSession().getAttribute("user");
		userDaoImpl.insert(user);
		resp.sendRedirect("Login.jsp");
		}
}
