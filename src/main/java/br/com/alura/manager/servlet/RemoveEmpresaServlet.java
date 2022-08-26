package br.com.alura.manager.servlet;

import br.com.alura.manager.modelo.Banco;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveEmpresaServlet", value = "/removerEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));

        Banco db = new Banco();
        db.removeEmpresa(id);
        response.sendRedirect("listarEmpresas");

    }
}
