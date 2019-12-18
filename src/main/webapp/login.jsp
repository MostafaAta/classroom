<%--
  Created by IntelliJ IDEA.
  User: MOSTAFA
  Date: 12/17/2019
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<h1>Please .. Login</h1>
<form action="/classroom/login" method="post">
    <fieldset>
        <legend>Legend</legend>
        Username : <input type="text" name="username"/> <br><br>
        Password : <input type="password" name="password"/> <br><br>
        <input type="submit" value="login"/>
    </fieldset>
</form>

<p style="color: red;">${errorMessage}</p>

</body>
</html>
