<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Track Your Order</title>
    <style>
       
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

       
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            color: #333;
            line-height: 1.6;
            text-align: center;
        }

        .container {
            max-width: 400px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        h2 {
            margin-bottom: 20px;
            color: #334756;        }

        p {
            font-size: 18px;
            color: #555; 
            margin-bottom: 20px;
        }

        .order-id {
            font-size: 20px;
            font-weight: bold;
            color: #001f3f;
            margin-bottom: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        button[type="submit"] {
            background-color: #334756;
            color: #fff;
            border: none;
            padding: 12px 24px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        button[type="submit"]:hover {
            background-color: #001f3f; 
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Track Your Order</h2>
        <p>Enter your order ID to track your order status.</p>

      
        <%
           
            Random rand = new Random();
            int orderId = rand.nextInt(900000) + 100000; 
        %>

        <div class="order-id">
            <p>Order ID: <%= orderId %></p>
        </div>

        <!-- Form to enter order ID -->
        <form action="TrackOrderStatus.jsp" method="post">
            <input type="text" name="orderId" placeholder="Enter Order ID" required>
            <button type="submit">Track</button>
        </form>
    </div>

</body>
</html>
