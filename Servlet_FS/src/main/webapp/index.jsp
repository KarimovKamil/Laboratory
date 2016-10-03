<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<H1>Enter directory and mask:</H1>
<form action="find" method="get">
    <div><label>Directory: <input type="text" name="directory"/> </label></div>
    <div><label>Mask or file name: <input type="text" name="mask"/> </label></div>
    <div><input type="submit" value="Find"/></div>
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