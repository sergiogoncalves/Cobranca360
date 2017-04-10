/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Segurancatb02Processo;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Helena
 */
public class Segurancatb02ProcessoRep extends BasicRepositorio<Segurancatb02Processo, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Segurancatb02ProcessoRep() {
        super(Segurancatb02Processo.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public List<Segurancatb02Processo> buscarTodos() {
        //manager.createQuery("select c from Segurancatb02Processo c ORDER BY c.segurancatb02ProcessoPai.descricao");

        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[0];

        query.append(" select c from Segurancatb02Processo c  ");

        return super.getListEntity(query.toString(), elements);

    }

    public List<Segurancatb02Processo> buscarTodosPai() {
        //manager.createQuery("select c from Segurancatb02Processo c where c.segurancatb02ProcessoPai = null");

        StringBuilder query = new StringBuilder();
        Object[] elements = new Object[0];

        query.append(" select c from Segurancatb02Processo c where c.segurancatb02ProcessoPai = null  ");

        return super.getListEntity(query.toString(), elements);

    }

}
