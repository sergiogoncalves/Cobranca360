/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Empresatb05PessoaEndereco;
import br.com.helenamax.cobranca.model.Empresatb06PessoaContato;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Helena
 */
public class Empresatb05PessoaEnderecoRep extends BasicRepositorio<Empresatb05PessoaEndereco, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Empresatb05PessoaEnderecoRep() {
        super(Empresatb05PessoaEndereco.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Empresatb05PessoaEndereco getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }

}
