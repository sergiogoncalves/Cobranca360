/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Cobrancatb07Atendimento;
import br.com.helenamax.cobranca.model.Cobrancatb08AtendimentoTituloParcela;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Helena
 */
public class Cobrancatb08AtendimentoTituloParcelaRep extends BasicRepositorio<Cobrancatb08AtendimentoTituloParcela, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Cobrancatb08AtendimentoTituloParcelaRep() {
        super(Cobrancatb08AtendimentoTituloParcela.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Cobrancatb08AtendimentoTituloParcela getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }

    public List<Cobrancatb08AtendimentoTituloParcela> buscarPorAtendimento(Cobrancatb07Atendimento vo) {
        //manager.createQuery("select c from Cobrancatb08AtendimentoTituloParcela c  where c.cobrancatb07Atendimento = ?1");

        StringBuilder query = new StringBuilder();

        Object[] elements = new Object[1];

        query.append(" select c from Cobrancatb08AtendimentoTituloParcela c  where c.cobrancatb07Atendimento = ?1 ");

        elements[0] = vo;

        return super.getListEntity(query.toString(), elements);

    }

}
