package br.com.alura.manager.servlet;

import br.com.alura.manager.modelo.Banco;
import br.com.alura.manager.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MostrarEmpresaServlet", value = "/mostrarEmpresa")
public class MostrarEmpresaServlete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));

        Banco db = new Banco();
        Empresa empresa = db.buscaEmpresaPelaId(id);

        request.setAttribute("empresa", empresa);
        RequestDispatcher rd = request.getRequestDispatcher("/editarEmpresa.jsp");
        rd.forward(request, response);

    }
}
