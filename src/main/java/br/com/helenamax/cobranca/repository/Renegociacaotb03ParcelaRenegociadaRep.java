/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Renegociacaotb03ParcelaRenegociada;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class Renegociacaotb03ParcelaRenegociadaRep extends BasicRepositorio<Renegociacaotb03ParcelaRenegociada, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Renegociacaotb03ParcelaRenegociadaRep() {
        super(Renegociacaotb03ParcelaRenegociada.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Renegociacaotb03ParcelaRenegociada getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }
}
