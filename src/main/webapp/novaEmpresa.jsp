<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Nova Empresa</title>
</head>
<body>
    <form action="<c:url value="entrada?acao=NovaEmpresa"/>" method="post">
        <input type="text" placeholder="nome" name="nome" required>
        <br>
        <input type="date" name="dataDeAbertura" required>
        <br>
        <input type="submit">
    </form>
    
</body>
</html>