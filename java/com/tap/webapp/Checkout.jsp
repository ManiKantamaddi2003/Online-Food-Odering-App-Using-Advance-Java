<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Form</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; 
            color: #333;
            flex-direction: column; 
        }

        
        .header {
            text-align: center;
            color: #4CAF50;
            margin-bottom: 20px;
            font-size: 28px;
            font-weight: bold;
        }

       
        form {
            width: 380px; 
            height: 500px; 
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1); 
            overflow-y: auto;
            font-size: 16px;
            transition: all 0.3s ease;
        }

        form:hover {
            box-shadow: 0 6px 18px rgba(0, 0, 0, 0.2); 
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            font-size: 16px;
            color: #555;
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input, select {
            width: 100%; 
            padding: 12px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 6px;
            background-color: #f9f9f9;
            margin-top: 5px;
            box-sizing: border-box;
        }

        input:focus, select:focus {
            outline: none;
            border-color: #4CAF50;
            box-shadow: 0 0 8px rgba(76, 175, 80, 0.4);
        }

        button {
            padding: 12px 20px;
            font-size: 18px;
            color: white;
            background-color: #4CAF50;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            width: 100%; 
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #45a049; 
        }

        .form-group p {
            font-size: 14px;
            color: #777;
            margin-top: 10px;
            text-align: center;
        }

       
        @media (max-width: 768px) {
            form {
                width: 90%;
                padding: 20px;
            }
        }
    </style>
</head>
<body>


<div class="header">
    <h2>Order Form</h2>
</div>


<form action="orderConfirmation.jsp" method="POST">
    <!-- Plate Number -->
    <div class="form-group">
        <label for="plateNo">Plate No:</label>
        <input type="text" id="plateNo" name="plateNo" required>
    </div>
    
  
    <div class="form-group">
        <label for="street">Street:</label>
        <input type="text" id="street" name="street" required>
    </div>
    
    
    <div class="form-group">
        <label for="pinCode">Pin Code:</label>
        <input type="text" id="pinCode" name="pinCode" required>
    </div>

   
    <div class="form-group">
        <label for="paymentMethod">Mode of Payment:</label>
        <select id="paymentMethod" name="paymentMethod" required>
            <option value="Cash on Delivery">Cash on Delivery</option>
            <option value="Credit Card">Credit Card</option>
            <option value="Debit Card">Debit Card</option>
            <option value="UPI">UPI</option>
        </select>
    </div>

   
    <div class="form-group">
        <button type="submit">Confirm</button>
    </div>
</form>

</body>
</html>
