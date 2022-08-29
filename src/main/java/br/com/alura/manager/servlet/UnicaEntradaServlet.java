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
        String nomeDaClasse = "br.com.alura.manager.acao." + parametroAcao;

        HttpSession sessao = req.getSession();

        boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
        boolean ehUmaAcaoProtegida = !(parametroAcao.equals("Login") || parametroAcao.equals("LoginForm"));
        if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
            resp.sendRedirect("entrada?acao=LoginForm");
            return;
        }

        Class classe = null;
        try {
            classe = Class.forName(nomeDaClasse);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
        Acao acao = null;
        try {
            acao = (Acao) classe.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new ServletException(e);
        }

        String nome = acao.executa(req, resp);

        String[] tipoEEndereco = nome.split(":");

        if (tipoEEndereco[0].equals("forward")) {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            rd.forward(req, resp);
        } else if (tipoEEndereco[0].equals("redirect")) {
            resp.sendRedirect(tipoEEndereco[1]);
        }


    }
}
