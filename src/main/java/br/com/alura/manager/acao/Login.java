package br.com.alura.manager.acao;

import br.com.alura.manager.modelo.Banco;
import br.com.alura.manager.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Acao{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Banco db = new Banco();
        Usuario usuario = db.existeUsuario(login, senha);


        System.out.printf("Logando: %s", login);

        if (usuario != null) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuarioLogado", usuario);
            return "redirect:entrada?acao=ListarEmpresas";
        } else {
            return "redirect:entrada?acao=LoginForm";

        }

    }
}
