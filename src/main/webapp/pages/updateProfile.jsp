<%--
  Created by IntelliJ IDEA.
  User: sergeysterlikov
  Date: 16.10.23
  Time: 04:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Profile</title>
</head>
<body>
<form action="/profile/update" method="post" >
  <label>
    <input name="id" type="text" placeholder="id" value="${user.id}">
  </label>
  <label>
    <input name="email" type="email" placeholder="Email" value="${user.email}">
  </label>
  <label>
    <input name="username" type="text" placeholder="Username" value="${user.username}">
  </label>
  <label>
    <input name="password" type="text" placeholder="Password" value="${user.password}">
  </label>
  <label>
    <button>Update</button>
  </label>
</form>
</body>
</html>
