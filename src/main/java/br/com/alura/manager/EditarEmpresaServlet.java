package br.com.alura.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "EditarEmpresaServlet", value = "/editaEmpresa")
public class EditarEmpresaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Banco db = new Banco();
        Integer id = Integer.valueOf(request.getParameter("id"));
        Empresa empresa = db.buscaEmpresaPelaId(id);
        empresa.setNome(request.getParameter("nome"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataDeAbertura = null;
        try {
            dataDeAbertura = sdf.parse(request.getParameter("dataDeAbertura"));
        } catch (ParseException e) {
            throw new ServletException(e);
        }
        empresa.setDataDeAbertura(dataDeAbertura);
        response.sendRedirect("listarEmpresas");

    }
}
