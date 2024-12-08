<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.tap.model.CartItem" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.tap.daoimpl.CartDaoImpl" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Shopping Cart</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 20px;
            background: rgb(238,174,202);
background: radial-gradient(circle, rgba(238,174,202,1) 0%, rgba(148,187,233,1) 100%);
        }
        .container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: center;
        }
        .card {
            background-color: #ffffff;
            border: 1px solid #e0e0e0;
            border-radius: 15px;
            padding: 20px;
            width: 300px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }
        .card h3 {
            margin: 0 0 15px;
            font-size: 1.5em;
            font-weight: bold;
            color: #333;
        }
        .card p {
            margin: 5px 0;
            font-size: 1.1em;
            color: #555;
        }
        .card .actions {
            margin-top: 20px;
            text-align: center;
            width: 100%;
        }
        .card button {
            padding: 10px 20px;
            margin: 5px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1em;
            width: 100%;
            transition: background-color 0.3s ease;
        }
        .card .update-btn {
            background-color: navy;
            color: white;
        }
        .card .update-btn:hover {
            background-color: green;
        }
        .card .delete-btn {
            background-color: navy;
            color: white;
        }
        .card .delete-btn:hover {
            background-color: Red;
        }
        .checkout-btn {
            background-color: #4CAF50;
            color: white;
            font-size: 1.5em;
            width: 100%;
            padding: 15px;
            border-radius: 8px;
            text-align: center;
            margin-top: 20px;
        }
        .checkout-btn:hover {
            background-color: #45a049;
        }
        .add-more-btn {
            background-color: #2196F3;
            color: white;
            width: auto;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 1em;
        }
        .add-more-btn:hover {
            background-color: #0b7dda;
        }
        .card input[type="number"] {
            padding: 10px;
            width: 80%;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ddd;
            font-size: 1em;
            text-align: center;
        }
        header h1 {
            font-size: 2.5em;
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }
        .clear-cart-btn {
            position: absolute;
            top: 20px;
            right: 20px;
            padding: 10px 20px;
            font-size: 1.1em;
            background-color: red;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .clear-cart-btn:hover {
            background-color: blue;
        }
      #cart 
      {
     display: flex;
     justify-content: center;
     align-items: flex-start;
     width: 100%;
     height: 100vh;
     margin-top: -10%;  
     padding-top: 20%;  
    }
   #cart img 
   {
    max-width: 100%;            
    max-height: 50%;           
    object-fit: contain;       
   }

    </style>
</head>
<body>
   <header>
    <h1>Your Cart</h1>
</header>

<form action="ClearCart" method="post">
    <button type="submit" class="clear-cart-btn">Clear Cart</button>
</form>

<%
    Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
    
    if (cart == null || cart.isEmpty()) {
%> 
    <div id="cart">
    <img src="images/cart.png" alt="Empty Cart Image">
   </div>
<% 
    } else {
%>
    <div class="container">
        <%
            for (CartItem item : cart.values()) {
        %>
            <div class="card">
                <h3><%= item.getName() %></h3>
                <p><strong>Price:</strong> $<%= item.getPrice() %></p>
                <div class="actions">
                    <form action="callUpdateservlet" method="post" style="display:inline;">
                        <label for="quantity_<%= item.getItemId() %>">Quantity:</label>
                        <span style="margin-left: 10px; font-weight: bold;"> <%= item.getQuantity() %> </span>
                        <input type="number" id="quantity_<%= item.getItemId() %>" name="quantity" value="<%= item.getQuantity() %>" min="1" required>
                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                        <button type="submit" class="update-btn">Update</button>
                    </form>
                    <form action="DeleteCart" method="post" style="display:inline;">
                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                        <button type="submit" class="delete-btn">Delete</button>
                    </form>
                    <form action="Menu.jsp" method="get" style="display:inline;">
                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                        <button type="submit" class="add-more-btn">Add More</button>
                    </form>
                </div>
            </div>
        <% 
            }
        %>
    </div>
    <div class="container">
        <form action="Checkout.jsp" method="post" style="text-align:center; width: 20%;">
            <button type="submit" class="checkout-btn">Proceed to Checkout</button>
        </form>
    </div>

<% 
    }
%>

</body>
</html>
