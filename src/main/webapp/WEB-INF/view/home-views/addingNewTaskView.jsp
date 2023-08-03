<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: serhii.ryzhkov
  Date: 02.08.2023
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Write new task:
<br>
<br>

<form:form action="saveTask" modelAttribute="taskAtt">
    Title<form:input path="title"/>
    <br><br>
    Description<form:input path="description"/>
    <br><br>
    <br><br>
    <input type="submit" value="OK">


</form:form>


</body>
</html>
