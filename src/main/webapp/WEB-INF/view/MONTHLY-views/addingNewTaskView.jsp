<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<button onclick="window.location.href='/statistic'">
    Statistic
</button>
<br>
<br>
<button onclick="window.location.href='/frequent?type=DAILY'">
    Configure frequently tasks
</button>
<br>
<button onclick="window.location.href='/routine?type=DAILY'">
    Configure routine tasks
</button>
<br>
<button onclick="window.location.href='../../..'">Home</button>
<br>

<c:url var="daysButton" value="/days">
    <c:param name="delta" value="${rangeAtt}"/>
</c:url>
<c:url var="monthButton" value="/months">
    <c:param name="delta" value="${rangeAtt}"/>
</c:url>
<c:url var="weekButton" value="/weeks">
    <c:param name="delta" value="${rangeAtt}"/>
</c:url>
<c:url var="yearsButton" value="/years">
    <c:param name="delta" value="${rangeAtt}"/>
</c:url>
<br>
<br>

<button onclick="window.location.href='${daysButton}'">
    Days
</button>
<br>
<button onclick="window.location.href='${weekButton}'">
    Week
</button>
<br>
<button onclick="window.location.href='${monthButton}'">
    Month
</button>
<br>
<button onclick="window.location.href='${yearsButton}'">
    Years
</button>
<br>

<br>
<br>
Month
<form:form action="saveTask${prefixAtt}" modelAttribute="taskAtt">
    Title<form:input path="title"/>
    <br><br>
    Description<form:input path="description"/>
    <br><br>
    Total<form:input path="total"/>
    <br>
    <br><br>
    <input type="submit" value="OK">


</form:form>


</body>
</html>
