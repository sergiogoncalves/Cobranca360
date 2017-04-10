/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Filatb03FilaDevedor;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class Filatb03FilaDevedorRep extends BasicRepositorio<Filatb03FilaDevedor, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Filatb03FilaDevedorRep() {
        super(Filatb03FilaDevedor.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Filatb03FilaDevedor getById(int codigo) {
        
        return super.pesquisarPorId(codigo);
    }

}
