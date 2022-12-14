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

public class NovaEmpresa implements Acao {
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

//        response.sendRedirect("entrada?acao=ListarEmpresas");

        return "redirect:entrada?acao=ListarEmpresas";

    }
}
