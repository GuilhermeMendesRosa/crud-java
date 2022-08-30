package br.com.alura.manager.servlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AutorizacaoFilter", value = "/entrada")
public class AutorizacaoFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        System.out.println("\ninicio autorização");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String parametroAcao = request.getParameter("acao");
        HttpSession sessao = request.getSession();

        boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
        boolean ehUmaAcaoProtegida = !(parametroAcao.equals("Login") || parametroAcao.equals("LoginForm"));
        if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
            response.sendRedirect("entrada?acao=LoginForm");
            return;
        }
        chain.doFilter(request, response);
        System.out.println("\nfim autorização");
    }
}
