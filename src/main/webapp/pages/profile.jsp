<%--
  Created by IntelliJ IDEA.
  User: sergeysterlikov
  Date: 16.10.23
  Time: 01:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Create Profile</title>
</head>
<body>
<form action="/profile/create" method="post">
    <label>
        <input name="id" type="text" placeholder="id">
    </label>
    <label>
        <input name="email" type="email" placeholder="Email">
    </label>
    <label>
        <input name="username" type="text" placeholder="Username">
    </label>
    <label>
        <input name="password" type="text" placeholder="Password">
    </label>
    <label>
        <button>Submit</button>
    </label>
</form>
</body>
</html>
