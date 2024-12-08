<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.User" %>
<%@ page import="com.tap.model.Restaurant" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <style>
       
        body {
            font-family: Arial, sans-serif;
            background: rgb(238,174,202);
background: radial-gradient(circle, rgba(238,174,202,1) 0%, rgba(148,187,233,1) 100%);
            margin: 0;
            padding: 0;
            background-size: cover;  
            background-position: center;  
            background-repeat: no-repeat; 
            background-attachment: fixed;
        }

       
        .header {
            display: flex;
            justify-content: space-between; 
            align-items: center;    
            padding: 20px 50px;
            color: white;
            height: 150px; 
            background-image: url('images/image-700x300.jpg'); 
            background-size: cover;  
            background-position: center; 
            background-repeat: no-repeat; 
        }

       
        .welcome-message {
            font-size: 40px; 
            text-align: center; 
            flex: 1;  
            color:white;
        }

       
        .header-img {
            width: 40px;  
            height: auto;  
            margin-right: 15px; 
        }

        /* Buttons section */
        .auth-buttons {
            display: flex;
            gap: 20px; 
        }

        .auth-buttons button {
            padding: 12px 20px;
            font-size: 16px;
            cursor: pointer;
            border: none;
            border-radius: 5px;
            color: white;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .auth-buttons .login {
            background-color: navy;  
        }

        .auth-buttons .login:hover {
            background-color: #0056b3;  
        }

        .auth-buttons .register {
            background-color: navy; 
        }

        .auth-buttons .register:hover {
            background-color: #0056b3;  
        }

        /* Main container to display cards */
        .container {
            display: grid;
            grid-template-columns: repeat(3, 1fr);  
            gap: 40px; 
            padding: 40px 10px;  
            justify-items: center; 
        }

        .card {
            background-color: white;
            border-radius: 12px;
            padding: 15px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);  
            transition: transform 0.3s ease, box-shadow 0.3s ease; 
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            width: 350px; 
            height: auto; 
        }

        .card:hover {
            transform: translateY(-6px); 
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.15);  
        }

       
        .card img {
            width: 100%;  
            height: 200px;  
            object-fit: cover;  
            border-radius: 8px;  
            margin-bottom: 15px;  
        }

       
        .card h3 {
            margin: 0 0 10px 0;
            font-size: 20px;
            color: #333;
            font-weight: 600;
            text-align: center;  
        }

      
        .details {
            margin-bottom: 10px;  
        }

       
        .details span {
            font-weight: bold;
            color: #333;
            font-size: 18px;  
        }

       
        .details p {
            margin: 5px 0;
            font-size: 16px;
            color: #666;
        }

       
        .buttons {
            display: flex;
            justify-content: center; 
        }

        .buttons button {
            padding: 10px 18px;  
            font-size: 14px;
            cursor: pointer;
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .buttons .view {
            background-color: navy; 
            color: white;
        }

        .buttons .view:hover {
            background-color: #0056b3; 
        }

      
        @media (max-width: 1024px) {
            .container {
                grid-template-columns: repeat(2, 1fr); 
            }
        }

        @media (max-width: 768px) {
            .container {
                grid-template-columns: 1fr;  
            }
        }
    </style>
</head>
<body>

    <div class="header">
        <% 
            // Check if the user is logged in
            User user = (User) session.getAttribute("Useobj");
            if (user != null) {
        %>
          
            <div class="welcome-message">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome  <%= user.getUsername() %> 🙏
            </div>
            <div class="auth-buttons">
                <button class="login" onclick="window.location.href='Login.jsp'">Login</button>
                <button class="register" onclick="window.location.href='cart.jsp'">Cart</button>
            </div>
        <% 
            }
        %>
    </div>

    <% 
       
        if (user != null) {
            List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("restaurantList");

            if (restaurantList != null && !restaurantList.isEmpty()) {
    %>
        <div class="container">
            <% 
              
                for (Restaurant restaurant : restaurantList) {
            %>
                <div class="card">

                    <img src="<%= restaurant.getImage() %>" alt="<%= restaurant.getRname() %>">
                    <h3><%= restaurant.getRname() %></h3>
                    <div class="details">
                        <p><span>Cuisine Type:</span> <%= restaurant.getCusineType() %></p>
                        <p><span>Rating:</span> <%= restaurant.getRatings() %></p>
                        <p><span>Address:</span> <%= restaurant.getAddress() %></p>
                        <p>  <span>Status: </span> <%= restaurant.getIsActive() %></p>
                    </div>
                    <!-- Buttons section -->
                    <div class="buttons">
                      <a href="ShowMenu?id=<%=restaurant.getRid()%>"> <button class="view">View Menu</button> </a>
                    </div>
                </div>
            <% 
                }
            %>
        </div>

    <% 
        } else {
    %>
        <h3 style="text-align:center;">No restaurant data available.</h3>
    <% 
        }
    } 
    %>

</body>
</html>
