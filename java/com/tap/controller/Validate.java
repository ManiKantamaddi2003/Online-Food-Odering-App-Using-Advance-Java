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
import com.tap.model.User;


@WebServlet("/Validation")
public class Validate  extends HttpServlet
{
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 PrintWriter out=resp.getWriter();
	     String password=req.getParameter("password");
	     String ConfirmPassword=req.getParameter("confirmPassword");
	     
	     System.out.println(password+"    "+ConfirmPassword);
	     
	     if(password.equals(ConfirmPassword))
	     {
	    	String name = req.getParameter("name");
	 		String email = req.getParameter("email");
	 		password =Encrypt.encrypt(req.getParameter("password"));
	 		String mobile = req.getParameter("mobile");
	 		User user = new User();
	 		user.setUsername(name);
	 		user.setEmail(email);
	 		user.setPassword(password);
	 		user.setMobile(mobile);
	 		
	 		req.getSession().setAttribute("user", user);
	 		
	    	resp.sendRedirect("Register");
	     }
	     else
	     {
	    	 req.setAttribute("errorMessage", "Password and Confirm Password do not match!");
	            RequestDispatcher rd = req.getRequestDispatcher("Register.jsp");
	            rd.forward(req, resp);
	     }
	}
	
	
}
