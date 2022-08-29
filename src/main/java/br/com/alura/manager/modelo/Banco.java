package br.com.alura.manager.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
    //Objeto para simular um banco de dados
    private static List<Empresa> empresas = new ArrayList<Empresa>();
    private static List<Usuario> usuarios = new ArrayList<Usuario>();
    private static  Integer chaveSequencial = 1;

    static {
        Empresa empresa1 = new Empresa();
        empresa1.setNome("Alura");
        empresa1.setId(chaveSequencial++);
        Empresa empresa2 = new Empresa();
        empresa2.setNome("Caelum");
        empresa2.setId(chaveSequencial++);
        empresas.add(empresa1);
        empresas.add(empresa2);

        Usuario u1 = new Usuario();
        u1.setLogin("guilherme");
        u1.setSenha("12345");
        Usuario u2 = new Usuario();
        u2.setLogin("guilherme");
        u2.setSenha("12345");

        usuarios.add(u1);
        usuarios.add(u2);
    }

    public void cadastra(Empresa empresa) {
        empresa.setId(Banco.chaveSequencial++);
        empresas.add(empresa);
    }

    public void removeEmpresa(Integer id) {
        Iterator<Empresa> it = empresas.iterator();

        while (it.hasNext()) {
            Empresa emp = it.next();
            if (emp.getId() == id) {
                it.remove();
            }
        }
    }

    public List<Empresa> getEmpresas() {
        return Banco.empresas;
    }

    public Empresa buscaEmpresaPelaId(Integer id) {
        Iterator<Empresa> it = empresas.iterator();

        while (it.hasNext()) {
            Empresa empresa = it.next();
            if (empresa.getId() == id) {
                Empresa empresa1 = empresa;
                return empresa1;
            }
        }
        return null;

    }

    public Usuario existeUsuario(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.ehIgual(login, senha)) {
                return usuario;
            }
        }
        return null;
}
}
