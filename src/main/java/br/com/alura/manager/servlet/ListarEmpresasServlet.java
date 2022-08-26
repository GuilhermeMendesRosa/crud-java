package br.com.alura.manager.servlet;

import br.com.alura.manager.modelo.Banco;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Empresas", value = "/listarEmpresas")
public class ListarEmpresasServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Banco db = new Banco();

        PrintWriter out = response.getWriter();
        request.setAttribute("empresas", db.getEmpresas());
        RequestDispatcher rd = request.getRequestDispatcher("/listarEmpresas.jsp");
        rd.forward(request, response);

    }
}
