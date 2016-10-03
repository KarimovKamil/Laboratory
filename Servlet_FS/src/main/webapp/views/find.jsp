<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Files</title>
</head>
<body>
<c:forEach items="${list}" var="file">
    ${file}<br>
</c:forEach>
<style>
    body {
        background: url('http://static.srcdn.com/wp-content/uploads/stormtrooper.jpg') no-repeat;
        -moz-background-size: 100%;
        -webkit-background-size: 100%;
        -o-background-size: 100%;
        background-size: 100%;
    }
</style>
</body>
</html>
