/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Empresatb04PessoaJuridica;
import br.com.helenamax.cobranca.repository.Empresatb04PessoaJuridicaRep;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Empresatb04PessoaJuridicaSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresatb04PessoaJuridicaRep empresatb03PessoaFisicaRep;

    @Transactional
    public void salvarPersist(Empresatb04PessoaJuridica empresatb04PessoaJuridica) {
        empresatb03PessoaFisicaRep.salvar(empresatb04PessoaJuridica);
    }

    @Transactional
    public void salvarMerge(Empresatb04PessoaJuridica empresatb04PessoaJuridica) {
        empresatb03PessoaFisicaRep.alterar(empresatb04PessoaJuridica);
    }

    public List<Empresatb04PessoaJuridica> pesquisar(Empresatb04PessoaJuridica empresatb04PessoaJuridica) {
        return empresatb03PessoaFisicaRep.listar(); 
    }

    public List<Empresatb04PessoaJuridica> pesquisarFiltro(Empresatb04PessoaJuridica empresatb04PessoaJuridica) {
        return empresatb03PessoaFisicaRep.criteriaBuscarPessoa(empresatb04PessoaJuridica);
    }

    public List<Empresatb04PessoaJuridica> listar() {
        return empresatb03PessoaFisicaRep.listar();
    }

    public Empresatb04PessoaJuridica listarPorId(int codigo) {
        return empresatb03PessoaFisicaRep.pesquisarPorId(codigo);
    }
}
