package br.com.alura.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveEmpresaServlet", value = "/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));

        Banco db = new Banco();
        db.removeEmpresa(id);
        response.sendRedirect("listarEmpresas");

    }
}
