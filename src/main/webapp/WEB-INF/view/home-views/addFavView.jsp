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
List of favourits:
<br>
<c:forEach var="t" items="${favouriteAtt}" varStatus="loop">

            ${t.title}


    <br>
    ${t.description}
</c:forEach>

<br>
<br>
<form:form action="saveFavTask" modelAttribute="taskAtt">

    Title<form:input path="title"/>
    <br><br>
    Description<form:input path="description"/>
    <br><br>
    <br><br>
    <input type="submit" value="OK">


</form:form>

<br>
<button onclick="window.location.href='/'">Home</button>
</body>
</html>
