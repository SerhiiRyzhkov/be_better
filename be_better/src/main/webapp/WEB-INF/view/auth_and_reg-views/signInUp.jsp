<%--
  Created by IntelliJ IDEA.
  User: serhii.ryzhkov
  Date: 22.08.2023
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page session="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>BE BETTER</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="<c:url value="/resources/style/login/main.css"/>" media="screen">
    <style>
        body {
            background-image: url('<c:url value="/resources/style/login/back.jpg"/>');
            background-size: cover;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>



<h2 style="color: whitesmoke" id="error">${messageAtt}</h2>
<c:if test="${param.error != null}">

    <h2 style="color: whitesmoke">Authentication Failed : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</h2>

</c:if>
<c:if test="${param.logout != null}">

    <h2 style="color: whitesmoke">You have been logged out successfully</h2>

</c:if>
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form:form action="registration" name="reg" modelAttribute="newUserAtt" method="post">
            <h1>Create Account</h1>


            <form:input path="email" autocomplete="false" placeholder="Email"/>

            <form:input path="name" autocomplete="false" placeholder="Name"/>
            <form:input path="surname" autocomplete="false" placeholder="Surname"/>

            <input type="password" name="pass1Att" placeholder="Password" />
            <input type="password" name="pass2Att" placeholder="Confirm Password" />
            <button onClick="document.forms['reg'].submit();">Sign Up</button>
        </form:form>
    </div>
    <div class="form-container sign-in-container">

            <h1>Sign in</h1>

            <form th:action="@{/login}" method="POST">

            <input type="email" id="email" name="email" placeholder="Email" />
            <input type="password" id="password" name="password" placeholder="Password" />
            <%--<a href="#">Forgot your password?</a>--%>
                <button name="Submit" value="Login" type="Submit" th:text="Login">
            Sign In
                </button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome Back!</h1>
                <p>To keep connected with us please login with your personal info</p>
                <button class="ghost" id="signIn">Sign In</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Hello, Friend!</h1>
                <p>Enter your personal details and start journey with us</p>
                <button class="ghost" id="signUp">Sign Up</button>
            </div>
        </div>
    </div>
</div>

<script>
    const signUpButton = document.getElementById('signUp');
    const signInButton = document.getElementById('signIn');
    const container = document.getElementById('container');

    const loginErrorElement = document.getElementById('error');
    const logErrorText = loginErrorElement.textContent.trim();

    if (logErrorText !== "") {
        container.classList.add("right-panel-active");
    }

    if (logErrorText === "Registration successful") {
        container.classList.add("left-panel-active");
    }

    signUpButton.addEventListener('click', () => {
        container.classList.add("right-panel-active");
    });

    signInButton.addEventListener('click', () => {
        container.classList.remove("right-panel-active");
    });
</script>

</body>
</html>