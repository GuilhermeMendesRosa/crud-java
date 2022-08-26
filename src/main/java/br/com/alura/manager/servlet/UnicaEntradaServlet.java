package br.com.alura.manager.servlet;

import br.com.alura.manager.acao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UnicaEntradaServlet", value = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parametroAcao = req.getParameter("acao");

        if (parametroAcao.equals("ListarEmpresas")) {
            ListarEmpresas acao = new ListarEmpresas();
            acao.executa(req, resp);
        } else if (parametroAcao.equals("RemoverEmpresa")) {
            RemoverEmpresa acao = new RemoverEmpresa();
            acao.executa(req, resp);
        } else if (parametroAcao.equals("MostrarEmpresa")) {
            MostrarEmpresa acao = new MostrarEmpresa();
            acao.executa(req, resp);
        } else if (parametroAcao.equals("EditarEmpresa")) {
            EditarEmpresa acao = new EditarEmpresa();
            acao.executa(req, resp);
        } else if (parametroAcao.equals("NovaEmpresa")) {
            NovaEmpresa acao = new NovaEmpresa();
            acao.executa(req, resp);
        }

    }
}
