<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="height: 100%">
<head>
    <title>Login Page</title>
    <link href="login-style.css" rel="stylesheet" type="text/css">
</head>
<body>

<p style="color: red;">${errorMessage}</p>

<form action="/classroom/login" method="post">

    <div class="login-box">
        <h1>Login</h1>
        <div class="textbox">
            <i class="fa fa-user" aria-hidden="true"></i>
            <input type="text" placeholder="Username" name="username" required>
        </div>
        <div class="textbox">
            <i class="fa fa-lock" aria-hidden="true"></i>
            <input type="password" placeholder="Password" name="password" required>
        </div>
        <input class="btn" type="submit" value="login">
    </div>

</form>

</body>
</html>
