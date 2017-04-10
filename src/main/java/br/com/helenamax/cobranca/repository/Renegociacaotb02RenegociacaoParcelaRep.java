/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Renegociacaotb02RenegociacaoParcela;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class Renegociacaotb02RenegociacaoParcelaRep extends BasicRepositorio<Renegociacaotb02RenegociacaoParcela, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Renegociacaotb02RenegociacaoParcelaRep() {
        super(Renegociacaotb02RenegociacaoParcela.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Renegociacaotb02RenegociacaoParcela getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }
}
