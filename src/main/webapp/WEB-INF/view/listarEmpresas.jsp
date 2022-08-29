<%@ page import="br.com.alura.manager.modelo.Empresa" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nova Empresa</title>
</head>
    <body>
    <c:import url="logout-parcial.jsp"/>
    <h1>Usuario: ${usuarioLogado.login}</h1>
    <h2>Listar Empresas</h2>
        <ul>
            <c:forEach items="${empresas}" var="empresa">
                <li>${empresa.nome} - <fmt:formatDate value="${empresa.dataDeAbertura}" pattern="dd/MM/yyyy"/>
                    - <a href="/gerenciador/entrada?acao=RemoverEmpresa&id=${empresa.id}">remover</a>
                    - <a href="/gerenciador/entrada?acao=MostrarEmpresa&id=${empresa.id}">editar</a>
                </li>

            </c:forEach>
        </ul>

    </body>
</html>
