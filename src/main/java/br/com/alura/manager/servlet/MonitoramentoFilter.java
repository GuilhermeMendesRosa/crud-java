package br.com.alura.manager.servlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter("/entrada")
public class MonitoramentoFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("\ninicio monitoramento");

        long antes = System.currentTimeMillis();

        String acao = request.getParameter("acao");

        chain.doFilter(request, response);

        long depois = System.currentTimeMillis();
        System.out.printf("\nTempo de execução %s: %d",acao, (depois - antes));
        System.out.println("\nfim monitoramento");
    }
}
