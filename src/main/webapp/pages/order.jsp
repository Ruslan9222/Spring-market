<%--
  Created by IntelliJ IDEA.
  User: simonpirko
  Date: 18.09.23
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<%--<h1>Hello ${myName}!</h1>--%>

<form action="/order" method="post">
    <input type="text" name="name" placeholder="Name">
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <button>Submit</button>
</form>
</body>
</html>
