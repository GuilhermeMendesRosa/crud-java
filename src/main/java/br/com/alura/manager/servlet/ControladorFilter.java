package br.com.alura.manager.servlet;

import br.com.alura.manager.acao.Acao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ControladorFilter", value = "/entrada")
public class ControladorFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        System.out.println("\ninicio controlador");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String parametroAcao = request.getParameter("acao");
        String nomeDaClasse = "br.com.alura.manager.acao." + parametroAcao;

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

        String nome = acao.executa(request, response);

        String[] tipoEEndereco = nome.split(":");

        if (tipoEEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            rd.forward(request, response);
        } else if (tipoEEndereco[0].equals("redirect")) {
            response.sendRedirect(tipoEEndereco[1]);
        }


        System.out.println("\nfim controlador");

    }
}
