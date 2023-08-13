<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.08.2023
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button onclick="window.location.href='/statistic'">
    Statistic
</button>
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
<security:authorize access="hasRole('ADMIN')">
    <button onclick="window.location.href='/admin'">admin menu</button>
    <br>
</security:authorize>


<br>
<button onclick="window.location.href='admin/listOfUsers'">
    ListOfUsers
</button>
</body>
</html>
