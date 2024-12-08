package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tap.daoimpl.MenuDaoImpl;
import com.tap.model.Menu;
@WebServlet("/ShowMenu")
public class ShowMenu extends HttpServlet
{
  @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     int id=Integer.parseInt(req.getParameter("id"));
	     MenuDaoImpl menu=new MenuDaoImpl();
	     List<Menu> menuList=menu.getonId(id);
	     HttpSession session=req.getSession();
	     session.setAttribute("menuList",menuList);
	     resp.sendRedirect("Menu.jsp");	     
}
}
