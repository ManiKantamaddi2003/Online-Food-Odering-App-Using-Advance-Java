<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
            color: #334756; 
        }

        p {
            font-size: 18px;
            color: #555; 
            margin-bottom: 20px;
        }

        .status {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }
        
        .button-container {
            display: flex;
            justify-content: center; 
            margin-top: 20px;
        }

        .back-btn {
            background-color: #334756;
            color: #fff;
            border: none;
            padding: 12px 24px; 
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .back-btn:hover {
            background-color: #001f3f; 
        }
    </style>
</head>
<body>
 <div class="container">
        <h2>Order Status</h2>
        <p>Your order with ID <%= request.getParameter("orderId") %> is currently:</p>
        <div class="status">
            <%= "Your Order will be dispatched soon !!" %>
        </div>
       <div class="button-container">
   <button class="back-btn" onclick="window.location.href='GetRestaurant'">Home</button>
  </div>


    </div>
</body>
</html>
