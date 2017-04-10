/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Helena
 */
public class Empresatb02PessoaRep extends BasicRepositorio<Empresatb02Pessoa, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Empresatb02PessoaRep() {
        super(Empresatb02Pessoa.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public List<Empresatb02Pessoa> buscarCredorByDevedor(Empresatb02Pessoa vo) {
        
        //manager.createQuery("select c from Empresatb02Pessoa c WHERE c IN( SELECT DISTINCT t.empresatb02PessoaCredor FROM Cobrancatb01Titulo t where t.empresatb02PessoaDevedor = ?1) ");

        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[1];

        query.append(" select c from Empresatb02Pessoa c WHERE c IN( SELECT DISTINCT t.empresatb02PessoaCredor FROM Cobrancatb01Titulo t where t.empresatb02PessoaDevedor = ?1) ");

        elements[0] = vo;

        return super.getListEntity(query.toString(), elements);
    }

}
