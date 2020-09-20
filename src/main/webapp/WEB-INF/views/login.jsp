<%--
  Created by IntelliJ IDEA.
  User: taker
  Date: 17.09.2020
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="user" items="${users}">

    <p>${user.id}, ${user.userName}, ${user.email}</p>
    <a href=<c:url value="/showInfo?id=${user.id}"/>>Pokaż</a>
    <a href=<c:url value="/edit?id=${user.id}"/>>Edutuj</a>
    <a href=<c:url value="/delete?id=${user.id}"/>>Usuń</a>

</c:forEach>
<p>Zarejestruj się</p>
<a href=<c:url value="/createAccount"/>>zarejestruj się</a>

</body>
</html>
