/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Cobrancatb03TituloTipo;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Helena
 */
public class Cobrancatb03TituloTipoRep extends BasicRepositorio<Cobrancatb03TituloTipo, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Cobrancatb03TituloTipoRep() {
        super(Cobrancatb03TituloTipo.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Cobrancatb03TituloTipo getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }

    public Cobrancatb03TituloTipo buscarPorSigla(String sigla) {

        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[1];
        
        query.append(" select c from Cobrancatb03TituloTipo c where c.sigla = ?1 ");

        elements[0] = sigla;

        return super.getSimpleEntity(query.toString(), elements);
    }

}
