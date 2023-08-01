<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: serhii.ryzhkov
  Date: 31.07.2023
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
My home view
<br>
<br>
<c:url var="daysButton" value="/days">
    <c:param name="delta" value="5"/>
</c:url>

<br>
<br>

<button onclick="window.location.href='${daysButton}'">
    Days
</button>




</body>
</html>
