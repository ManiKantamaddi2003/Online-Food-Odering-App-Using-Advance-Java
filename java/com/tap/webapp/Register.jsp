<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Page</title>
    <style>
      
        body {
            font-family: 'Arial', sans-serif;
            background: url('images/images2.jpg'); 
            background-size: cover;
            background-position: center center; 
            background-repeat: no-repeat; 
            background-attachment: fixed; 
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

       
        .container {
          background: rgba(0, 0, 0, 0.7);
            padding: 20px 30px;
            border-radius: 12px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            height: auto;
        }

        h2 {
            text-align: center;
            font-size: 24px;
            margin-bottom: 15px;
            color: #fff; 
            font-weight: 600;
        }

        label {
            display: block;
            font-size: 14px;
            margin-bottom: 5px;
            color: #fff; 
        }

        input[type="text"], input[type="email"], input[type="password"], input[type="tel"] {
            width: 90%;
            padding: 12px;
            margin-bottom: 12px;
            border: 2px solid #ddd;
            border-radius: 8px;
            font-size: 14px;
            outline: none;
            transition: all 0.3s ease-in-out;
        }

        input[type="text"]:focus, input[type="email"]:focus, input[type="password"]:focus, input[type="tel"]:focus {
            border-color: #f2994a;
            box-shadow: 0 0 10px rgba(242, 153, 74, 0.5);
        }

        input[type="submit"] {
            width: 97%;
            padding: 12px;
            background-color: #f2994a; 
            color: white;
            border: none;
            font-size: 14px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
            border-radius: 8px;
        }

        input[type="submit"]:hover {
            background-color: #f2c94c;
        }

        .form-footer {
            text-align: center;
            margin-top: 15px;
            font-size: 14px;
            color: #fff; 
        }

        .form-footer a {
            color: #f2994a;
            text-decoration: none;
            font-weight: bold;
        }

        .form-footer a:hover {
            text-decoration: underline;
        }

        /* Error message style */
        .error-message {
            color: red;
            font-size: 14px;
            text-align: center;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Create an Account</h2>

      
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
            <div class="error-message"><%= errorMessage %></div>
        <%
            }
        %>

        <form action="Validation" method="POST">
            <!-- Name Input -->
            <label for="name">Full Name</label>
            <input type="text" id="name" name="name" required placeholder="Enter your full name">

           
            <label for="email">Email</label>
            <input type="email" id="email" name="email" required placeholder="Enter your email">

           
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required placeholder="Enter your password">

           
            <label for="confirmPassword">Confirm Password</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required placeholder="Confirm your password">

          
            <label for="mobile">Mobile Number</label>
            <input type="tel" id="mobile" name="mobile" required placeholder="Enter your mobile number" pattern="[0-9]{10}" title="Enter a valid 10-digit mobile number">

          
            <input type="submit" value="Register">

            <div class="form-footer">
                <p>Already have an account? <a href="Login.jsp">Login here</a></p>
            </div>
        </form>
    </div>

</body>
</html>
