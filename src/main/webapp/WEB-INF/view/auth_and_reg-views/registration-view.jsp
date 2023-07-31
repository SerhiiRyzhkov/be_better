<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31.07.2023
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br><br>

<form:form action="registration" name="reg" modelAttribute="newUserAtt" method="post">
    <br><br>

        E-mail<br><br>
    <form:input path="email" autocomplete="false"/>
    <br><br>
        First name
    <br><br>
    <form:input path="name" autocomplete="false"/>
    <br><br> Surname   <br><br>
        <form:input path="surname" autocomplete="false"/>

    <br><br>

    Password
    <br><br>
        <input type="password" name="pass1Att" />
    <br><br>
    Confirm password
    <br><br>
        <input type="password" name="pass2Att" />
    <br><br>

    <a href="#" style="margin-left: 30px;" onClick="document.forms['reg'].submit();">

        Sign Up
    </a>
    <br><br>
    <a href="/" style="margin-left: 60px;">

        Back
    </a>
    <br><br>
</form:form>
</body>
</html>
