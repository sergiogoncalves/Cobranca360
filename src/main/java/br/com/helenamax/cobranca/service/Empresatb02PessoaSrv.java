/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.service;

import br.com.helenamax.cobranca.jpa.Transactional;
import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import br.com.helenamax.cobranca.model.Empresatb03PessoaFisica;
import br.com.helenamax.cobranca.model.Empresatb05PessoaEndereco;
import br.com.helenamax.cobranca.model.Empresatb06PessoaContato;
import br.com.helenamax.cobranca.repository.Empresatb02PessoaRep;
import br.com.helenamax.cobranca.repository.Empresatb03PessoaFisicaRep;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class Empresatb02PessoaSrv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresatb02PessoaRep empresatb02PessoaRep;

    @Inject
    private Empresatb03PessoaFisicaRep empresatb03PessoaFisicaRep;

    @Inject
    private Empresatb06PessoaContatoSrv empresatb06PessoaContatoSrv;

    @Inject
    private Empresatb05PessoaEnderecoSrv empresatb05PessoaEnderecoSrv;

    @Transactional
    public void salvarPersist(Empresatb02Pessoa Empresatb02Pessoa) {
        empresatb02PessoaRep.salvar(Empresatb02Pessoa);
    }

    @Transactional
    public void salvarMerge(Empresatb02Pessoa empresatb02Pessoa) {
        empresatb02PessoaRep.alterar(empresatb02Pessoa);
    }

    @Transactional
    public void salvarMerge(Empresatb02Pessoa empresatb02Pessoa, Empresatb03PessoaFisica empresatb03PessoaFisica) {

        if (empresatb02Pessoa.getPessoaCodigo() == 0) {
            empresatb02PessoaRep.salvar(empresatb02Pessoa);
        } else {
            empresatb02PessoaRep.alterar(empresatb02Pessoa);
        }

        empresatb03PessoaFisica.setEmpresatb02Pessoa(empresatb02Pessoa);

        empresatb03PessoaFisicaRep.alterar(empresatb03PessoaFisica);

        if (empresatb02Pessoa.getEmpresatb06PessoaContatos() != null) {
            for (Empresatb06PessoaContato contato : empresatb02Pessoa.getEmpresatb06PessoaContatos()) {

                contato.setEmpresatb02Pessoa(empresatb02Pessoa);

                empresatb06PessoaContatoSrv.salvarMerge(contato);
            }
        }

        if (empresatb02Pessoa.getEmpresatb05PessoaEnderecos() != null) {
            for (Empresatb05PessoaEndereco endereco : empresatb02Pessoa.getEmpresatb05PessoaEnderecos()) {

                endereco.setEmpresatb02Pessoa(empresatb02Pessoa);
                empresatb05PessoaEnderecoSrv.salvarMerge(endereco);
            }
        }

    }

    public List<Empresatb02Pessoa> listar() {
        return empresatb02PessoaRep.listar();
    }

    public Empresatb02Pessoa listarPorId(int codigo) {
        return empresatb02PessoaRep.pesquisarPorId(codigo);
    }

    public List<Empresatb02Pessoa> buscarCredorPorDevedor(Empresatb02Pessoa vo) {
        return empresatb02PessoaRep.buscarCredorByDevedor(vo);
    }
}
