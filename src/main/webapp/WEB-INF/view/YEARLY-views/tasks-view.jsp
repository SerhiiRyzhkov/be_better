<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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

years
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
<security:authorize access="hasRole('ADMIN')">
    <button onclick="window.location.href='/admin'">admin menu</button>
    <br>
</security:authorize>
<br>
<br>
<c:forEach var="d" items="${datesListAtt}" varStatus="loop">

    <c:choose>
        <c:when test="${actualDateAtt==d.key}">
            <c:if test="${loop.index == 5}">!!</c:if>
            <button onclick="window.location.href='${urlAtt}?delta=${loop.index}'">
                <p class="red-text" style="color: red">${d.value}</p>
            </button>
            <c:if test="${loop.index == 5}">!!</c:if>
        </c:when>
        <c:otherwise>
            <c:if test="${loop.index == 5}">!!</c:if>
            <button onclick="window.location.href='${urlAtt}?delta=${loop.index}'">${d.value}</button>
            <c:if test="${loop.index == 5}">!!</c:if>
        </c:otherwise>
    </c:choose>


</c:forEach>

<button onclick="window.location.href='setToday${prefixAtt}'"> Set Today
</button>
<br>

<br>

<br>
List of tasks:
<br>
<c:forEach var="t" items="${toDoAtt}" varStatus="loop">
    <c:url var="completeButton" value="/complete${prefixAtt}">
        <c:param name="index" value="${loop.index}"/>
    </c:url>
    <br>
    <br>
    ${t.title}
    ${t.description}

    <form action="/postRange${prefixAtt}" method="post">
        <div class="slidecontainer">
            <input type="range" min="0" max="${t.total}" value="${t.score}" class="slider" id="myRange" name="sliderValue">
        </div>
        <input type="hidden" name="task_index" value="${loop.index}">
        <button type="submit">Set progress</button>
    </form>

    |||
    <button onclick="window.location.href='${completeButton}'" value="${loop.index}">
            ${t.status}
    </button>
    <br>
    <c:if test="${t.status == 'FAILED'}"><button onclick="window.location.href='${transferButton}'" value="${loop.index}">Transfer to next ${typeAtt}</button></c:if>



    <br>
</c:forEach>

<br>
<br>
<br>
<input type="button" value="Add new task" onclick="window.location.href='addingNewTask${prefixAtt}'">
<br>
<input type="button" value="SetRoutine" onclick="window.location.href='setRoutine${prefixAtt}'">
<br>


Frequently tasks:
<br>
<c:forEach var="t" items="${frequentlyAtt}" varStatus="loop">
    <c:url var="addFreqButton" value="/addFrequentlyToday${prefixAtt}">
        <c:param name="index" value="${loop.index}"/>
    </c:url>
    <c:url var="transferButton" value="/transfer${prefixAtt}">
        <c:param name="index" value="${loop.index}"/>
    </c:url>
    <button onclick="window.location.href='${addFreqButton}'" value="${loop.index}">
            ${t.title}
    </button>

    <br>
</c:forEach>


Your score this ${typeAtt}
${pointsAtt}


</body>
</html>