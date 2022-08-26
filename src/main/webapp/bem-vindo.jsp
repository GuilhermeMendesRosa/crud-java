<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CRUD</title>
</head>
<body>

<h1>CRUD</h1>

<a href="<c:url value="/novaEmpresa.jsp"/>">Adicionar empresa</a>
<br>
<br>
<a href="<c:url value="/entrada?acao=ListarEmpresas"/>">Listar empresas</a>
</body>
</html>