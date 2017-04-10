/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import br.com.helenamax.cobranca.model.Empresatb03PessoaFisica;
import br.com.helenamax.cobranca.repository.Empresatb03PessoaFisicaRep;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Empresatb03PessoaFisicaSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresatb03PessoaFisicaRep empresatb03PessoaFisicaRep;

    @Transactional
    public void salvarPersist(Empresatb03PessoaFisica empresatb03PessoaFisica) {
        empresatb03PessoaFisicaRep.salvar(empresatb03PessoaFisica);
    }

    @Transactional
    public void salvarMerge(Empresatb03PessoaFisica empresatb03PessoaFisica) {
        empresatb03PessoaFisicaRep.alterar(empresatb03PessoaFisica);
    }

    public List<Empresatb03PessoaFisica> pesquisar(Empresatb03PessoaFisica empresatb03PessoaFisica) {
        return empresatb03PessoaFisicaRep.listar();
    }

    public List<Empresatb03PessoaFisica> pesquisarFiltro(Empresatb03PessoaFisica empresatb03PessoaFisica) {
        return empresatb03PessoaFisicaRep.criteriaBuscarPessoa(empresatb03PessoaFisica);
    }

    public List<Empresatb03PessoaFisica> listar() {
        return empresatb03PessoaFisicaRep.listar();
    }

    public Empresatb03PessoaFisica listarPorId(int codigo) {
        return empresatb03PessoaFisicaRep.pesquisarPorId(codigo);
    }

    public Empresatb03PessoaFisica listarPorPessoa(Empresatb02Pessoa empresatb02Pessoa) {
        return empresatb03PessoaFisicaRep.criteriaBuscaPorPessoa(empresatb02Pessoa);
    }
}
