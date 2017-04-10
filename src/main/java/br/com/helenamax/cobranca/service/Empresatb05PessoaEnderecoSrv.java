/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Empresatb05PessoaEndereco;
import br.com.helenamax.cobranca.repository.Empresatb05PessoaEnderecoRep;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Empresatb05PessoaEnderecoSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresatb05PessoaEnderecoRep empresatb05PessoaEnderecoRep;

    @Transactional
    public void salvarPersist(Empresatb05PessoaEndereco empresatb05PessoaEndereco) {
        empresatb05PessoaEnderecoRep.salvar(empresatb05PessoaEndereco);
    }

    @Transactional
    public void salvarMerge(Empresatb05PessoaEndereco empresatb05PessoaEndereco) {
        empresatb05PessoaEnderecoRep.alterar(empresatb05PessoaEndereco);
    }

    public List<Empresatb05PessoaEndereco> listar() {
        return empresatb05PessoaEnderecoRep.listar();
    }

    public Empresatb05PessoaEndereco listarPorId(int codigo) {
        return empresatb05PessoaEnderecoRep.getById(codigo);
    }
}
