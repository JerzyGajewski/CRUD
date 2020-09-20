<%--
  Created by IntelliJ IDEA.
  User: taker
  Date: 18.09.2020
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/edit" method="post">
    <input type="text" name="id" style="display: none" value="${param.id}">
    <input type="text" name="userName" placeholder="userName">
    <input type="text" name="email" placeholder="email">
    <input type="text" name="password" placeholder="password">
    <button type="submit">Update</button>

</form>
</body>
</html>
