/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import br.com.helenamax.cobranca.model.Empresatb06PessoaContato;
import br.com.helenamax.cobranca.repository.Empresatb06PessoaContatoRep;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Empresatb06PessoaContatoSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresatb06PessoaContatoRep empresatb06PessoaContatoRep;

    @Transactional
    public void salvarPersist(Empresatb06PessoaContato empresatb06PessoaContato) {
        empresatb06PessoaContatoRep.salvar(empresatb06PessoaContato);
    }

    @Transactional
    public void salvarMerge(Empresatb06PessoaContato empresatb06PessoaContato) {
        empresatb06PessoaContatoRep.alterar(empresatb06PessoaContato);
    }

    public List<Empresatb06PessoaContato> listar() {
        return empresatb06PessoaContatoRep.listar();
    }

    public Empresatb06PessoaContato listarPorId(int codigo) {
        return empresatb06PessoaContatoRep.getById(codigo);
    }

    public List<Empresatb06PessoaContato> listarPorPessoa(Empresatb02Pessoa vo) {
        return empresatb06PessoaContatoRep.buscarPorPessoa(vo);
    }
    
    @Transactional
    public void excluirContato(Empresatb06PessoaContato vo){
        empresatb06PessoaContatoRep.removerEntidadePorId(vo.getCodigoPessoaContato());
    }
}
