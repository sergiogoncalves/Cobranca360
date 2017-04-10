/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.model.Geraltb02TipoContato;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Helena
 */
public class Geraltb02TipoContatoRep extends BasicRepositorio<Geraltb02TipoContato, Integer> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Geraltb02TipoContatoRep() {
        super(Geraltb02TipoContato.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public Geraltb02TipoContato getById(int codigo) {
        //manager.createQuery("select c from Empresatb01Empresa c where c.cnpj = ?1")
        return super.pesquisarPorId(codigo);
    }

}
