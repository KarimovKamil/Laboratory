<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>

<c:choose>
    <c:when test="${flag}">
        <H1><c:out value="${message}"/> </H1>
        <style>
            body {
                background: url('http://static.srcdn.com/wp-content/uploads/stormtrooper.jpg') no-repeat;
                -moz-background-size: 100%;
                -webkit-background-size: 100%;
                -o-background-size: 100%;
                background-size: 100%;
            }
        </style>
    </c:when>
    <c:otherwise>
        <H2>Incorrect username or password</H2>
        <style>
            body {
                background: url('http://static.srcdn.com/wp-content/uploads/stormtrooper.jpg') no-repeat;
                -moz-background-size: 100%;
                -webkit-background-size: 100%;
                -o-background-size: 100%;
                background-size: 100%;
            }
        </style>
    </c:otherwise>
</c:choose>

</body>
</html>
