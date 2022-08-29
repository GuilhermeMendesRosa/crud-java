<%--
  Created by IntelliJ IDEA.
  User: guilherme
  Date: 28/08/2022
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Página de Login</h1>
  <form action="${linkEntradaServlet}?acao=Login" method="post">
    <input type="text" placeholder="login" name="login">
    <br>
    <input type="password" placeholder="senha" name="senha">
    <input type="submit">


</body>
</html>
