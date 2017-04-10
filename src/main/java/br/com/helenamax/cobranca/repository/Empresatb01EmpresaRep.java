/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Helena
 */
public class Empresatb01EmpresaRep extends BasicRepositorio<Empresatb01Empresa, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Empresatb01EmpresaRep() {
        super(Empresatb01Empresa.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Empresatb01Empresa getEmpresaByCnpj(String cnpj) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.getSimpleEntity("select c from Empresatb01Empresa c where c.cnpj = ?1", cnpj);
    }

}
