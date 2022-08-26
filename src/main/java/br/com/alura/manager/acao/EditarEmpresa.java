package br.com.alura.manager.acao;

import br.com.alura.manager.modelo.Banco;
import br.com.alura.manager.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditarEmpresa {
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        response.sendRedirect("entrada?acao=ListarEmpresas");

    }
}
