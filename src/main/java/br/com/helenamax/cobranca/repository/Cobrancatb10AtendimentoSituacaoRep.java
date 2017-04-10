/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Cobrancatb10AtendimentoSituacao;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Helena
 */
public class Cobrancatb10AtendimentoSituacaoRep extends BasicRepositorio<Cobrancatb10AtendimentoSituacao, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Cobrancatb10AtendimentoSituacaoRep() {
        super(Cobrancatb10AtendimentoSituacao.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Cobrancatb10AtendimentoSituacao getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }

    public Cobrancatb10AtendimentoSituacao buscarPorSigla(String sigla) {
        //manager.createQuery("select c from Cobrancatb10AtendimentoSituacao c where c.sigla = ?1");

        StringBuilder query = new StringBuilder();

        Object[] elements = new Object[1];

        query.append(" select c from Cobrancatb10AtendimentoSituacao c where c.sigla = ?1 ");

        elements[0] = sigla;

        List<Cobrancatb10AtendimentoSituacao> lista = new ArrayList<>();

        lista = super.getListEntity(query.toString(), elements);

        return lista.get(0);
    }

}
