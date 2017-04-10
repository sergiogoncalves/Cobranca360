/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import br.com.helenamax.cobranca.model.Empresatb06PessoaContato;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class Empresatb06PessoaContatoRep extends BasicRepositorio<Empresatb06PessoaContato, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Empresatb06PessoaContatoRep() {
        super(Empresatb06PessoaContato.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Empresatb06PessoaContato getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }

    public List<Empresatb06PessoaContato> buscarPorPessoa(Empresatb02Pessoa vo) {

        //manager.createQuery(" select c from Empresatb06PessoaContato c where c.empresatb02Pessoa = ?1 ");
        
        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[1];

        query.append(" select c from Empresatb06PessoaContato c where c.empresatb02Pessoa = ?1 ");

        elements[0] = vo;

        return super.getListEntity(query.toString(), elements);
    }

}
