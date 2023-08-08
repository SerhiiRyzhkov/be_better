<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: serhii.ryzhkov
  Date: 07.08.2023
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${frequencyAtt}</title>
</head>
<body>
<c:forEach items="${typesAtt}" var="t" >








        <c:if test="${t==typeAtt}" >
            <button onclick="window.location.href='${frequencyAtt}?type=${t}'">
                    ---${t}---
            </button>

        </c:if>
        <c:if test="${t!=typeAtt}">
            <button onclick="window.location.href='${frequencyAtt}?type=${t}'">
               ${t}
            </button>
        </c:if>





</c:forEach>
<br><br>

<c:forEach var="t" items="${listAtt}" varStatus="loop">
    ${t.title}
    <button onclick="window.location.href='deleteTask?id=${t.id}'">DELETE</button>

    <button onclick="window.location.href='updateTask?id=${t.id}'">UPDATE</button>

    <br>
</c:forEach>

<br>

<button onclick="window.location.href='addNewTask'">ADD NEW TASK</button>

<br>
<button onclick="window.location.href='/'">Home</button>
</body>
</html>
