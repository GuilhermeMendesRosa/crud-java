<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nova Empresa</title>
</head>
<body>
<h1>
    <c:if test="${not empty empresa}">
        Empresa criada com sucesso: ${empresa}
    </c:if>
    <c:if test="${empty empresa}">
        Nenhuma empresa cadastrada com sucesso!
    </c:if>
</h1>

</body>
</html>
