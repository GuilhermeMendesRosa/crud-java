<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edita Empresa</title>
</head>
<body>
<h1>Editar</h1>
    <form action="<c:url value="/entrada?acao=EditarEmpresa&id=${empresa.id}"/>" method="post">
        <input type="text" placeholder="nome" name="nome" required value="${empresa.nome}">
        <br>
        <input type="date" name="dataDeAbertura" required value="${empresa.dataDeAbertura}">
        <br>
        <input type="submit">
    </form>
    
</body>
</html>