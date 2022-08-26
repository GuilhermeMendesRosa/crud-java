package br.com.alura.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Nova Empresa", value = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Cadastrando Nova Empresa");
        String nomeEmpresa = request.getParameter("nome");
        String stringData = request.getParameter("dataDeAbertura");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date dataDeAbertura = null;
        try {
            dataDeAbertura = sdf.parse(stringData);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);
        empresa.setDataDeAbertura(dataDeAbertura);

        Banco db = new Banco();
        db.cadastra(empresa);

        response.sendRedirect("listarEmpresas");

    }
}
