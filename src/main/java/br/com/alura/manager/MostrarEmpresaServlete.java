package br.com.alura.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MostrarEmpresaServlet", value = "/mostraEmpresa")
public class MostrarEmpresaServlete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));

        Banco db = new Banco();
        Empresa empresa = db.buscaEmpresaPelaId(id);

        request.setAttribute("empresa", empresa);
        RequestDispatcher rd = request.getRequestDispatcher("/editaEmpresa.jsp");
        rd.forward(request, response);

    }
}
