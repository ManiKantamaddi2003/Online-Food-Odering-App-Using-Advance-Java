<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Home Page</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
             background-image: url('images/image-700x300.jpg'); 
            background-size: cover;  
            background-position: center; 
            background-repeat: no-repeat; 
            padding: 35px 25px;
            color: white;
        }

        .header h1 {
            flex: 1;
            text-align: center;
            margin: 0;
            align-items: left;
            color: white;
            
        }

        .header .auth-buttons {
            display: flex;
            gap: 10px;
        }

        .header .auth-buttons a {
            text-decoration: none;
            padding: 8px 16px;
            background-color: #007BFF;
            color: white;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        .header .auth-buttons a:hover {
            background-color: #0056b3;
        }

        .container {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 40px;
            padding: 40px 10px;
            justify-items: center;
            margin-top: 50px;
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
            padding: 15px;
            text-align: left;
        }

        .details p {
            margin: 5px 0;
            color: #555;
        }

        .details span {
            font-weight: bold;
        }

        .buttons {
    padding: 10px;
    display: flex;
    justify-content: center; 
}

.buttons .view {
    padding: 8px 16px;
    background-color: #007BFF;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    text-align: center;
    display: inline-block; 
}

.buttons .view:hover {
    background-color: #0056b3;
}


        .view {
            padding: 8px 16px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-align: center;
        }

        .view:hover {
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
        <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome to SpoonSavor!</h1>
        
        <div class="auth-buttons">
            <a href="Login.jsp">Login</a>
            <a href="Register.jsp">Signup</a>
        </div>
    </div>

    <div class="container">
        <% 
            List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("restaurantList");

            if (restaurantList != null && !restaurantList.isEmpty()) {
                for (Restaurant restaurant : restaurantList) {
        %>
            <div class="card">
                <img src="<%= restaurant.getImage() %>" alt="<%= restaurant.getRname() %>">
                <h3><%= restaurant.getRname() %></h3>
                <div class="details">
                    <p><span>Cuisine Type:</span> <%= restaurant.getCusineType() %></p>
                    <p><span>Rating:</span> <%= restaurant.getRatings() %></p>
                    <p><span>Address:</span> <%= restaurant.getAddress() %></p>
                    <p><span>Status:</span> <%= restaurant.getIsActive() %></p>
                </div>
                <div class="buttons">
                    <button class="view">View Menu</button>
                </div>
            </div>
        <% 
                }
            } else {
        %>
            <p>No restaurants found.</p>
        <% 
            }
        %>
    </div>

</body>
</html>
