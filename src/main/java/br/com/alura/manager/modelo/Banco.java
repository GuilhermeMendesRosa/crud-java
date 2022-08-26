package br.com.alura.manager.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
    //Objeto para simular um banco de dados
    private static List<Empresa> empresas = new ArrayList<Empresa>();
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
}
