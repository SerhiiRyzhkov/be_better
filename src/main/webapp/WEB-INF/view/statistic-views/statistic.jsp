<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.08.2023
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Date Selection Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="date"] {
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #007AFF;
            border: none;
            border-radius: 5px;
            color: white;
            cursor: pointer;
        }
    </style>
</head>
<body>
Statistic

<br>
<br>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Date Selection Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="date"] {
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #007AFF;
            border: none;
            border-radius: 5px;
            color: white;
            cursor: pointer;
        }
    </style>
</head>
<body>
<br>
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

<div class="container">
    <form action="showStat" method="post">
        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" required>

        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" required>

        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
