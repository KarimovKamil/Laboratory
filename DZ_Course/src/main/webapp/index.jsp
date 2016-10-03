<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <H1>Enter your name:</H1>
    <form action="hello" method="get">
        <div><label>Name: <input type="text" name="name"/> </label></div>
        <div><label>Password: <input type="text" name="password"/> </label></div>
        <div><input type="submit" value="Submit"/></div>
    </form>
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
