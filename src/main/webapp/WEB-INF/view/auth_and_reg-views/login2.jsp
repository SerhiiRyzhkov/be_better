<%--
  Created by IntelliJ IDEA.
  User: serhii.ryzhkov
  Date: 22.08.2023
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Be cool!  login</title>
    <!-- Include the Facebook JavaScript SDK -->
    <script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js"></script>
</head>
<body>
<form th:action="@{/login}" method="POST">
    Login
    <br>
    <input type="text" id="email" name="email" th:placeholder="Email"/>
    <br>
    Password
    <br>
    <input type="password" id="password" name="password" th:placeholder="Password"/>
    <br>
    <br>
    <button name="Submit" value="Login" type="Submit" th:text="Login"></button>
    <a href="/registration">registration</a>

    <!-- Add the "Login with Facebook" button -->
    <button type="button" onclick="loginWithFacebook()">Login with Facebook</button>
</form>

<script>
    // Initialize the Facebook SDK
    window.fbAsyncInit = function() {
        FB.init({
            appId      : '234785919061373', // Replace with your Facebook App ID
            cookie     : true,
            xfbml      : true,
            version    : 'v14.0'
        });
    };

    // Load the SDK asynchronously
    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "https://connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

    // Function to handle Facebook login
    function loginWithFacebook() {
        FB.login(function(response) {
            if (response.authResponse) {
                // User is logged in and authorized
                console.log('Logged in with Facebook.');
                // You can handle the response and send it to your server
            } else {
                console.log('User cancelled login or did not fully authorize.');
            }
        }, { scope: 'email' }); // Request email permission
    }
</script>
</body>
</html>