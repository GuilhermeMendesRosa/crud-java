package br.com.alura.manager.acao;

import br.com.alura.manager.modelo.Banco;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoverEmpresa implements Acao {
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));

        Banco db = new Banco();
        db.removeEmpresa(id);
//        response.sendRedirect("entrada?acao=ListarEmpresas");

        return "redirect:entrada?acao=ListarEmpresas";
    }
}
