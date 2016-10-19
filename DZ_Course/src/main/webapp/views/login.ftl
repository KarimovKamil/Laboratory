<!DOCTYPE html>
<html lang="en">
<head>
    <title>SignIn</title>

    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <#if error??>
        <div class="alert">Неверный логин или пароль</div>
    </#if>
    <form class="form-signin" action="login" method="post">
        <input type="text" name="username" class="form-control" placeholder="Введите логин"> <br>
        <input type="password" name="password" class="form-control" placeholder="Введите пароль">
        <button id="login-btn" class="btn btn-sm" type="submit">Войти</button>
</div>
</body>
<script src="js/jquery-1.1-.2.min.js"></script>
</html>