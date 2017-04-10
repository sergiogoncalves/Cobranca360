/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Filatb03FilaDevedor;
import br.com.helenamax.cobranca.model.Filatb04FilaTituloSituacao;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class Filatb04FilaTituloSituacaoRep extends BasicRepositorio<Filatb04FilaTituloSituacao, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Filatb04FilaTituloSituacaoRep() {
        super(Filatb04FilaTituloSituacao.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Filatb04FilaTituloSituacao getById(int codigo) {
        
        return super.pesquisarPorId(codigo);
    }
    
        public Filatb04FilaTituloSituacao buscarPorSigla(String sigla) {

            // manager.createQuery("select c from Filatb04FilaTituloSituacao c where c.sigla = ?1")
        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[1];
        
        query.append(" select c from Filatb04FilaTituloSituacao c where c.sigla = ?1 ");

        elements[0] = sigla;

        return super.getSimpleEntity(query.toString(), elements);
    }

}
