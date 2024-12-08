<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Menu"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Page</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            font-family: sans-serif;
        }

        body {
            background: rgb(238,174,202);
background: radial-gradient(circle, rgba(238,174,202,1) 0%, rgba(148,187,233,1) 100%);
            padding-top: 80px;
        }

        h1 {
            text-align: center;
            position: absolute;
            top: 7%;
            left: 50%;
            transform: translateX(-50%);
            color: white;
            font-size: 60px;
            font-weight: 700;
            letter-spacing: 8px;
            margin-bottom: 20px;
            background: none;
            animation-name: text;
            animation-duration: 4s;
            animation-iteration-count: infinite;
        }

        @keyframes text {
            0% {
                color: navy;
                letter-spacing: 8px;
            }
            30% {
                letter-spacing: 25px;
                color: #789DBC;
            }
            60% {
                letter-spacing: 10px;
                color: #4CC9FE;
            }
            100% {
                letter-spacing: 8px;
                color: #55679C;
            }
        }

        .menu-container {
            display: flex;
            flex-direction: column;
            gap: 20px;
            align-items: center;
            margin-top: 100px;
            padding: 0 15px;
        }

        .menu-item {
            display: flex;
            justify-content: space-between;
            background-color: #fff;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 95%;
            max-width: 1000px;
            margin: 0 auto 20px auto;
            position: relative;
        }

        .menu-info {
            flex: 1;
            margin-right: 20px;
        }

        .menu-info h2 {
            font-size: 24px;
            margin: 0 0 10px;
            color: #333;
        }

        .menu-info p {
            font-size: 16px;
            color: #222;
            margin: 5px 0;
        }

        .menu-info .price {
            font-size: 19px;
            font-weight: bold;
            color: #333;
        }

        .menu-info .rating {
            font-size: 19px;
            color: #f39c12;
        }

        .menu-info .availability {
            font-size: 20px;
            color: #28a745;
        }

       
        .menu-image {
            position: relative;
            width: 220px; 
            height: 220px; 
            border-radius: 8px;
            overflow: hidden;
        }

        .menu-image img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .menu-image .overlay {
            position: absolute;
            bottom: 10px;
            right: 10px; 
            display: flex;
            justify-content: flex-end; 
            align-items: center; 
        }

        .menu-item .overlay button {
        margin-top:10px;
            padding: 10px 20px;
            background-color: navy;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .menu-item .overlay button:hover {
            background-color: #3482d1;
        }

        /* Style the input box to make it narrow */
        .menu-info input[type="number"] {
            width: 150px; 
            padding: 5px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-top: 10px;
        }
    </style>
</head>
<body>

    <div class="content-wrapper">
        <h1>Menu Items</h1>

        <%
            List<Menu> menuList = (List<Menu>) session.getAttribute("menuList");
            if (menuList != null && !menuList.isEmpty()) {
        %>
        
        <div class="menu-container">
            <% 
               
                for (Menu menu : menuList) {
            %>
            
            <div class="menu-item">
                <!-- Left side information -->
                <div class="menu-info">
                    <h2><%= menu.getName() %></h2>
                    <p><%= menu.getDescription() %></p>
                    <p class="price">₹ <%= menu.getPrice() %></p>
                    <p class="rating"> ⭐<%= menu.getRating() %></p>
                    <p class="availability"><strong>Status:</strong> 
                        <%= menu.getIsAvailable()  %>
                    </p>
                    
                    <form action="cartServlet" method="POST">
                        <!-- Hidden input to send menuId -->
                        <input type="hidden" name="menuid" value="<%= menu.getMenuid() %>">
                        
                        <!-- Hidden input to send price -->
                        <input type="hidden" name="price" value="<%= menu.getPrice() %>">

                        <!-- Quantity input with name attribute -->
                        <label>Quantity</label>
                        <input type="number" name="quantity" min="1" max="15" value="1">
                        
                        <div class="overlay">
                            <a href="cartServlet?menuid=<%= menu.getMenuid() %>">
                                <button>ADD</button>
                            </a>
                        </div>
                    </form>
                </div>

                <div class="menu-image">
                    <img src="<%= menu.getImage() %>" alt="<%= menu.getName() %>">
                </div>
            </div>
            
            <% 
                }
            %>

        </div>

        <% 
            } else {
        %>
            <p>No menu items available.</p>
        <% 
            }
        %>
    </div>

</body>
</html>
