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
    <li>
        <p>${user.id}</p>
        <p>${user.userName}</p>
        <p>${user.email}</p>
    </li>
</c:forEach>
    <p>Zarejestruj się</p>
    <a href=
       <c:url value="/createAccount"/>>zarejestruj się</a>

</body>
</html>
