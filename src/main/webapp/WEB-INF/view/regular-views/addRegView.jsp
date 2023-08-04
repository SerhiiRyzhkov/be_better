<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: serhii.ryzhkov
  Date: 03.08.2023
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
List of regular tasks:
<br>
<c:forEach var="t" items="${regularAtt}" varStatus="loop">

            ${t.title}


    <br>
    ${t.description}
    <br>
</c:forEach>

<br>
<br>
<form:form action="saveRegTask" modelAttribute="taskAtt">

    Title<form:input path="title"/>
    <br><br>
    Description<form:input path="description"/>
    <br><br>
    Type<form:select path="type">
    <form:option value="DAILY" label="DAILY"/>
    <form:option value="WEEKLY" label="WEEKLY"/>
    <form:option value="MONTHLY" label="MONTHLY"/>
    <form:option value="YEARLY" label="YEARLY"/>
</form:select>
    <br><br>
    <input type="submit" value="OK">


</form:form>

<br>
<button onclick="window.location.href='../../..'">Home</button>
</body>
</html>
