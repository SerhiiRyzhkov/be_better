<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: serhii.ryzhkov
  Date: 08.08.2023
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Fill the Task:
<br>
<br>
<form:form action="saveTask?id=${idAtt}" modelAttribute="taskAtt">
    Title <form:input path="title"/>
    <br><br>
    Description <form:input path="description"/>
    <br><br>

    <c:if test="${period}">
        Times per period <form:input path="total"/>
        <br><br>
    </c:if>



    <input type="submit" value="OK">
<br>

</form:form>
<button onclick="window.location.href='/${freqAtt}?type=${typeAtt}'">Cancel</button>
<br>
</body>
</html>
