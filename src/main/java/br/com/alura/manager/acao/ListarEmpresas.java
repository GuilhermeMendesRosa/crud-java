package br.com.alura.manager.acao;

import br.com.alura.manager.modelo.Banco;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ListarEmpresas implements Acao{
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Banco db = new Banco();

        PrintWriter out = response.getWriter();
        request.setAttribute("empresas", db.getEmpresas());


        return "forward:listarEmpresas.jsp";

    }
}
