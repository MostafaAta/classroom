<%--
  Created by IntelliJ IDEA.
  User: MOSTAFA
  Date: 12/17/2019
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
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
