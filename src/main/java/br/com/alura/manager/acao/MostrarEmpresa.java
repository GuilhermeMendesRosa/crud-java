package br.com.alura.manager.acao;

import br.com.alura.manager.modelo.Banco;
import br.com.alura.manager.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostrarEmpresa {
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));

        Banco db = new Banco();
        Empresa empresa = db.buscaEmpresaPelaId(id);

        request.setAttribute("empresa", empresa);
        RequestDispatcher rd = request.getRequestDispatcher("/editarEmpresa.jsp");
        rd.forward(request, response);

    }
}
