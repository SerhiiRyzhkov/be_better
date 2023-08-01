<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: serhii.ryzhkov
  Date: 01.08.2023
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

days
<br>
<c:forEach var="d" items="${daysListAtt}" varStatus="loop">
    <c:if test="${loop.index == 5}">!!</c:if>
    <button onclick="window.location.href='days?delta=${loop.index}'">${d}</button>
    <c:if test="${loop.index == 5}">!!</c:if>
</c:forEach>
<br>
List of tasks:
<br>
<c:forEach var="t" items="${dayTasksAtt}">
    ${t.title}
    ${t.description}
    <br>
</c:forEach>

<br>
</body>
</html>
